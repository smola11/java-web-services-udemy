package com.maciej.wsdlfirstws.handlers;

import javax.xml.namespace.QName;
import javax.xml.soap.*;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.util.Iterator;
import java.util.Set;

public class SiteHandler implements SOAPHandler<SOAPMessageContext> {

    @Override
    public Set<QName> getHeaders() {
        System.out.println("getHeaders");
        return null;
    }

    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        System.out.println("handleMessage");
        // Retrieve headers only on the request message
        Boolean isResponse = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);// it is set by CXF at runtime
        if (!isResponse) { // if it is request
            SOAPMessage soapMessage = context.getMessage();
            try {
                SOAPEnvelope envelope = soapMessage.getSOAPPart().getEnvelope();
                SOAPHeader header = envelope.getHeader(); // Similar to DOM/XML parsing
                Iterator childElements = header.getChildElements();
                while (childElements.hasNext()) {
                    Node node = (Node) childElements.next();
                    String name = node.getLocalName();
                    if (name != null && name.equals("SiteName")) { // "SiteName" - name of the header
                        System.out.println("Site Name is ===== " + node.getValue());
                    }
                }
            } catch (SOAPException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Response on the way");
        }
        return true;
    }

    @Override
    public boolean handleFault(SOAPMessageContext context) { // called when Exception is thrown by web service provider
        System.out.println("handleFault");
        return false;
    }

    @Override
    public void close(MessageContext context) { // called at the end of the entire flow
        System.out.println("close");

    }
}

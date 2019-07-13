package com.maciej.UserTokenClient.client;

import org.apache.wss4j.common.ext.WSPasswordCallback;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;

public class UTPasswordCallback implements CallbackHandler {

    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        System.out.println("IN HANDLE");
        for (Callback callback : callbacks) {
            WSPasswordCallback wpc = (WSPasswordCallback) callback;
            if (wpc.getIdentifier().equals("cxf")) {
                wpc.setPassword("cxf");
                return;
            }
        }
    }
}

package com.bharath.ws.soap;

import org.apache.wss4j.common.ext.WSPasswordCallback;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UTPasswordCallback implements CallbackHandler {

    // In-memory usernames and passwords
    private Map<String, String> passwords = new HashMap<>();

    public UTPasswordCallback() {
        passwords.put("bharath", "bharath");
        passwords.put("cxf", "cxf");
    }

    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        // The callbacks will have username that is coming in the request
        for (Callback callback : callbacks) {
            WSPasswordCallback passwordCallback = (WSPasswordCallback) callback;
            String userName = passwordCallback.getIdentifier();// gives us username coming in the request; we could make LDAP call or database search
            System.out.println("INCOMING USERNAME: " + userName);
            String password = passwords.get(userName);

            if (password != null) {
                passwordCallback.setPassword(password);
                return;
            }
        }
    }
}

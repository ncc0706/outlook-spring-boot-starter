package io.github.ncc0706.cache;

import com.microsoft.aad.msal4j.*;
import io.github.ncc0706.properties.MSALProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.MalformedURLException;
import java.util.Collections;

public class TokenService {

    @Autowired
    private MSALProperties msAlProperties;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public String getAccessToken() {
        try {
            IClientSecret clientSecret = ClientCredentialFactory.createFromSecret(msAlProperties.getSecret());
            ConfidentialClientApplication application = ConfidentialClientApplication.builder(msAlProperties.getClientId(), clientSecret).authority(msAlProperties.getAuthority()).build();

            ClientCredentialParameters clientCredentialParam = ClientCredentialParameters.builder(Collections.singleton(msAlProperties.getScope())).build();

            IAuthenticationResult authenticationResult = application.acquireToken(clientCredentialParam).join();
            return authenticationResult.accessToken();
        } catch (MalformedURLException e) {
            logger.error("", e);
            throw new RuntimeException("授权地址格式错误");
        }
    }

}

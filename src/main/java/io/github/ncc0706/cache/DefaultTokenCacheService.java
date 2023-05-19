package io.github.ncc0706.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by IntelliJ IDEA. <br/>
 *
 * @author NiuYuxian <br/>
 * @since 2023-05-19 11:55:49 <br/>
 */
public class DefaultTokenCacheService extends AbstractTokenCacheService {

    @Autowired
    private TokenService tokenService;

    private Map<String, MSALToken> msalTokenMap = new ConcurrentHashMap<>();

    @Override
    public String getToken() {
        MSALToken cacheMsalToken = msalTokenMap.get(ACCESSTOKEN);
        long currentSecond = System.currentTimeMillis() / 1000;
        if (ObjectUtils.isEmpty(cacheMsalToken) || currentSecond > cacheMsalToken.getExpiresIn()) {
            String accessToken = tokenService.getAccessToken();
            MSALToken msalToken = new MSALToken();
            msalToken.setAccessToken(accessToken);
            msalToken.setExpiresIn(currentSecond + 3500);
            msalTokenMap.put(ACCESSTOKEN, msalToken);
            return accessToken;
        }
        return cacheMsalToken.getAccessToken();

    }
}

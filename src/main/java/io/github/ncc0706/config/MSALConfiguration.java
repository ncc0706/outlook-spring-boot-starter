package io.github.ncc0706.config;

import io.github.ncc0706.cache.DefaultTokenCacheService;
import io.github.ncc0706.cache.ITokenCacheService;
import io.github.ncc0706.cache.TokenService;
import io.github.ncc0706.properties.MSALProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(MSALProperties.class)
public class MSALConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public ITokenCacheService jasperReportService() {
        return new DefaultTokenCacheService();
    }

    @Bean
    public TokenService tokenService(){
        return new TokenService();
    }
}

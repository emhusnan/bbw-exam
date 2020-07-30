package id.emhusnan.exam.bbw.authorization;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServer extends AuthorizationServerConfigurerAdapter {

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.pathMapping("/oauth/token", "/api/auth/token");
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        //TODO: password encoder, temporary make it plain with {noop}
        //TODO: authenticate from model User, should be done clients.jdbc(new User())
        clients.inMemory().withClient("husnan")
                .secret("{noop}123")
                .authorizedGrantTypes("client_credentials").scopes("user-info", "va-transaction")
                .accessTokenValiditySeconds(600);
    }


}

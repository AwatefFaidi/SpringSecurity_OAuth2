package com.example.SpringBootSecurityOAuth2Example.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
 /*
  * 
  * 
  * Authorization Server
The authorization server is the server authorizing the client app to access the resources of the resource owner.
  * */
@Configuration
@EnableAuthorizationServer
public class OAuthConfiguration extends AuthorizationServerConfigurerAdapter {
	
@Autowired
  @Qualifier("authenticationManagerBean")
  private AuthenticationManager authenticationManager;
  
  @Autowired
  UserDetailsService userDetailsService;
  
  @Autowired
  private PasswordEncoder oauthClientPasswordEncoder;
  @Autowired
  private BCryptPasswordEncoder passwordEncoder;
  @Override
  public void configure(final AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
    oauthServer.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()").allowFormAuthenticationForClients();
    
    
    //.passwordEncoder(oauthClientPasswordEncoder);
  
  }
  
  /*
   * Registers a client with client-id ‘fooClientId’ and password ‘ secret’ and the roles and scope they are allowed.

Specifies authorized grant types (password, authorization_code, refresh_token).

Specifies the JwtTokenStore to store tokens.**/
  
  
  @Override
  public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
    clients.inMemory()
      .withClient("fooClientId").secret(passwordEncoder.encode("secret"))
      .authorizedGrantTypes("password", "authorization_code", "refresh_token").scopes("read","write")
      .autoApprove(true);
  }
  
  
  @Override
  public void configure(final AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
    endpoints.tokenStore(tokenStore()).authenticationManager(authenticationManager).accessTokenConverter(defaultAccessTokenConverter())
      .userDetailsService(userDetailsService);
  }
  
  @Bean
  public TokenStore tokenStore(){
    return new JwtTokenStore(defaultAccessTokenConverter());
  }
  
  
  
  @Bean
  public JwtAccessTokenConverter defaultAccessTokenConverter() {
    JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
    converter.setSigningKey("123");
    return converter;
  }
}

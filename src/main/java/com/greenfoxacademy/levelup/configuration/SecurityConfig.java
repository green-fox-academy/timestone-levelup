package com.greenfoxacademy.levelup.configuration;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;


@Configuration
@EnableOAuth2Sso
public class SecurityConfig {

  public class UiSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {

      http
              .csrf()
              .disable()
              .antMatcher("/**")
              .authorizeRequests()
              .antMatchers("/api/**")
              .permitAll()
              .anyRequest()
              .authenticated();

      /*http.antMatcher("/**")
              .authorizeRequests()
              .antMatchers("/", "/api**")
              .permitAll()
              .anyRequest()
              .authenticated();*/
      /*http.authorizeRequests()
              .antMatchers("/api**")
              .permitAll()
              .anyRequest()
              .authenticated()
              .and()
              .oauth2Login();
              //.loginPage("/oauth_login");*/
      /*http
              .authorizeRequests()
              .antMatchers("/badgelibrary")
              .authenticated()
              .and()
              .oauth2Login()
              .and()
              .authorizeRequests()
              //.and()
             // .logout().logoutUrl("/logout").logoutSuccessUrl("/");
              .antMatchers("/", "/api/**")
              .permitAll();*/
    }
  }

  /*@Configuration
  @Order(1)
  public class ApiAndHomeConfiguration extends WebSecurityConfigurerAdapter {
    protected void configure(HttpSecurity http) throws Exception {
      http
              .authorizeRequests()
              .antMatchers("/api/**").permitAll()
              .antMatchers("/").permitAll();
    }
  }

  @Configuration
  @Order(2)
  @EnableOAuth2Sso

  public class BasicConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
      http
              .authorizeRequests()
              .anyRequest().authenticated()
              .and()
              .formLogin()
              .failureHandler(customAuthenticationFailureHandler());
    }
  }*/

  @Bean
  public AuthenticationFailureHandler customAuthenticationFailureHandler() {
    return new CustomAuthenticationFailureHandler();
  }
}

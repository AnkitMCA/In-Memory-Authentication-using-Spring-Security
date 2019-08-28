package com.spring.inmemoryauthentication.security.config;

import com.spring.inmemoryauthentication.security.handler.AuthenticationSuccessHandler;
import com.spring.inmemoryauthentication.security.handler.LogoutSuccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * The type Security config.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * The Authentication success handler.
     */
    @Autowired
    AuthenticationSuccessHandler authenticationSuccessHandler;
    /**
     * The Logout success.
     */
    @Autowired
    LogoutSuccess logoutSuccess;

    //Method for defining inMemoryAuthentication in spring security 5.0 or more by adding {noop} before password string.

    /**
     * Configure global.
     *
     * @param auth the auth
     * @throws Exception the exception
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("User1")
                .password("{noop}password")
                .roles("USER")
                .and()
                .withUser("User2")
                .password("{noop}password")
                .roles("ADMIN");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/other").hasAuthority("ROLE_USER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .successHandler(authenticationSuccessHandler)
                .loginPage("/login")
                .permitAll()
                .loginProcessingUrl("/loginUrl")
                .defaultSuccessUrl("/")
                .and()
                .logout().permitAll()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
                .logoutSuccessHandler(logoutSuccess);
    }
}

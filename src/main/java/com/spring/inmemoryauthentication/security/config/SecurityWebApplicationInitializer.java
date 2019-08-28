package com.spring.inmemoryauthentication.security.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * The type Security web application initializer.
 */
public class SecurityWebApplicationInitializer
        extends AbstractSecurityWebApplicationInitializer {

    /**
     * Instantiates a new Security web application initializer.
     */
    public SecurityWebApplicationInitializer() {
        super(SecurityConfig.class);
    }
}

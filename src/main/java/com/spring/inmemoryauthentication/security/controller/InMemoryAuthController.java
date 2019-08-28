package com.spring.inmemoryauthentication.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * The type In memory auth controller.
 */
@RestController
@RequestMapping("/")
public class InMemoryAuthController {

    /**
     * Index string.
     *
     * @return the string
     */
    @GetMapping("")
    public String index() {
        return "Successfully logged-in.";
    }

    /**
     * Login model and view.
     *
     * @return the model and view
     */
    @GetMapping("login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
    }

    @GetMapping("/other")
    public String otherPage() {
        return "Another Page.";
    }

}

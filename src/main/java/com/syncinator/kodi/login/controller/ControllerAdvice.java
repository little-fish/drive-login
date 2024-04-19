package com.syncinator.kodi.login.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * @since 1.0.0
 */
@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    @ModelAttribute(name = "version")
    public String version(@Value("${version:unknown}") String version) {
        return version;
    }
}

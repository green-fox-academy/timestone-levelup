package com.greenfoxacademy.levelup.configuration;

import org.springframework.security.core.Authentication;

public interface IAuthenticationFacade {
  Authentication getAuthentication();
}

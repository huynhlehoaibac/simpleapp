package com.cross.solutions.simpleapp.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author huynhlehoaibac
 * @since 0.0.1-SNAPSHOT
 */
@RequestMapping("/greeting")
@Controller
public class GreetingController {

  @GetMapping({"", "/"})
  public String greeting(
      @AuthenticationPrincipal OidcUser oidcUser,
      Model model,
      @RegisteredOAuth2AuthorizedClient("simpleapp") OAuth2AuthorizedClient client) {
    model.addAttribute("username", oidcUser.getName());
    model.addAttribute("accessToken", client.getAccessToken());
    model.addAttribute("idToken", oidcUser.getIdToken());

    return "greeting";
  }
}

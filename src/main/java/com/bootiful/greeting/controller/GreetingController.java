package com.bootiful.greeting.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bootiful.common.security.SecuredWithClient;
import com.bootiful.common.security.SecuredWithUser;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

  @GetMapping
  public String greeting() {
    return "Hello!!!";
  }

  @SecuredWithUser
  @GetMapping("/user")
  public String greetingWithUser() {
    return "Hello, The requested user.";
  }

  @SecuredWithClient
  @GetMapping("/client")
  public String greetingWithClient() {
    return "Hello, The requested client.";
  }
}

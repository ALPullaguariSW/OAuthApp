package com.oauth.ejemplo.demo.Security;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api")
public class SecureController {

    @GetMapping("/user")
    public ResponseEntity<String> getUser(Principal principal) {
        return ResponseEntity.ok("Bienvenido " + principal.getName());
    }
}
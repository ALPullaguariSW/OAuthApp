package com.oauth.ejemplo.demo;

import com.oauth.ejemplo.demo.Entities.User;
import com.oauth.ejemplo.demo.UserRepository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void saveUser(OAuth2AuthenticationToken authentication, OAuth2AuthorizedClient client) {
        String username = authentication.getPrincipal().getAttribute("login");
        String email = authentication.getPrincipal().getAttribute("email");
        String accessToken = client.getAccessToken().getTokenValue();

        User user = new User(null, username, email, accessToken);
        userRepository.save(user);
    }
}
package com.shalash.task6;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final UserRepository userRepository;

    public CustomOAuth2UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) {
        OAuth2User oAuth2User = super.loadUser(userRequest);

        String provider = userRequest.getClientRegistration().getRegistrationId();
        String oauthId = oAuth2User.getName(); // Unique user ID from provider
        String email = oAuth2User.getAttribute("email");
        String name = oAuth2User.getAttribute("name");
        String profilePicture = oAuth2User.getAttribute("picture");

        // Check if the user exists
        Optional<User> existingUser = userRepository.findByOauthProviderAndOauthId(provider, oauthId);

        User user = existingUser.orElseGet(User::new);
        user.setOauthProvider(provider);
        user.setOauthId(oauthId);
        user.setName(name);
        user.setEmail(email);
        user.setProfilePicture(profilePicture);

        log.info("new user: {}", user.getEmail());

        userRepository.save(user);

        return oAuth2User;
    }
}

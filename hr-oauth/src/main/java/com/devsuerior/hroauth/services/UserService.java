package com.devsuerior.hroauth.services;

import com.devsuerior.hroauth.clients.UserClient;
import com.devsuerior.hroauth.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserClient userClient;

    public User findByEmail(String email) {
        User user = userClient.findByEmail(email);

        if (user == null) {
            logger.error("Email not found {}", email);
            throw new IllegalArgumentException("Email not found.");
        }

        logger.info("Email found {}", email);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userClient.findByEmail(username);

        if (user == null) {
            logger.error("Email not found {}", username);
            throw new UsernameNotFoundException("Email not found.");
        }

        logger.info("Email found {}", username);
        return user;
    }
}

package me.phong.blog.security;

import me.phong.blog.security.service.CustomUserDetails;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;


public class SecurityUtil {

    public static Optional<CustomUserDetails> getCurrentUserLogin() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        return Optional.ofNullable(securityContext.getAuthentication())
                .map(authentication -> {
                    if (authentication.getPrincipal() instanceof CustomUserDetails) {
                        return (CustomUserDetails) authentication.getPrincipal();
                    }
                    return null;
                });
    }
}

package org.acme.security;

import io.smallrye.jwt.build.Jwt;
import java.time.Duration;
import java.util.Set;

public class JWT {

    public static String generateToken(String username, String role) {
        return Jwt.issuer("https://elearning.local")
                  .upn(username)
                  .groups(Set.of(role))
                  .expiresIn(Duration.ofHours(24)) // Temps d'expiration du token
                  .sign();
    }
}

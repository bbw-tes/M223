package ch.zli.m223.auth;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;

public class JwtUtils {
    public static final String SECRET_KEY = "OMAZLTERQOZGELNVQOKVBLPXAWQIOSQYYRWYOOCPLVICSXTVSGMGXPSVMHBOSHAEZOJXIGJIEPQDNGAAKITGKWWUEPRXDAGESTAG";

    public static String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600_000)) // 1 hour
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }
}

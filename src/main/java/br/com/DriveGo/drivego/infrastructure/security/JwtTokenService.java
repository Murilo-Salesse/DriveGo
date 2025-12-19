package br.com.DriveGo.drivego.infrastructure.security;

import br.com.DriveGo.drivego.core.enums.Roles;
import br.com.DriveGo.drivego.core.gateways.JwtTokenGateway; // ← Importar
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.UUID;

@Component
public class JwtTokenService implements JwtTokenGateway {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private long expiration;

    private Key getKey() {
        return Keys.hmacShaKeyFor(secret.getBytes());
    }

    @Override // ← Implementa o método da interface
    public String generateToken(UUID userId, String email, Roles role) {
        return Jwts.builder()
                .setSubject(email)
                .claim("userId", userId.toString())
                .claim("role", role.name())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    @Override // ← Implementa o método da interface
    public String getEmail(String token) {
        return getClaims(token).getSubject();
    }

    public Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    @Override // ← Implementa o método da interface
    public boolean isValid(String token) {
        try {
            getClaims(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
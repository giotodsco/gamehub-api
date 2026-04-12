package com.todesco.gamehub.config;

import com.todesco.gamehub.dtos.request.JWTUserData;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class SecurityFilter extends OncePerRequestFilter {

    private final TokenConfig tokenConfig;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorizateHeader = request.getHeader("Authorization");
        if(Strings.isNotEmpty(authorizateHeader) && authorizateHeader.startsWith("Bearer")){
            String token = authorizateHeader.substring("Bearer ".length());

            Optional<JWTUserData> jwtUserDataOpt = tokenConfig.verifyToken(token);
            if(jwtUserDataOpt.isPresent()) {
                JWTUserData jwtUserData = jwtUserDataOpt.get();

                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(jwtUserData, null, null);
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
            filterChain.doFilter(request, response);
        } else {
            filterChain.doFilter(request, response);
        }

    }
}

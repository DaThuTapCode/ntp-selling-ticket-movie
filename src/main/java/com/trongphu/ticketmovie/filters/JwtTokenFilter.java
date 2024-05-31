package com.trongphu.ticketmovie.filters;

import com.trongphu.ticketmovie.component.JwtTokenUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.modelmapper.internal.Pair;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Trong Phu on 5/20/2024
 *
 * @author Trong Phu
 */
@Component
@RequiredArgsConstructor
public class JwtTokenFilter extends OncePerRequestFilter {
    @Value("${api.prefix}")
    private String apiPrefix;

    private final UserDetailsService userDetailsService;
    private final JwtTokenUtil jwtTokenUtil;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain)
            throws ServletException, IOException {
        try{
            if (isByPassToken(request)) {
                filterChain.doFilter(request, response); //Cho đi qua
                return;
            }
            final String authHeader = request.getHeader("Authorization");
            if (authHeader == null && !authHeader.startsWith("Bearer ")) {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
            }
                final String token = authHeader.substring(7);
                final String userName = jwtTokenUtil.extractUserName(token);
                if(userName != null
                        && SecurityContextHolder.getContext().getAuthentication() == null){
                    UserDetails userDetails =  userDetailsService.loadUserByUsername(userName);
                    if(jwtTokenUtil.validateToke(token, userDetails)){
                        UsernamePasswordAuthenticationToken authenticationToken =
                                new UsernamePasswordAuthenticationToken(
                                        userDetails,
                                        null,
                                        userDetails.getAuthorities()
                                );
                        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                    }
                }
                filterChain.doFilter(request, response); //Cho đi qua

        }catch (Exception exception){
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
        }

    }

    private boolean isByPassToken(@NonNull HttpServletRequest request) {
        final List<Pair<String, String>> bypasstoken = Arrays.asList(
//                Pair.of(String.format("%s/movies/status3", apiPrefix), "GET"),
                Pair.of(String.format("%s/movies", apiPrefix), "GET"),
                Pair.of(String.format("%s/movies/status1", apiPrefix), "GET"),
                Pair.of(String.format("%s/users/register", apiPrefix), "POST"),
                Pair.of(String.format("%s/users/login", apiPrefix), "POST"),
                Pair.of(String.format("%s/theaters/all", apiPrefix), "GET"),
                Pair.of(String.format("%s/theaters", apiPrefix), "GET")
        );
        for (Pair<String, String> bypassToken : bypasstoken) {
            if (request.getServletPath().contains(bypassToken.getLeft())
                    && request.getMethod().equals((bypassToken.getRight()))) {
                return true;
            }
        }
        return false;
    }

}

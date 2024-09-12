package com.everydayBanking.everydayBank.securityconfig;

import com.everydayBanking.everydayBank.service.CustomerUserDetailsService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Date;

@Component
public class JwtFilter extends OncePerRequestFilter {

    JwtUtils jwtUtils;
    CustomerUserDetailsService customerUserDetailsService;

    public  JwtFilter(JwtUtils jwtUtils, CustomerUserDetailsService customerUserDetailsService){
        this.jwtUtils = jwtUtils;
        this.customerUserDetailsService = customerUserDetailsService;
    }
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");
        String token = null;
        String username = null;

        if(authHeader != null && authHeader.startsWith("Bearer ")){
            token = authHeader.substring(7);
            username = jwtUtils.getUsernameFromToken(token);
        }
        if (username !=null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails customerDetails = customerUserDetailsService.loadUserByUsername(username);
//
            if(jwtUtils.validateToken(token)){
                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(customerDetails, null, customerDetails.getAuthorities());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                Setting the user as authenticated
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        filterChain.doFilter(request, response);
    }

}
package com.example.democ0222i1sercurity.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@ComponentScan
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String tagetURL = determineTargetUrl(authentication);
        if (response.isCommitted()){
            return;
        }
        redirectStrategy.sendRedirect(request, response, tagetURL);
    }

    private String determineTargetUrl(Authentication authentication) {
        String url = "";

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        List<String> roles = new ArrayList<>();

        for (GrantedAuthority e: authorities
             ) {
            roles.add(e.getAuthority());
        }
        if (roles.contains("ROLE_ADMIN")){
            url= "/admin";
        }
        else if (roles.contains("ROLE_USER")){
            url="/user";
        }
        else if (roles.contains("ROLE_DEMO")){
            url="/demo";
        }
        else {
            url="/khongcoquyen";
        }
        return url;

    }
}

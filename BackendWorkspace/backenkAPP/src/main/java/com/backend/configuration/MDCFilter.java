package com.backend.configuration;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.AbstractOAuth2TokenAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MDCFilter implements Filter{
	

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		try {
			HttpServletRequest req=(HttpServletRequest)request;
			JwtAuthenticationToken token=(JwtAuthenticationToken) req.getUserPrincipal();
			Jwt jwt=(Jwt) token.getPrincipal();
			MDC.put("appName", jwt.getClaim("preferred_username").toString());
		}catch(Exception e) {
			log.error("ERROR ::",e);
		}
		chain.doFilter(request, response);
	}

}

package com.backend.configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class KeyClockRoleConverter implements Converter<Jwt, Collection<GrantedAuthority>> {

	@Override
	public Collection<GrantedAuthority> convert(Jwt source) {
		Map<String,Object> relems=source.getClaim("realm_access");
		
		if(relems==null) {
			return new ArrayList<>();
		}
		
		 List<String> ls=(List<String>) relems.get("roles");
		 
		 return ls.stream().map(S->"ROLE_"+S)
		.peek(log::info)
		.map(SimpleGrantedAuthority::new)
		.collect(Collectors.toList());

	}

	
}

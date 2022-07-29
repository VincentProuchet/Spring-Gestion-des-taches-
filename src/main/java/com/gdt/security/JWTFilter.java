package com.gdt.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import com.gdt.service.AccountService;

public class JWTFilter extends OncePerRequestFilter{
	private AccountService accountService;
	private JWTTokenUtils jwtTokenUtils;
	private String autorization;

	public JWTFilter(AccountService accountService, JWTTokenUtils jwtTokenUtils, String autorization) {
		super();
		this.accountService = accountService;
		this.jwtTokenUtils = jwtTokenUtils;
		this.autorization = autorization;
	}




	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String header = request.getHeader(autorization);
		if(header!=null && header.startsWith("Bearer ")) {
			
			String token =  header.substring(7);
			
			String userName = this.jwtTokenUtils.getUserNameFromToken(token);
			
			if(userName!=null) {
				UserDetails employee = this.accountService.loadUserByUsername(userName);
				// on vérifie la validité du tokens
				if(jwtTokenUtils.isTokenValid(token,employee)) {
					
					UsernamePasswordAuthenticationToken  authenticationToken =  
					// on le vérifie en controlant les autorisation de l'utilisateur
							new UsernamePasswordAuthenticationToken(employee,null,employee.getAuthorities());
					authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					SecurityContextHolder.getContext().setAuthentication(authenticationToken);
				}
			}
			
		}
		filterChain.doFilter(request, response);
	}
	
}

package com.gdt.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.util.AntPathMatcher;

import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpMethod.GET;

import com.gdt.service.AccountService;

import lombok.AllArgsConstructor;

@Configuration // une classe de configuration de spring
@EnableWebSecurity // active l'import des méthode de sécurité web
@EnableGlobalMethodSecurity(prePostEnabled = true) // activation des configuration de sécurité
@AllArgsConstructor
public class SecurityConfiguration {

	private BCryptPasswordEncoder bCryptPasswordEncoder;
	private AccountService accountService;
	private JWTTokenUtils jwtTokenUtils;
	private JWTEntryPoint jewtEntry;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
				.authorizeRequests((request) 
						-> request
						//.antMatchers(POST, "task").hasAnyAuthority("MANAGER")
						.antMatchers(POST, "task").permitAll()
						.antMatchers(GET, "employee").permitAll()
						.anyRequest().authenticated()
						)				
				.exceptionHandling()
				.authenticationEntryPoint(jewtEntry)
				.and()
				// toutes les autres demandes un authentification
				.httpBasic(Customizer.withDefaults())

		;
		JWTFilter jwtFilter = new JWTFilter(accountService, jwtTokenUtils, "Authorization");
		httpSecurity.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
		return httpSecurity.build();
	}

	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring().antMatchers(POST, "/signup").antMatchers(GET, "/validate/{token}")
				.antMatchers(POST, "/signin")

		;
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
		return authConfig.getAuthenticationManager();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		// on lui dit comment gére les compte utilisateurs et c'est l'extension de
		// l'interface UserDetail service
		authenticationProvider.setUserDetailsService(accountService);
		// on lui diot comment les mots de passes sont crypté
		authenticationProvider.setPasswordEncoder(bCryptPasswordEncoder);
		return authenticationProvider;
	}

}

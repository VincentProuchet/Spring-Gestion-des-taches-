package com.gdt.security;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.gdt.entities.Employee;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Component
public class JWTTokenUtils {
	
	private static String SIGN_KEY ="fqfqzfqzffqfqzfqzffqfqzfqzffqfqzfqzffqfqzfqzffqfqzfqzffqfqzfqzffqfqzfqzffqfqzfqzffqfqzfqzffqfqzfqzffqfqzfqzffqfqzfqzffqfqzfqzffqfqzfqzffqfqzfqzffqfqzfqzffqfqzfqzffqfqzfqzffqfqzfqzffqfqzfqzffqfqzfqzffqfqzfqzffqfqzfqzf";
	
	public String generateToken(Employee employee) {
		Map<String,Object> claims = new HashMap<>();
		claims.put("firstName",employee.getFirstName() );
		claims.put("lastName",employee.getLastName() );
		claims.put("roles",employee.getRoles() );
		claims.put("userName",employee.getUsername() );
		
		Date now = new Date();
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		calendar.add(Calendar.HOUR, 2);
		
		String token =
		Jwts.builder()
		.setClaims(claims)
		.setSubject(employee.getUsername())
		.setIssuer("GESTION TACHES")
		.setIssuedAt(now)
		.setExpiration(calendar.getTime())
		.signWith(SignatureAlgorithm.HS256, SIGN_KEY)
		
		.compact()
		;
		log.info("TOKEN{}",token);
		return  token ;
	}
	
	public String getUserNameFromToken(String token) {
		Claims claims = 
		getClaims(token);
		return claims.getSubject();
		
	}

	private Claims getClaims(String token) {
		return Jwts.parser()
		.setSigningKey(SIGN_KEY)
		.parseClaimsJws(token)
		.getBody();
	}
	
	/** Récupère les information d'un Token 
	 * 	effectue les comparaison et valide ou nom l'intégrité des données
	 * @param token
	 * @param employee
	 * @return
	 */
	public boolean isTokenValid(String token , UserDetails employee) {
		Claims claims = getClaims(token);
		Date expiration = claims.getExpiration();
		String UserNameFromToken = getUserNameFromToken(token);
		Boolean isValidUSerName = UserNameFromToken.equals(employee.getUsername());
		Boolean isValidDate = expiration.after(new Date());
		
		return isValidDate && isValidUSerName;
		
	}
}

package com.omnisport.hello.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.omnisport.hello.service.RolService;
import com.omnisport.hello.service.UsuarioService;

@Configuration
@EnableWebSecurity
public class HelloAppSecurityConfig extends WebSecurityConfigurerAdapter{
	
	private UsuarioService userService;
	private RolService rolService;
	
	public HelloAppSecurityConfig(UsuarioService userService, RolService rolService) {
		this.userService = userService;
		this.rolService = rolService;
	}
	
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(null);
		provider.setPasswordEncoder(encoder());
		return provider;
	}
	
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration().applyPermitDefaultValues();
		config.setAllowCredentials(true);
		config.addAllowedOrigin("*");
		config.addAllowedHeader("Authorization");
		config.addExposedHeader("Authorization");
		source.registerCorsConfiguration("/**", config);
		return source;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.cors()
		.and()
		.csrf().disable()
		.addFilter(new HelloAppAuthenticationFilter(authenticationManager()))
		.addFilter(new HelloAppAuthorizationFilter(authenticationManager(), userService, rolService))
		.authorizeRequests()
		.antMatchers(HttpMethod.POST,"/sign-in").permitAll()
		.antMatchers("/admin/**").hasAuthority("SUPER-ADMIN")
		.antMatchers("/vendedor").hasAuthority("SELLER")
		.anyRequest().authenticated()
		.and()
		.httpBasic()
		.and()
		.exceptionHandling().accessDeniedPage("/error/403");
	}
}

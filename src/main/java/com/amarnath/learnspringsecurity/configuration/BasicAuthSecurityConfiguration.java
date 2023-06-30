package com.amarnath.learnspringsecurity.configuration;

import static org.springframework.security.config.Customizer.withDefaults;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class BasicAuthSecurityConfiguration {
	
	@SuppressWarnings("removal")
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((requests) -> requests
				//.requestMatchers("/profiles").hasRole("ADMIN")
				.anyRequest().authenticated());
		http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		//http.formLogin(withDefaults());
		http.httpBasic(withDefaults());
		http.headers().frameOptions().sameOrigin();
		http.csrf().disable();
		return http.build();
	}
	
//	@Bean
//	public WebMvcConfigurer corsConfiguration() {
//		return new WebMvcConfigurer() {
//			public void addCoresMapping(CorsRegistration registry) {
//				registry.addMapping("/**").allowedMethods("*").allowOrigins("http://localhost:3000");
//			}
//		};
//	}
	
//	@Bean
//	public UserDetailsService users() {
//		var user = User
//			.withUsername("user")
//			.password("{noop}Dummy")
//			.roles("USER")
//			.build();
//		var admin = User
//			.withUsername("admin")
//			.password("{noop}Super")
//			.roles("USER", "ADMIN")
//			.build();
//		return new InMemoryUserDetailsManager(user, admin);
//	}
	
	@Bean
	public DataSource dataSource() {
		
		return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
				.addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION).build();
		
	}
	
	@Bean
	public UserDetailsService users(DataSource dataSource) {
		var user = User
			.withUsername("user")
			//.password("{noop}Dummy")
			.password("Dummy")
			.passwordEncoder(str -> passwordEncoder().encode(str))
			.roles("USER")
			.build();
		var admin = User
			.withUsername("admin")
			//.password("{noop}Super")
			.password("Strong")
			.passwordEncoder(str -> passwordEncoder().encode(str))
			.roles("ADMIN", "USER")
			.build();
		var jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
		jdbcUserDetailsManager.createUser(user);
		jdbcUserDetailsManager.createUser(admin);
		
		return jdbcUserDetailsManager;
		
		//return new InMemoryUserDetailsManager(user, admin);
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}

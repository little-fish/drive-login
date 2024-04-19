package com.syncinator.kodi.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

import java.security.SecureRandom;

@SpringBootApplication
public class KodiLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(KodiLoginApplication.class, args);
	}

	@Bean
	public SecureRandom getSecureRandom() {
		return new SecureRandom();
	}

	@Bean
	public CommonsRequestLoggingFilter logFilter() {
		final CommonsRequestLoggingFilter filter = new CommonsRequestLoggingFilter();
		filter.setIncludeQueryString(true);
		filter.setIncludePayload(true);
		filter.setMaxPayloadLength(10000);
		filter.setIncludeHeaders(false);
		filter.setAfterMessagePrefix("REQUEST DATA: ");

		return filter;
	}
}

@Configuration
class SecurityConfiguration {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
				.authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests
						.anyRequest().permitAll()
				)
				.csrf(AbstractHttpConfigurer::disable);

		return http.build();
	}
}

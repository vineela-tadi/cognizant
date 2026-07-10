package com.cognizant.spring_learn.security;
import com.cognizant.spring_learn.security.JwtAuthorizationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {

        UserDetails admin = User.withUsername("admin")
                .password(passwordEncoder().encode("pwd"))
                .roles("ADMIN")
                .build();

        UserDetails user = User.withUsername("user")
                .password(passwordEncoder().encode("pwd"))
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(admin, user);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
public SecurityFilterChain filterChain(HttpSecurity http,
        AuthenticationManager authenticationManager) throws Exception {

    http.csrf(csrf -> csrf.disable())
        .httpBasic(Customizer.withDefaults())
        .authorizeHttpRequests(auth -> auth

            // USER and ADMIN can generate JWT
            .requestMatchers("/authenticate")
            .hasAnyRole("USER", "ADMIN")

            // ONLY USER can access countries
            .requestMatchers("/countries")
            .hasRole("USER")

            // All other URLs require login
            .anyRequest()
            .authenticated()
        )
        .addFilter(new JwtAuthorizationFilter(authenticationManager));

    return http.build();
}
}
// package
// com.distributed_system_design_lab.member_service_authorization_server.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.core.annotation.Order;
// import
// org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import
// org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.crypto.factory.PasswordEncoderFactories;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import
// org.springframework.security.oauth2.server.authorization.config.annotation.web.configuration.OAuth2AuthorizationServerConfiguration;
// import
// org.springframework.security.oauth2.server.authorization.config.annotation.web.configurers.OAuth2AuthorizationServerConfigurer;
// import org.springframework.security.provisioning.InMemoryUserDetailsManager;
// import org.springframework.security.web.SecurityFilterChain;
// import static org.springframework.security.config.Customizer.withDefaults;

// /**
// * Configuration class for security settings.
// *
// * @author vinskao
// * @version 0.1
// */
// @Configuration
// @EnableWebSecurity
// public class DefaultSecurityConfig {

// /**
// * Configures the security filter chain for the OAuth2 authorization server.
// *
// * @param http the {@link HttpSecurity} to modify
// * @return the configured {@link SecurityFilterChain}
// * @throws Exception if an error occurs
// */
// @Bean
// @Order(1)
// SecurityFilterChain authorizationServerSecurityFilterChain(HttpSecurity http)
// throws Exception {
// // Apply default security configuration for the OAuth2 authorization server
// OAuth2AuthorizationServerConfiguration.applyDefaultSecurity(http);
// http.getConfigurer(OAuth2AuthorizationServerConfigurer.class)
// .oidc(withDefaults()); // Enable OpenID Connect 1.0
// // Enable form login
// return http.formLogin(withDefaults()).build();
// }

// /**
// * Configures the default security filter chain for general authentication.
// *
// * @param http the {@link HttpSecurity} to modify
// * @return the configured {@link SecurityFilterChain}
// * @throws Exception if an error occurs
// */
// @Bean
// @Order(2)
// SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws
// Exception {
// // Require authentication for all requests
// http.authorizeHttpRequests(authorizeRequests ->
// authorizeRequests.anyRequest().authenticated())
// .formLogin(withDefaults()); // Enable form login
// return http.build();
// }

// /**
// * Configures an in-memory user details service with a default user.
// *
// * @return the configured {@link UserDetailsService}
// */
// @Bean
// UserDetailsService users() {
// // Create a delegating password encoder
// PasswordEncoder encoder =
// PasswordEncoderFactories.createDelegatingPasswordEncoder();
// // Create a user with the username "admin" and password "password"
// UserDetails user = User.builder()
// .username("admin")
// .password("password")
// .passwordEncoder(encoder::encode)
// .roles("USER")
// .build();
// // Return an in-memory user details manager with the created user
// return new InMemoryUserDetailsManager(user);
// }
// }

/*
 * package api_gateway_service.config;
 * 
 * import org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.security.config.Customizer; import
 * org.springframework.security.config.annotation.method.configuration.
 * EnableMethodSecurity; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity; import
 * org.springframework.security.config.annotation.web.configuration.
 * WebSecurityCustomizer; import
 * org.springframework.security.core.userdetails.User; import
 * org.springframework.security.core.userdetails.UserDetails; import
 * org.springframework.security.core.userdetails.UserDetailsService; import
 * org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; import
 * org.springframework.security.crypto.password.PasswordEncoder; import
 * org.springframework.security.provisioning.InMemoryUserDetailsManager; import
 * org.springframework.security.web.SecurityFilterChain;
 * 
 * @Configuration
 * 
 * @EnableWebSecurity
 * 
 * @EnableMethodSecurity(securedEnabled = true, jsr250Enabled = true)
 * 
 * public class SecurityConfig {
 * 
 * 
 * //@Value("${admin.username}") private String adminUsername= "sudo123";
 * 
 * 
 * //@Value("${admin.password}") private String adminPassword= "pass123";
 * 
 * @Bean public static PasswordEncoder passwordEncoder() {
 * 
 * return new BCryptPasswordEncoder();
 * 
 * }
 * 
 * 
 * 
 * @Bean SecurityFilterChain securityFilterChain(HttpSecurity http) throws
 * Exception {
 * 
 * 
 * http.csrf(csrf -> csrf.disable())
 * 
 * .authorizeHttpRequests((authorize) -> authorize.anyRequest().authenticated()
 * )
 * 
 * .httpBasic(Customizer.withDefaults());
 * 
 * return http.build();
 * 
 * }
 * 
 * 
 * @Bean public InMemoryUserDetailsManager userService() {
 * 
 * UserDetails lakshman = User.builder() .username(adminUsername)
 * .password(passwordEncoder().encode(adminPassword)) .roles("ADMIN") .build();
 * 
 * 
 * UserDetails admin = User.builder() .username("admin")
 * .password(passwordEncoder().encode("admin")) .roles("ADMIN") .build();
 * 
 * 
 * return new InMemoryUserDetailsManager(lakshman);
 * 
 * 
 * }
 * 
 * 
 * @Bean public WebSecurityCustomizer webSecurityCustomizer() { return web ->
 * web.debug(true) .ignoring() .requestMatchers("/css/**", "/js /**", "/img/**",
 * "/lib/**", "/favicon.ico", "/api/public/**"); }
 * 
 * 
 * 
 * }
 */
package com.example.demo.config.security;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {//userDetailsManager spring bu nesneyle kullanıcı doğrulama yapacak
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);//vt'na bağlanan jdbcUserDetailsManager nesnesi oluşturuluyor

        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select email, password, enabled from users where email=?");//kullanıcının eposta adresine göre bilgilerini alacak sql sorgusu

        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select u.email, r.name from users u join users_roles ur on u.id=ur.user_id join roles r on r.id=ur.role_id where u.email = ?");//kullanıcının girdiği emaile göre rollerini belirleyen sorgu
        return jdbcUserDetailsManager;//oluşan nesne springe verilir
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth.anyRequest().permitAll());

        return http.build();
    }



    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }



}

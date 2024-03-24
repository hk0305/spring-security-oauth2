package io.security.oauth2.springsecurityoauth2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Slf4j
@Configuration
//스프링 시큐리티 6.0 부터 @EnableWebSecurity 에는 @Configuration 포함되지 않음.
public class SecurityConfig {

    @Bean
    SecurityFilterChain defalutSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests().anyRequest().authenticated();
        // AuthenticationEntryPoint 설정
        http.httpBasic().authenticationEntryPoint(new CustomAuthenticationEntryPoint());
        // 세션 미사용
        // http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        return http.build();
    }


}

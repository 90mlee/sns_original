package com.fastcampus.snsproject.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class AuthenticationConfig extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/*/users/join", "/api/*/users/login").permitAll()
                .antMatchers("/api/**").authenticated()
                //.anyRequest().permitAll()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        ;        //.and()
                //.exceptionHandling()
                //.authenticationEntryPoint(new CustomAuthenticationEntryPoint())
                //.and()
                //.addFilterBefore(new JwtTokenFilter(userService, secretKey), UsernamePasswordAuthenticationFilter.class);
    }
}
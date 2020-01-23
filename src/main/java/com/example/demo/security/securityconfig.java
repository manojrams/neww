package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class securityconfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //HTTP Basic authentication
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/records/**").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/records").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/records/**").hasRole("ADMIN")
                .and()
                .csrf().disable()
                .formLogin().disable();
    }


    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        {
            PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
            User.UserBuilder userBuilder = User.builder().passwordEncoder(encoder::encode);
            UserDetails user1 = userBuilder
                    .username("myuser")
                    .password("pass")
                    .roles("USER")
                    .build();

            UserDetails user2 = userBuilder
                    .username("myuser2")
                    .password("pass1")
                    .roles("ADMIN")
                    .build();

            return new InMemoryUserDetailsManager(user1,user2);


        }
    }

}

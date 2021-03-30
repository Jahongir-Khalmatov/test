package lesson2.hometask2_pcmarket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.lang.reflect.Method;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("super-admin").password(passwordEncoder().encode("123")).roles("SUPER-ADMIN")
                .and()
                .withUser("moderator").password(passwordEncoder().encode("456")).roles("MODERATOR")
                .and()
                .withUser("operator").password(passwordEncoder().encode("789")).roles("OPERATOR");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET,"/api/**").hasAnyRole("SUPER-ADMIN","MODERATOR","OPERATOR")
                .antMatchers(HttpMethod.POST,"/api/**").hasAnyRole("SUPER-ADMIN","MODERATOR")
                .antMatchers(HttpMethod.PUT,"/api/**").hasAnyRole("SUPER-ADMIN","MODERATOR")
                .antMatchers("/api/**").hasAnyRole("SUPER-ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    };
}

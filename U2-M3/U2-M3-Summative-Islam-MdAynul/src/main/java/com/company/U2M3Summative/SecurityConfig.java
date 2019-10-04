package com.company.U2M3Summative;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder authBuilder) throws Exception {

        PasswordEncoder encoder = new BCryptPasswordEncoder();

        authBuilder.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(
                        "select username, password, enabled from users where username = ?")
                .authoritiesByUsernameQuery(
                        "select username, authority from authorities where username = ?")
                .passwordEncoder(encoder);
    }
    public void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.httpBasic();

        httpSecurity.authorizeRequests()
                .mvcMatchers("/login").authenticated()

                /*******************************FOR INVOICE********************************************************/

                .mvcMatchers(HttpMethod.POST, "/invoice").hasAnyAuthority("ADMIN","MANAGER")
                .mvcMatchers(HttpMethod.DELETE, "/invoice/{id}").hasAnyAuthority("ADMIN","MANAGER")
                .mvcMatchers(HttpMethod.PUT, "/invoice/{id}").hasAnyAuthority("ADMIN","MANAGER","STAFF") // Need to ask about invoice



                /*******************************FOR GAME ********************************************************/

                .mvcMatchers(HttpMethod.POST, "/game").hasAnyAuthority("ADMIN","MANAGER")
                .mvcMatchers(HttpMethod.DELETE, "/game/{id}").hasAnyAuthority("ADMIN","MANAGER")
                .mvcMatchers(HttpMethod.PUT, "/game/{id}").hasAnyAuthority("ADMIN","MANAGER","STAFF")

                /*******************************FOR CONSOLE ********************************************************/

                .mvcMatchers(HttpMethod.POST, "/console").hasAnyAuthority("ADMIN","MANAGER")
                .mvcMatchers(HttpMethod.DELETE, "/console/{id}").hasAnyAuthority("ADMIN","MANAGER")
                .mvcMatchers(HttpMethod.PUT, "/console/{id}").hasAnyAuthority("ADMIN","MANAGER","STAFF")


                /*******************************FOR T-Shirt ********************************************************/

                .mvcMatchers(HttpMethod.POST, "/tShirt").hasAnyAuthority("ADMIN","MANAGER")
                .mvcMatchers(HttpMethod.DELETE, "/tShirt/{id}").hasAnyAuthority("ADMIN","MANAGER")
                .mvcMatchers(HttpMethod.PUT, "/tShirt/{id}").hasAnyAuthority("ADMIN","MANAGER","STAFF")

                .anyRequest().permitAll();

        httpSecurity
                .logout()
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/allDone")
                .deleteCookies("JSESSIONID")
                .deleteCookies("XSRF-TOKEN")
                .invalidateHttpSession(true);

        httpSecurity
                .csrf()     //before testing it in Postman do .csrf.disable(); and comment out the next line
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
    }
}

package org.lgudimanchi.bvcollaboration.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.lgudimanchi.bvcollaboration.security.MyAuthenticationSuccessHandler;
import org.lgudimanchi.bvcollaboration.security.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class CasestudySecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    protected void configure(final HttpSecurity http) throws Exception{

        http
                .csrf().disable()
                .authorizeRequests()
                    .antMatchers("/pub/**", "/error/**", "/login/**", "/index/**").permitAll()
                    .antMatchers("/buyer/**", "/products/**", "/vendor/**").authenticated()
                    .and()
                .formLogin()
                // this is the URL of the login page
                     .loginPage("/login/login")
                // this is the URL where the login page will submit
                     .loginProcessingUrl("/login/loginSubmit")
                     .successHandler(myAuthenticationSuccessHandler())
                     .and()
                .logout()
                     .invalidateHttpSession(true)
                // this is the URL to log the user out
                     .logoutUrl("/login/logout")
                // the URL that the user goes to after they logout
                     .logoutSuccessUrl("/")
                     .and()
                .exceptionHandling()
                     .accessDeniedPage("/error/404");
    }

    @Bean
    public DaoAuthenticationProvider getAuthenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
       authProvider.setPasswordEncoder(getPasswordEncoder());
        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
        auth.authenticationProvider(getAuthenticationProvider());
    }

    @Bean(name="passwordEncoder")
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationSuccessHandler myAuthenticationSuccessHandler(){
        return new MyAuthenticationSuccessHandler();
    }

}

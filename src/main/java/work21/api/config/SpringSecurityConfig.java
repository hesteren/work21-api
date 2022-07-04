package work21.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import work21.api.experiment.application.UserDetailsServiceImpl;

import static org.springframework.http.HttpMethod.*;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationEntryPoint authenticationEntryPoint;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests()
                .antMatchers(POST, "/experiments")
                .authenticated()
                .and()
                .authorizeHttpRequests()
                .antMatchers(POST, "/login")
                .authenticated()
                .and()
                .authorizeRequests()
                .antMatchers(PUT, "/experiments/**")
                .authenticated()
                .and()
                .authorizeRequests()
                .antMatchers(DELETE, "/experiments/**")
                .authenticated()
                .and()
                .authorizeRequests()
                .antMatchers(GET, "/experiments")
                .permitAll()
                .and().httpBasic().authenticationEntryPoint(authenticationEntryPoint);
    }
}

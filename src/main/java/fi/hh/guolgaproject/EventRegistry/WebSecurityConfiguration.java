package fi.hh.guolgaproject.EventRegistry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import fi.hh.guolgaproject.EventRegistry.web.UserDetailServImpl;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	 private UserDetailServImpl userDetailsService;	
	
	@Override
	 protected void configure(HttpSecurity http) throws Exception {
        http
        .authorizeRequests().antMatchers("/css/**").permitAll() 
        .and()
        .authorizeRequests()
        .antMatchers("/", "/add", "/save", "/eventlist", "/login", "/signup", "/delete/{id}").permitAll()
          .anyRequest().authenticated()
          .and()
      .formLogin()
          .loginPage("/login")
          .defaultSuccessUrl("/eventlist")
          .permitAll()
          .and()
      .logout()
          .permitAll();
    }
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
	
}

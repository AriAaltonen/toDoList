package swd.toDoList.security;
/*
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
					.anyRequest()
					.authenticated()
				.and()
				.formLogin()
					.loginPage("/login")
					.permitAll()
				.and()
					.logout()
					.permitAll();
	}
	/*
	 * @Bean
	 * 
	 * @Override public UserDetailsService userDetailsService() {
	 * Collection<UserDetails> users = new ArrayList<UserDetails>();
	 * users.add(generateUser("user", "password", "USER"));
	 * users.add(generateUser("admin", "admin123", "ADMIN"));
	 * 
	 * return new InMemoryUserDetailsManager(users); }
	 * 
	 * private UserDetails generateUser(String username, String password, String
	 * role) { return
	 * User.withDefaultPasswordEncoder().username(username).password(password).roles
	 * (role).build(); }
	 */
/*	@Autowired
	private UserDetailServiceImpl userDetailsService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}
}*/
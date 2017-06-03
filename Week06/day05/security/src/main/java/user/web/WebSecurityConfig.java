package user.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;



@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/", "/favicon.ico", "/css/**", "/images/**");
	}
	
	public void configure(HttpSecurity http) throws Exception{
		http
		.antMatcher("/users/**")
		.authorizeRequests()
			.antMatchers(HttpMethod.GET,"/**").permitAll()
			.antMatchers(HttpMethod.POST, "/**").permitAll()
			.antMatchers(HttpMethod.PUT, "/**").hasAnyRole("USER","ADMIN")
			.antMatchers("/**").hasRole("ADMIN")
			.and()
		.csrf().disable()
		.httpBasic();
		
		
		
		
	
	}
	

}

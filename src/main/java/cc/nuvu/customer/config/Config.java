package cc.nuvu.customer.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import cc.nuvu.customer.util.Constants;
import cc.nuvu.customer.util.JWTAuthorizationFilter;

@Configuration
public class Config {

	@EnableWebSecurity
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable()
					.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
					.authorizeRequests().antMatchers("/h2-console/**").permitAll()
					.antMatchers(HttpMethod.POST, "/user/login").permitAll().antMatchers("/transaction/**").permitAll()
					.antMatchers("/operation-manager/**").authenticated().anyRequest().authenticated();

		}

		@Override
		public void configure(WebSecurity web) throws Exception {
			web.ignoring().antMatchers("/v2/api-docs", "/configuration/ui", "/swagger-resources/**",
					"/configuration/security", "/swagger-ui.html", "/webjars/**");
		}
	}

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename(Constants.MESSAGES_CO);
		messageSource.setDefaultEncoding(Constants.ENCONDING);
		return messageSource;
	}

}

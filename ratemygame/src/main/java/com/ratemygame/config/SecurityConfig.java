package com.ratemygame.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;

import com.ratemygame.DTO.UserDTO;
import com.ratemygame.entity.User;
import com.ratemygame.repository.UserRepository;
import com.ratemygame.services.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsServiceImpl userDetailService;
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailService);
    }
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.csrf().disable().antMatcher("/**").anonymous();
    }
  
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new PasswordEncoder() {

			@Override
			public String encode(CharSequence rawPassword) {
				return rawPassword.toString();
			}

			@Override
			public boolean matches(CharSequence rawPassword, String encodedPassword) {
				return true;
			}
        	
        };
    }
    
    public void doLogin(HttpServletRequest req, String username, String password) throws AuthenticationException, Exception {
    	UsernamePasswordAuthenticationToken authReq = new UsernamePasswordAuthenticationToken(username, password);
	    Authentication auth = authenticationManagerBean().authenticate(authReq);
	    SecurityContext sc = SecurityContextHolder.getContext();
	    sc.setAuthentication(auth);
	    HttpSession session = req.getSession(true);
	    session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, sc);
    }
    
    public UserDTO getLoginUserDTO() {
    	if(SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof User) {
    		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    		return userDetailService.transformUserToDTO(user);
    	}
    	
    	return new UserDTO();
    }
}


package com.ratemygame.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.ratemygame.wrapper.GameWrapper;
import com.ratemygame.wrapper.UserWrapper;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	@Value("${games.images.path}")
	private String gamesImagePath;
	
	@Value("${images}")
	private String internImagePath;

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {

		registry.addRedirectViewController("/", "/homepage");
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/view/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		registry.viewResolver(resolver);
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    registry
	      .addResourceHandler("/" + internImagePath +"**")
	      .addResourceLocations("file:///" + gamesImagePath + "/");
	 }

	@Bean
	public ConversionService conversionService() {
		return new DefaultConversionService();
	}
	
	@Bean
	public GameWrapper gameMapper() {
	    return new GameWrapper();
	}
	
	@Bean
	public UserWrapper userMapper() {
		return new UserWrapper();
	}
}

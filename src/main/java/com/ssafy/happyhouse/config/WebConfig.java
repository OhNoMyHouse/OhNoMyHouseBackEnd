package com.ssafy.happyhouse.config;

import javax.servlet.ServletContextListener;

import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.happyhouse.listener.RootPathListener;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/user/login_form.do").setViewName("/user/login");
		registry.addViewController("/user/regist_form.do").setViewName("/user/regist");
		registry.addViewController("/user/search_form.do").setViewName("/user/search");
		registry.addViewController("/board/makepoll_form.do").setViewName("/board/makepoll");
	}
	
	@Bean
	public ServletListenerRegistrationBean<ServletContextListener> addListener() {
		ServletListenerRegistrationBean<ServletContextListener> bean
		= new ServletListenerRegistrationBean<ServletContextListener>();
		bean.setListener(new RootPathListener());
		return bean;
	}

}

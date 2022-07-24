package com.melodyjumper.expensetrackerapi;

import com.melodyjumper.expensetrackerapi.filters.AuthFilter;
import com.melodyjumper.expensetrackerapi.filters.SimpleCORSFilter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ExpenseTrackerApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpenseTrackerApiApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean<AuthFilter> filterRegistrationBean() {
		FilterRegistrationBean<AuthFilter> registrationBean = new FilterRegistrationBean<>();
		AuthFilter authFilter = new AuthFilter();
		registrationBean.setFilter(authFilter);
		registrationBean.addUrlPatterns("/api/categories/*");
		registrationBean.addUrlPatterns("/api/users/me");
		return registrationBean;
	}

	@Bean(name = "filterRegistrationBean2")
	public FilterRegistrationBean<SimpleCORSFilter> filterRegistrationBean2() {
		FilterRegistrationBean<SimpleCORSFilter> registrationBean = new FilterRegistrationBean<>();
		SimpleCORSFilter simpleCORSFilter = new SimpleCORSFilter();
		registrationBean.setFilter(simpleCORSFilter);
		return registrationBean;
	}

}

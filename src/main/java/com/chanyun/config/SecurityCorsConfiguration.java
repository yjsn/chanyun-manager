package com.chanyun.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class SecurityCorsConfiguration {
	 private CorsConfiguration buildConfig() {
	        CorsConfiguration corsConfiguration = new CorsConfiguration();
	        corsConfiguration.addAllowedOrigin("*"); // 1允许任何域名使用
	        corsConfiguration.addAllowedHeader("*"); // 2允许任何头
	        corsConfiguration.addAllowedMethod("*"); // 3允许任何方法（post、get等）
	        corsConfiguration.setAllowCredentials(true);//保证sessionId不变
	        return corsConfiguration;
	    }

	    @Bean
	    public FilterRegistrationBean corsFilter() {
	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	        source.registerCorsConfiguration("/**", buildConfig()); // 4
	        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
	        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
	        return bean;
	    }


}

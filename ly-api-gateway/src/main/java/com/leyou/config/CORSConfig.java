package com.leyou.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CORSConfig {
    @Bean
    public CorsFilter corsFilter(){
        //配置cors
        CorsConfiguration configuration=new CorsConfiguration();
        configuration.addAllowedOrigin("http://manage.leyou.com");
        configuration.addAllowedOrigin("http://www.leyou.com");
        configuration.addAllowedHeader("*");
        configuration.addAllowedMethod("*");
        configuration.setAllowCredentials(true);
        //配置过滤地址
        UrlBasedCorsConfigurationSource source=new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**",configuration);
        return  new CorsFilter(source);
    }
}

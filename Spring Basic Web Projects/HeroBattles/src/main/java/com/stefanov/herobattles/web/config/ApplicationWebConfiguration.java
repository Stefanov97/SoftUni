package com.stefanov.herobattles.web.config;

import com.stefanov.herobattles.web.filters.UserHeroInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class ApplicationWebConfiguration implements WebMvcConfigurer {
    private final UserHeroInterceptor userHeroInterceptor;

    public ApplicationWebConfiguration(UserHeroInterceptor userHeroInterceptor){
        this.userHeroInterceptor = userHeroInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.userHeroInterceptor);
    }
}

package org.example.ngoquangtruongmain.congiguration;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class DIContainer {
    @Bean
    @Scope(value= ConfigurableBeanFactory.SCOPE_PROTOTYPE)// tạo ra khi mỗi lần đc gọi
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }


    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*") // ví dụ: http://127.0.0.1:5500
                        .allowedMethods("HEAD", "OPTIONS", "GET", "POST", "PUT", "DELETE")
                        .allowedHeaders("*");
            }
        };
    }
}

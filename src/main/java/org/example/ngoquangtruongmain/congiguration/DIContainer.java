package org.example.ngoquangtruongmain.congiguration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DIContainer {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

}

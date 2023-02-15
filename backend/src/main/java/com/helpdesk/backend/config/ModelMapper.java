package com.helpdesk.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapper {

    @Bean
    public ModelMapper obterModelMapper(){
        return new ModelMapper();
    }
}

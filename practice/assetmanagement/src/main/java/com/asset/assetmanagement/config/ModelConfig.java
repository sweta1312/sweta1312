package com.asset.assetmanagement.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

public class ModelConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}

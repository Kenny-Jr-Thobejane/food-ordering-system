package com.jumpstart.food_ordering_system.Configuration; 

import org.apache.catalina.mapper.Mapper;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Global configuration class used to register Spring beans.
 * This class serves as a source for bean definitions managed by the Spring container.
 */
@Configuration // Marks this class as a configuration component for Spring setup
public class ApplicationConfig {

    /**
     * Declares a managed Bean instance of ModelMapper.
     * This utility facilitates data transfer by automatically copying fields between Entities and DTOs.
     * 
     * @return A configured, reusable instance of ModelMapper.
     */
    @Bean // Tells Spring to manage the lifecycle of the returned object instance
    public Mapper modelMapper() {
        // Returns a fresh instance of ModelMapper to be injected where needed
        return new Mapper();
    }
}

package org.example.buysourcecode.config;

import org.example.buysourcecode.map.*;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ProductMapper productMapper() {
        return Mappers.getMapper( ProductMapper.class );
    }

    @Bean
    public OrderMapper orderMapper() { return Mappers.getMapper( OrderMapper.class ); }

    @Bean
    public ReviewMapper reviewMapper() { return Mappers.getMapper( ReviewMapper.class ); }

    @Bean
    public AddressMapper addressMapper() { return Mappers.getMapper( AddressMapper.class ); }

}

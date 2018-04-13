package com.amit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

//@Configuration
//@EnableAutoConfiguration
//@Import({LcSpringBootConfig.class, ServiceConfig.class, TaxClientConfig.class, SecondaryMarketConfig.class})
//@EnableAspectJAutoProxy
//@EnableAsync

@SpringBootApplication
@ComponentScan(basePackages = {"com.amit.message"})
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class,args);
    }
}

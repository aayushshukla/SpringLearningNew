package com.infosys.aopexample.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.infosys.aopexample.*")
// Enables support for handling components marked with AspectJ's 
//@Aspect annotation,similar to functionality 
@EnableAspectJAutoProxy
public class Config {

}

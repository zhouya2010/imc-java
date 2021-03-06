package com.yundian.imc.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration
@ComponentScan(
        basePackages = {"com.yundian.imc.config.other","com.yundian.imc.dao", "com.yundian.imc.entity", "com.yundian.imc.service"},
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)}
)

public class RootConfig {

}

package com.yundian.imc.config;

import org.apache.shiro.web.env.EnvironmentLoaderListener;
import org.apache.shiro.web.servlet.ShiroFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.*;

@PropertySource(value = {"classpath:config.properties"}, ignoreResourceNotFound = true)
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    //spring 相关配置
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    //MVC 相关配置
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    protected String[] getServletMappings() {
        return new String[]{"/*"};
    }

    @Bean
    public MultipartResolver multipartResolver() {
        return new StandardServletMultipartResolver();
    }


    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        servletContext.addListener(EnvironmentLoaderListener.class);
        FilterRegistration.Dynamic dynamic = servletContext.addFilter("ShiroFilter", DelegatingFilterProxy.class);
        dynamic.addMappingForUrlPatterns(null, false, "/*");
        super.onStartup(servletContext);
    }

    /*上传参数*/
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setMultipartConfig(
                new MultipartConfigElement("" , 5242880 , 20971520 , 0 )
        );
    }

    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return new Filter[] {characterEncodingFilter};
    }
}

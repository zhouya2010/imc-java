package com.yundian.imc.config;

import freemarker.template.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.oxm.xstream.XStreamMarshaller;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy
@ComponentScan(
        basePackages = {"com.yundian.imc.controller"}
)
@PropertySource(value = {"classpath:config.properties"}, ignoreResourceNotFound = true)
public class WebConfig extends WebMvcConfigurerAdapter {
    /*视图解析器*/
    @Value("${view.prefix}")
    private String prefix;

    @Value("${view.suffix}")
    private String suffix;

    @Value("${template.encoding}")
    private String encode;

    @Value("${template.number_format}")
    private String numberFormat;

    @Value("${template.boolean_format}")
    private String booleanFormat;

    @Value("${template.datetime_format}")
    private String datetimeFormat;

    @Value("${template.date_format}")
    private String dateFormat;

    @Value("${template.time_format}")
    private String timeFormat;


    @Value("${template.loader_path}")
    private String loaderPath;

//    @Bean
//    public ViewResolver viewResolver() {
//        InternalResourceViewResolver resourceViewResolver = new InternalResourceViewResolver();
//        resourceViewResolver.setPrefix(prefix);
//        resourceViewResolver.setSuffix(suffix);
//        resourceViewResolver.setExposeContextBeansAsAttributes(true);
//        return resourceViewResolver;
//    }

    @Bean
    public ViewResolver freeMarkerViewResolver() {
        FreeMarkerViewResolver freeMarkerViewResolver = new FreeMarkerViewResolver();
        freeMarkerViewResolver.setViewClass(FreeMarkerView.class);
        freeMarkerViewResolver.setContentType("text/html; charset=utf-8");
        freeMarkerViewResolver.setCache(true);
        freeMarkerViewResolver.setSuffix(".ftl");
        freeMarkerViewResolver.setOrder(0);
        return freeMarkerViewResolver;
    }

    @Bean
    public FreeMarkerConfig freeMarkerConfig(WebApplicationContext applicationContext) throws IOException {
        FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();

        configurer.setTemplateLoaderPath(loaderPath);

        freemarker.template.Configuration cfg = new freemarker.template.Configuration(freemarker.template.Configuration.VERSION_2_3_26);
//        cfg.setDirectoryForTemplateLoading(new File("src/templates"));
        cfg.setDefaultEncoding(encode);
        cfg.setURLEscapingCharset("UTF-8");
        cfg.setTemplateUpdateDelayMilliseconds(0);
//        cfg.setTagSyntax();
        cfg.setWhitespaceStripping(true);
        cfg.setClassicCompatible(true);
        cfg.setNumberFormat(numberFormat);
        cfg.setBooleanFormat(booleanFormat);
        cfg.setDateFormat(datetimeFormat);
        cfg.setDateFormat(dateFormat);
        cfg.setTimeFormat(timeFormat);
//        cfg.setObjectWrapper(new BeansWrapper(new Version("2.3.26")));
        cfg.setServletContextForTemplateLoading(applicationContext.getServletContext(), loaderPath);
        configurer.setConfiguration(cfg);
        return  configurer;
    }

    /*静态资源文件 转发给servlet*/
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /*response字符集*/
    @Value("${http.encoding}")
    private String encoding;

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        StringHttpMessageConverter shm = new StringHttpMessageConverter(Charset.forName(encoding));
        //返回字符集编码设置
        converters.add(shm);
        //@requestbody  json类型转换
        converters.add(new MappingJackson2HttpMessageConverter());
        //xml类型转换
        converters.add(createXmlHttpMessageConverter());
    }

    private HttpMessageConverter<Object> createXmlHttpMessageConverter() {
        MarshallingHttpMessageConverter xmlConverter =
                new MarshallingHttpMessageConverter();

        XStreamMarshaller xstreamMarshaller = new XStreamMarshaller();
        xmlConverter.setMarshaller(xstreamMarshaller);
        xmlConverter.setUnmarshaller(xstreamMarshaller);

        return xmlConverter;
    }

    /*cors跨域配置*/
    @Value("${cors.mapping}")
    private String mapping;
    @Value("${cors.allowedOrigins}")
    private String allowedOrigins;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping(mapping)
                .allowedOrigins(allowedOrigins)
                .allowedMethods("PUT", "DELETE", "POST", "GET")
                .allowCredentials(false).maxAge(3600);
    }
}

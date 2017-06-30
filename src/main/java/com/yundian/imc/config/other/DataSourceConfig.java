package com.yundian.imc.config.other;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.Ordered;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.SharedCacheMode;
import javax.persistence.ValidationMode;
import java.util.Hashtable;
import java.util.Map;


@Configuration
//事务
@EnableTransactionManagement(
        mode = AdviceMode.PROXY, proxyTargetClass = false,
        order = Ordered.LOWEST_PRECEDENCE
)
@EnableJpaRepositories(
        basePackages = "com.yundian.imc.dao",
        entityManagerFactoryRef = "entityManagerFactoryBean",
        transactionManagerRef = "jpaTransactionManager"
)
@PropertySource({"classpath:config.properties"})
@EnableCaching
public class DataSourceConfig {

    @Value("${jdbc.driverClassName}")
    private String driverClassName;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;


    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
        Map<String, Object> properties = new Hashtable<>();
        properties.put("javax.persistence.schema-generation.database.action",
                "none");
        properties.put("hibernate.show_sql", true);
        properties.put("hibernate.format_sql", true);
        properties.put("hibernate.use_sql_comments", false);
        //二级缓存配置
//        properties.put("hibernate.cache.use_second_level_cache", true);
//        properties.put("hibernate.cache.use_query_cache", true);
//        properties.put("hibernate.cache.use_structured_entries", true);
//        properties.put("hibernate.cache.auto_evict_collection_cache", true);
//        properties.put("hibernate.cache.use_reference_entries", true);
//        properties.put("hibernate.cache.provider_class", "org.hibernate.cache.EhCacheProvider");
//        properties.put("hibernate.cache.region.factory_class", "org.hibernate.cache.ehcache.EhCacheRegionFactory");


        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabasePlatform("org.hibernate.dialect.MySQL5InnoDBDialect");

        LocalContainerEntityManagerFactoryBean factory =
                new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(adapter);
        factory.setDataSource(dataSource());
        factory.setPackagesToScan("com.yundian.imc.entity");
        factory.setSharedCacheMode(SharedCacheMode.ENABLE_SELECTIVE);
        factory.setValidationMode(ValidationMode.NONE);
        factory.setJpaPropertyMap(properties);
        return factory;
    }

    @Bean
    EhCacheManagerFactoryBean ehCacheManager(){
        EhCacheManagerFactoryBean bean = new EhCacheManagerFactoryBean();
//        bean.setConfigLocation();
        bean.setShared(true);
        return bean;
    }

    @Bean
    CacheManager cacheManager(){
        EhCacheCacheManager manager = new EhCacheCacheManager();
        manager.setCacheManager(ehCacheManager().getObject());

        return manager;
    }

    @Bean
    public DruidDataSource dataSource() {
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName(driverClassName);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        ds.setInitialSize(5);
        ds.setMaxActive(20);
        return ds;
    }

    @Bean
    public PlatformTransactionManager jpaTransactionManager() {
        return new JpaTransactionManager(
                this.entityManagerFactoryBean().getObject()
        );
    }
}
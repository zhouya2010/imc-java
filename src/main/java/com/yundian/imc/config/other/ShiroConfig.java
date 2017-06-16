package com.yundian.imc.config.other;

import com.yundian.imc.common.AuthenticationRealm;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.spring.config.ShiroAnnotationProcessorConfiguration;
import org.apache.shiro.spring.config.ShiroBeanConfiguration;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.ShiroFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
//        ShiroConfiguration.class,
        ShiroBeanConfiguration.class,
        ShiroAnnotationProcessorConfiguration.class,
//        ShiroWebConfiguration.class
//        ShiroWebFilterConfiguration.class
})
public class ShiroConfig {


    @Bean
    public AuthorizingRealm shiroRealm() {
        return new AuthenticationRealm();
    }

    @Bean
    public EhCacheManager getEhCacheManager() {
        EhCacheManager em = new EhCacheManager();
        em.setCacheManagerConfigFile("classpath:ehcache-shiro.xml");
        return em;
    }


    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean() {
        System.err.println("=============> shiroFilterFactoryBean");
        ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();
        filterFactoryBean.setLoginUrl("/sign-in");
        filterFactoryBean.setSuccessUrl("/index");
//        filterFactoryBean.setUnauthorizedUrl("");
        filterFactoryBean.setSecurityManager(securityManager());

        filterFactoryBean.setFilterChainDefinitionMap(shiroFilterChainDefinition().getFilterChainMap());
        return filterFactoryBean;
    }


    @Bean(name = "securityManager")
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager dwsm = new DefaultWebSecurityManager();
        dwsm.setRealm(shiroRealm());
        dwsm.setCacheManager(getEhCacheManager());
        return dwsm;
    }

    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();
//        chainDefinition.addPathDefinition("/login.html", "authc"); // need to accept POSTs from the login form
//        chainDefinition.addPathDefinition("/logout", "logout");
//        chainDefinition.getFilterChainMap().put("/admin/**", "authc");
////        shiroFilterChainDefinition.getFilterChainMap().put("/**", "anon");

//        chainDefinition.addPathDefinition("/favicon.ico", "anon");
//        chainDefinition.addPathDefinition("/logo.png", "anon");
//        chainDefinition.addPathDefinition("/shiro.css", "anon");
//        chainDefinition.addPathDefinition("/s/login", "anon");
//        chainDefinition.addPathDefinition("/*.jar", "anon"); //allow WebStart to pull the jars for the swing app
//        chainDefinition.addPathDefinition("/remoting/**", "anon"); // protected using SecureRemoteInvocationExecutor
        chainDefinition.addPathDefinition("/**", "authc");


        return chainDefinition;
    }
}

package com.yundian.imc.config.other;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by dell on 2017/1/4.
 */
@Configuration
@EnableWebSecurity
@Import(DataSourceConfig.class)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    DruidDataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception {
        System.out.println("AuthenticationManagerBuilder");
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(30,)

//        System.out.println("=====>" + encoder.encode("123456"));

        builder
                .jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select username, password, enable from t_user where username=?")
                .authoritiesByUsernameQuery("select username, role from t_permission where username=?")
                .passwordEncoder(new BCryptPasswordEncoder());

//        builder.inMemoryAuthentication()
//                .withUser("test").password("1234").roles("admin")
//                .and()
//                .withUser("test2").password("1234").roles("user");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/lib/**")
                .antMatchers("/images/**")
                .antMatchers("/resources")
                .antMatchers("/stylesheets/**");
    }

    @Override
    protected void configure(HttpSecurity security) throws Exception {

        security
                .authorizeRequests()
                    .antMatchers("/admin/users/**").hasRole("USER")
                    .antMatchers("/admin/stations/**").hasRole("ADMIN")
                    .antMatchers("/admin/home").permitAll()
                    .antMatchers("/error/*").permitAll()
//                    .antMatchers("/**/list").permitAll()
                    .anyRequest().authenticated()
                .and().formLogin()
                    .loginPage("/admin/home").failureUrl("/admin/error/505")
                    .defaultSuccessUrl("/admin/index")
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .loginProcessingUrl("/admin/login")
                    .permitAll()
                .and().logout()
                    .logoutUrl("/logout").logoutSuccessUrl("/login?loggedOut")
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSONID")
                    .permitAll()
                .and()
                .rememberMe()
                .and().csrf().disable();
    }
}

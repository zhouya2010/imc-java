package com.yundian.imc.config.other;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

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
        builder
                .jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select username, password, enable from t_user where username=?")
                .authoritiesByUsernameQuery("select username, role from t_permission where username=?");
//                .passwordEncoder(new Md5PasswordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/static/**");
    }

    @Override
    protected void configure(HttpSecurity security) throws Exception {

        security
                .authorizeRequests()
                    .antMatchers("/admin/users/**").hasRole("user")
                    .antMatchers("/admin/stations/**").permitAll()
//                    .antMatchers("/delete").permitAll()
//                    .antMatchers("/**/list").permitAll()
                    .anyRequest().permitAll()
                .and().formLogin()
                    .loginPage("/admin/home").failureUrl("/login?error")
                    .defaultSuccessUrl("/admin/login")
                    .usernameParameter("username")
                    .passwordParameter("password")
                .loginProcessingUrl("/admin/login")
                    .permitAll()
                .and().logout()
                    .logoutUrl("/logout").logoutSuccessUrl("/login?loggedOut")
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSONID")
                    .permitAll()
                .and().csrf().disable();
    }
}

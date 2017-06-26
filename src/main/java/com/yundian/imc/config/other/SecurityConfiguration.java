package com.yundian.imc.config.other;

import com.alibaba.druid.pool.DruidDataSource;
import com.yundian.imc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
@Import(DataSourceConfig.class)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    DruidDataSource dataSource;

    @Autowired
    UserDetailsService userService;

    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception {
//        builder
//                .jdbcAuthentication()
//                .dataSource(dataSource)
//                .usersByUsernameQuery("select username, password, enable from t_user where username=?")
//                .authoritiesByUsernameQuery("select username, role from t_permission where username=?")
//                .passwordEncoder(new BCryptPasswordEncoder());
        builder.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
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
//                    .antMatchers("/admin/users/**").hasRole("USER")
//                    .antMatchers("/admin/stations/**").hasRole("ADMIN")
//                    .antMatchers("/admin/home").permitAll()
//                    .antMatchers("/admin/sign-up").permitAll()
                    .antMatchers("/error/**").permitAll()
                    .antMatchers("/admin/**").permitAll()
                    .anyRequest().authenticated()
                .and().formLogin()
                    .loginPage("/admin/home").failureUrl("/error/505")
                    .defaultSuccessUrl("/admin/index")
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .loginProcessingUrl("/admin/login")
                    .permitAll()
                .and().logout()
                    .logoutUrl("/admin/logout").logoutSuccessUrl("/admin/home")
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSONID")
                    .permitAll()
                .and()
                    .rememberMe()
                .and()
                    .exceptionHandling()
                    .accessDeniedPage("/error/403")
                .and().csrf().disable();
    }
}

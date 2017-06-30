package config;

import com.mchange.v2.c3p0.DriverManagerDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import security.UserDetailsServiceImpl;

import javax.sql.DataSource;

/**
 * Created by admin on 2017/6/20.
 */
@Configuration
@EnableWebSecurity
@Import(DatabaseConfig.class)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .formLogin()
//                .and()
//                .httpBasic();
        http.authorizeRequests()
                .antMatchers("/Demo1/*")    // 匹配/Demo1/, 不匹配/Demo1
                .hasAuthority("admin")
                .antMatchers("/Demo1/**")   // 匹配/Demo1/, 也匹配/Demo1
                .authenticated()
                .antMatchers(HttpMethod.POST,"/shop/**")
                .authenticated()
                .anyRequest()
                .permitAll()
                .and()
                .formLogin();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/h2/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 内存用户校验
//        auth.inMemoryAuthentication().withUser("user").password("1111").roles("user");

        // 关系型数据库用户校验
        // 用户权限的表结构和默认表结构完全相同，使用默认sql语句，查询用户和权限信息
        // 默认表结构，可参看spring_security.sql
//        auth.jdbcAuthentication().dataSource(dataSource);

        // 关系型数据库用户校验
        // 自定义表结构，自定义sql语句
//        auth.jdbcAuthentication()
//                .dataSource(dataSource)
//                .usersByUsernameQuery("select username, password, true from users where username = ?")
//                .authoritiesByUsernameQuery("select username, authority from authorities where username = ?")
//                .passwordEncoder(NoOpPasswordEncoder.getInstance());

        // 自定义查询，通过用户名查询用户角色信息
        auth.userDetailsService(new UserDetailsServiceImpl());
    }

}

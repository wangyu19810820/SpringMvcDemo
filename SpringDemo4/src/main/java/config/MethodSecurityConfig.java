package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import security.UserDetailsServiceImpl;

/**
 * Created by admin on 2017/7/7.
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled=true, securedEnabled = true, jsr250Enabled = true)
public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(new UserDetailsServiceImpl());
    }

//    @Bean
//    public SecuredSpittleService spitterService() {
//        return new SecuredSpittleService();
//    }
}

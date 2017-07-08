package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

import javax.sql.DataSource;

/**
 * Created by admin on 2017/5/17.
 */
@Configuration
@ComponentScan(basePackages = {"service"})
@ImportResource("classpath:spring-webflow.xml")
@Import(value = {SecurityConfig.class, MethodSecurityConfig.class})
public class RootConfig {


}

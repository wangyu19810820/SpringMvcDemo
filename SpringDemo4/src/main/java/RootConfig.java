import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by admin on 2017/5/17.
 */
@Configuration
@ComponentScan("service")
@ImportResource("classpath:spring-webflow.xml")
public class RootConfig {
}

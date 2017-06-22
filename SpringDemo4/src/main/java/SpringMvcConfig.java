import interceptor.Interceptor1;
import interceptor.Interceptor2;
import interceptor.Interceptor3;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.web.servlet.view.xml.MappingJackson2XmlView;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by admin on 2017/5/21.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "controller")
public class SpringMvcConfig extends WebMvcConfigurerAdapter {

    // 信息转换器，@ResponseBody将数据转成json
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new MappingJackson2HttpMessageConverter());
    }

    // 多视图协商，配置
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(true).
                favorParameter(false).
                parameterName("mediaType").
                ignoreAcceptHeader(false).
                useJaf(false).
                defaultContentType(MediaType.TEXT_HTML).
                mediaType("xml", MediaType.APPLICATION_XML).
                mediaType("html", MediaType.TEXT_HTML).
                mediaType("json", MediaType.APPLICATION_JSON);
    }

    // 多视图协商，视图解析器
    @Bean
    public ViewResolver cnViewResolver(ContentNegotiationManager cm) {
        ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
        resolver.setContentNegotiationManager(cm);
        resolver.setDefaultViews(Arrays.asList(new MappingJackson2JsonView(), new MappingJackson2XmlView()));
        return resolver;
    }

//    @Bean
//    public ViewResolver beanNameResolver() {
//        return new BeanNameViewResolver();
//    }

    // 普通jsp视图解析器
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    // 拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new Interceptor1())
                .addPathPatterns("/Demo1/**")
                .excludePathPatterns("/Demo1/test");
        registry.addWebRequestInterceptor(new Interceptor2())
                .addPathPatterns("/spittle");
        registry.addInterceptor(new Interceptor3())
                .addPathPatterns("/spittle");
    }


    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);
    }

    /**
     * 国际化，文本的资源文件
     * @return
     */
    @Bean
    public MessageSource messageSource() {
//        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//        messageSource.setBasename("message");

        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:///message");
        messageSource.setCacheSeconds(5);

        return messageSource;
    }

//    @Bean
//    public MultipartResolver multipartResolver() throws IOException {
//        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
//        resolver.setUploadTempDir(new FileSystemResource("e:\\tmp"));
//        resolver.setMaxUploadSize(1024L);
//        resolver.setMaxInMemorySize(0);
//        return resolver;
//    }
}

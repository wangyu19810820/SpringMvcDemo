package interceptor;

import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

/**
 * Created by admin on 2017/6/18.
 */
public class Interceptor2 implements WebRequestInterceptor {
    @Override
    public void preHandle(WebRequest request) throws Exception {
        System.out.println("Interceptor2:preHandle");
    }

    @Override
    public void postHandle(WebRequest request, ModelMap model) throws Exception {
        System.out.println("Interceptor2:postHandle");
    }

    @Override
    public void afterCompletion(WebRequest request, Exception ex) throws Exception {
        System.out.println("Interceptor2:afterCompletion");
    }
}

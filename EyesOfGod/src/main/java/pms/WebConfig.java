package pms;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pms.aop.AuthInterceptor;

//表示配置类
@Configuration  
public class WebConfig implements WebMvcConfigurer   {
	
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       InterceptorRegistration registration = registry.addInterceptor(new AuthInterceptor());     
       registration.addPathPatterns("/**");         //所有路径都被拦截
       registration.excludePathPatterns("/","/login","/css/**","/js/**","/vendors/**");   //添加不拦截路径//开放css
       
    }

}
package autonomoNetwork.myApp.Security;

import autonomoNetwork.myApp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
public class RoleHandlerConfiguration implements WebMvcConfigurer {

    private static class RoleHandlerInterceptor extends HandlerInterceptorAdapter {
        @Override
        public void postHandle(final HttpServletRequest request,
                               final HttpServletResponse response, final Object handler,
                               final ModelAndView modelAndView) {
            if (modelAndView != null) {
                if (request.getUserPrincipal() != null) {
                    modelAndView.addObject("hasLogin",true);
                    modelAndView.addObject("isProfessional", request.isUserInRole("professional"));
                    modelAndView.addObject("isCustomer", request.isUserInRole("customer"));
                    modelAndView.addObject("isAnalyst",request.isUserInRole("analyst"));
                }else{
                    modelAndView.addObject("hasLogin",false);
                }
            }
        }
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new RoleHandlerInterceptor());
    }
}
package interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        if(uri.toUpperCase().contains("LOGIN") ||
                uri.toUpperCase().contains("REGISTER") ||
                request.getSession().getAttribute("user") != null ||
                uri.contains("css") ||
                uri.contains("js") ||
                uri.contains("images")) {
            return true;
        }
        response.sendRedirect(request.getContextPath() + "/user/toLogin.action");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}

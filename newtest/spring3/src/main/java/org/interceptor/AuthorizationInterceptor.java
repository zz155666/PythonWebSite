package org.interceptor;

import org.domain.User3;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ProjectName: spring3
 * @Package: org.interceptor
 * @ClassName: AuthorizationInterceptor
 * @Description: java类作用描述
 * @Author: teerus
 * @CreateDate: 2018/9/10 20:30
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class AuthorizationInterceptor implements HandlerInterceptor {

    private static final String[] IGNORE_URI={"/loginForm2","/login"};

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        System.out.println("afterCompletion------------------>");
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        System.out.println("postHandle------------------>");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle------------------>");
        boolean flag=false;
        String servletPath=request.getServletPath();
        for(String s:IGNORE_URI){
            if(servletPath.contains(s)){
                flag=true;
                break;
            }
        }
        if(!flag){
            User3 user=(User3)request.getSession().getAttribute("user");
            if(user==null){
                System.out.println("preHandle------------------>AuthorizationInterceptor");
                request.setAttribute("message","please login");
                request.getRequestDispatcher("loginForm2").forward(request,response);
            }else{
                System.out.println("preHandle------------------>true");
                flag=true;
            }
        }
        return flag;
    }
}

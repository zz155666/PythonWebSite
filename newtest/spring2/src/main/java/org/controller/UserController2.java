package org.controller;

import org.domain.User;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@Controller
@RequestMapping(value = "/user2")
public class UserController2 {

    @RequestMapping("/loginForm")
    public String loginForm(String request_locale, Model model,HttpServletRequest request){

        System.out.println("request_locale"+request_locale);

        if(request_locale!=null){
            if(request_locale.equals("zh_CN")){
                Locale locale=new Locale("zh","CN");
                request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,locale);
            }else if(request_locale.equals("en_US")){
                Locale locale=new Locale("en","US");
                request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,locale);
            }else{
                request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, LocaleContextHolder.getLocale());
            }

        }

        User user=new User();
        model.addAttribute("user",user);
        return "loginForm2";
    }
    @PostMapping("/login")
    public String login(@ModelAttribute User user, Model model, HttpServletRequest request){

        if(user.getLoginname()!=null&&user.getLoginname().equals("111")
          &&user.getPassword()!=null&&user.getPassword().equals("123456")){
            RequestContext requestContext=new RequestContext(request);
            String username=requestContext.getMessage("username");
            user.setUsername(username);
            model.addAttribute("user",user);
            return "success";
        }

        return "error";
    }
}

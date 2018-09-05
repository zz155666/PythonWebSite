package org.controller;

import org.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/user2")
public class UserController2 {

    @RequestMapping("/loginForm")
    public String loginForm(Model model){
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

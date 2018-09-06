package org.controller;

import org.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ProjectName: spring3
 * @Package: org.controller
 * @ClassName: UserController
 * @Description: java类作用描述
 * @Author: teerus
 * @CreateDate: 2018/9/6 23:01
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Controller
public class UserController {
//    @RequestMapping(value = "/{formName}")
//    public String loginForm(@PathVariable String formName){
//        return formName;
//    }
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(@ModelAttribute User user, Model model){
        model.addAttribute("user",user);
        return "success";
    }
    @RequestMapping(value = "/registerForm")
    public String loginForm(Model model){
        return "registerForm";
    }
}

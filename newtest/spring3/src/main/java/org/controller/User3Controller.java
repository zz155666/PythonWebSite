package org.controller;

import org.domain.User;
import org.domain.User3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @ProjectName: spring3
 * @Package: org.controller
 * @ClassName: User3Controller
 * @Description: java类作用描述
 * @Author: teerus
 * @CreateDate: 2018/9/8 14:17
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Controller
public class User3Controller {
    @Autowired
    @Qualifier("userValidator")
    private UserValidator userValidator;

    @GetMapping("/loginForm")
    public String loginForm(Model model){
        User3 user=new User3();
        model.addAttribute("user",user);
        return "loginForm";
    }

    @PostMapping(value = "/login")
    public String login(@ModelAttribute User3 user, Model model, Errors errors){
        System.out.println(user);
        model.addAttribute("user",user);
        userValidator.validate(user,errors);
        if(errors.hasErrors()){
            return "loginForm";
        }
        return "success3";
    }
}

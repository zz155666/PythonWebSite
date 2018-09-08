package org.controller;

import org.domain.User;
import org.domain.User4;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.jws.WebParam;
import javax.validation.Valid;

/**
 * @ProjectName: spring3
 * @Package: org.controller
 * @ClassName: User4Controller
 * @Description: java类作用描述
 * @Author: teerus
 * @CreateDate: 2018/9/8 15:24
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Controller
public class User4Controller {

    @GetMapping("/registerForm2")
    public String registerForm(Model model){
        User4 user=new User4();
        model.addAttribute("user4",user);
        return "registerForm2";
    }
    @PostMapping("/login2")
    public  String login(@Valid @ModelAttribute User4 user4, Errors errors,Model model){
        System.out.println(user4);
        if(errors.hasErrors()){
            return "registerForm2";
        }
        return "success3";
    }

}

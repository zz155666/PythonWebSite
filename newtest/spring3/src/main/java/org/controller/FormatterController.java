package org.controller;

import org.domain.User2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @ProjectName: spring3
 * @Package: org.controller
 * @ClassName: FormatterController
 * @Description: java类作用描述
 * @Author: teerus
 * @CreateDate: 2018/9/8 13:36
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Controller
public class FormatterController {
    @GetMapping(value = "/testForm")
    public String registerForm(){
        return "testForm";
    }
    @PostMapping(value = "/test")
    public String test(@ModelAttribute User2 user, Model model){
        System.out.println(user);
        model.addAttribute("user",user);
        return "success2";
    }
}

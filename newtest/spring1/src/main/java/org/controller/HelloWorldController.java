package org.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ProjectName: spring1
 * @Package: org.controller
 * @ClassName: HelloWorldController
 * @Description: java类作用描述
 * @Author: teerus
 * @CreateDate: 2018/8/18 14:32
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Controller
public class HelloWorldController {
    @RequestMapping("/helloworld")
    public String helloworld(Model model){
        model.addAttribute("message","Hello World!");
        return "helloworld";
    }
}

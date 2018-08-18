package org.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ProjectName: spring2
 * @Package: org.controller
 * @ClassName: HelloWorldController
 * @Description: java类作用描述
 * @Author: teerus
 * @CreateDate: 2018/8/18 14:57
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Controller
public class HelloWorldController {
    @RequestMapping("/helloWorld")
    public String helloWorld(Model model){
        model.addAttribute("meaage","Hello World!");
        return "helloWorld";
    }
}

package org.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ProjectName: spring2
 * @Package: org.controller
 * @ClassName: Test2ExceptionController
 * @Description: java类作用描述
 * @Author: teerus
 * @CreateDate: 2018/9/1 11:04
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Controller
public class Test2ExceptionController {
    @GetMapping("/test2")
    public String test2() throws Exception{
        int i=5/0;
        return "success";
    }
}

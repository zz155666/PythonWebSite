package org.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ProjectName: spring1
 * @Package: org.controller
 * @ClassName: Hello2Controller
 * @Description: java类作用描述
 * @Author: teerus
 * @CreateDate: 2018/8/18 14:02
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */

@Controller
public class Hello2Controller {
    @RequestMapping(value = "/hello2")
    public ModelAndView hello(){
        System.out.println("hello2 方法被调用");
        // 创建准备返回的ModelAndView对象，该对象通常包含了返回视图的路径、模型的名称以及模型对象
        ModelAndView mv = new ModelAndView();
        // 添加模型数据 可以是任意的POJO对象
        mv.addObject("message", "Hello World 2!");
        // 设置逻辑视图名，视图解析器会根据该名字解析到具体的视图页面
        mv.setViewName("/WEB-INF/content/welcome.jsp");
        // 返回ModelAndView对象。
        return mv;
    }
}

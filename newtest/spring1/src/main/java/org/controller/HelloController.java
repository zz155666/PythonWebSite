package org.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ProjectName: spring1
 * @Package: org.controller
 * @ClassName: HelloController
 * @Description: java类作用描述
 * @Author: teerus
 * @CreateDate: 2018/8/18 13:46
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class HelloController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        System.out.println("handleRequest 被调用");
        // 创建准备返回的ModelAndView对象，该对象通常包含了返回视图的路径、模型的名称以及模型对象
        ModelAndView mv = new ModelAndView();
        // 添加模型数据 可以是任意的POJO对象
        mv.addObject("message", "Hello World!");
        // 设置逻辑视图名，视图解析器会根据该名字解析到具体的视图页面
        mv.setViewName("/WEB-INF/content/welcome.jsp");
        // 返回ModelAndView对象。
        return mv;
    }
}

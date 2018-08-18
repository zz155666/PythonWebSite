package org.controller;

import org.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;


/**
 * @ProjectName: spring2
 * @Package: org.controller
 * @ClassName: ModelController
 * @Description: java类作用描述
 * @Author: teerus
 * @CreateDate: 2018/8/18 15:42
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Controller
public class ModelController {

    @RequestMapping(value="/modelTest")
    public String modelTest(Model model){
        System.out.println("modelTest");
        User user=new User();
        user.setUsername("test");
        model.addAttribute("user",user);
        return "result";
    }
    @RequestMapping(value="/modelMapTest")
    public String modelMapTest(ModelMap modelmap){
        System.out.println("modelMapTest");
        User user=new User();
        user.setUsername("test");
        modelmap.addAttribute("user",user);
        return "result";
    }
    @RequestMapping(value="/ModelAndViewTest")
    public ModelAndView modelMapTest(ModelAndView mv){
        System.out.println("modelMapTest");
        User user=new User();
        user.setUsername("test");
        mv.addObject("user",user);
        mv.setViewName("result");
        return mv;
    }
}

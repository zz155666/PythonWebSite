package org.zxy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ProjectName: hrmapp
 * @Package: org.zxy.controller
 * @ClassName: FormController
 * @Description: java类作用描述
 * @Author: teerus
 * @CreateDate: 2018/10/14 14:40
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Controller
public class FormController{

    @RequestMapping(value="/{formName}")
    public String loginForm(@PathVariable String formName){
        // 动态跳转页面
        return formName;
    }

}

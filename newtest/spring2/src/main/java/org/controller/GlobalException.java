package org.controller;

import org.exception.OrderException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: spring2
 * @Package: org.exception
 * @ClassName: GlobalException
 * @Description: java类作用描述
 * @Author: teerus
 * @CreateDate: 2018/9/1 14:42
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(value = Exception.class)
    public ModelAndView testErrorHandler(Exception e){
        System.out.println("TestController testErrorHandler().......");
        ModelAndView mav=new ModelAndView();
        mav.addObject("ex",e);
        mav.setViewName("error");
        return mav;
    }

    @ExceptionHandler(value = OrderException.class)
    @ResponseBody
    public Object OrderErrorHandler(Exception e) throws Exception{
        Map<String,Object> map=new HashMap<>();
        map.put("code",100);
        map.put("message",e.getMessage());
        map.put("data","请求失败");
        return map;
    }
}

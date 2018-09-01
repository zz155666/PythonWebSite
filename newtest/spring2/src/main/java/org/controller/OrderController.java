package org.controller;

import org.exception.OrderException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @ProjectName: spring2
 * @Package: org.controller
 * @ClassName: OrderController
 * @Description: java类作用描述
 * @Author: teerus
 * @CreateDate: 2018/9/1 14:15
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Controller
public class OrderController {
    @PostMapping("/searcho")
    public String search() throws Exception{
        try {
            int i=5/0;
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            throw new OrderException("订单查询失败");
        }
    }
}

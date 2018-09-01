package org.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.SQLException;

/**
 * @ProjectName: spring2
 * @Package: org.controller
 * @ClassName: TestExceptionController
 * @Description: java类作用描述
 * @Author: teerus
 * @CreateDate: 2018/9/1 10:19
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Controller
public class TestExceptionController {

    @GetMapping("/helloe")
    public String hello() throws Exception{
        // 抛出异常
        throw new Exception();
    }

    @GetMapping("/teste")
    public String test() throws Exception{
        // 模拟异常
        int i = 5/0;
        return "success";
    }

    @GetMapping("/finde")
    public String find() throws Exception{
        try {
            // 模拟异常
            int i = 5/0;
            return "success";
        } catch (Exception e) {
            throw new SQLException("查找数据失败!");
        }

    }
}

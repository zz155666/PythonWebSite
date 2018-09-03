package org.controller;

import org.domain.User;
import org.domain.User2;
import org.domain.User3;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    private static List<User> userList;

    public UserController(){
        super();
        userList=new ArrayList<User>();
    }

    @GetMapping(value = "/register")
    public String registerForm() {
        System.out.println("register GET方法被调用...");
        // 跳转到注册页面
        return "registerForm";
    }
    @PostMapping(value="/register")
    public String register(@RequestParam("loginname") String loginname,
                           @RequestParam("password") String password,
                           @RequestParam("username") String username){
        System.out.println("post方法被调动");
        User user = new User();
        user.setLoginname(loginname);
        user.setPassword(password);
        user.setUsername(username);
        // 模拟数据库存储User信息
        userList.add(user);
        // 跳转到登录页面
        return "loginForm";
    }

    @RequestMapping("/login")
    public String login( @RequestParam("loginname") String loginname,
                         @RequestParam("password") String password,
                         Model model){
        System.out.println("登录名:"+loginname + " 密码:" + password);
        // 到集合中查找用户是否存在，此处用来模拟数据库验证
        for(User user : userList){
            if(user.getLoginname().equals(loginname)
                    && user.getPassword().equals(password)){
                model.addAttribute("user",user);
                return "welcome";
            }
        }
        return "loginForm";
    }

    @GetMapping(value = "/checkboxForm")
    public String registerForm(Model model){
        User2 user=new User2();
        user.setReader(true);
        List<String> list=new ArrayList<String>();
        list.add("JAVAEE");
        list.add("Spring");
        user.setCourses(list);
        model.addAttribute("user",user);
        return "checkboxForm";
    }
    @GetMapping(value = "/checkboxesForm")
    public String registerForms(Model model){
        User3 user=new User3();
        List<String> list=new ArrayList<String>();
        list.add("JAVAEE");
        list.add("Spring");
        user.setCources(list);
        List<String> courceList=new ArrayList<String>();
        courceList.add("JAVAEE");
        courceList.add("Mybatis");
        courceList.add("Spring");
        model.addAttribute("user",user);
        model.addAttribute("courseList",courceList);
        return "checkboxesForm";
    }
    @GetMapping(value = "/checkboxesForm2")
    public String registerForms2(Model model){
        User3 user=new User3();
        List<String> list=new ArrayList<String>();
        list.add("1");
        list.add("2");
        user.setCources(list);
        Map<String,String> courceList=new HashMap<String,String>();
        courceList.put("1","JAVAEE");
        courceList.put("2","Mybatis");
        courceList.put("3","Spring");
        model.addAttribute("user",user);
        model.addAttribute("courseList",courceList);
        return "checkboxesForm";
    }

}

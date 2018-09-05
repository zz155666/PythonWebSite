package org.controller;

import org.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.validator.UserValidator;

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

    @GetMapping(value = "/checkboxesForm3")
    public String registerForm3(Model model){
        Employee employee=new Employee();
        Dept dept=new Dept(1,"开发部");
        List<Dept> list=new ArrayList<Dept>();
        list.add(dept);
        employee.setDepts(list);
        List<Dept> deptList=new ArrayList<Dept>();
        deptList.add(dept);
        deptList.add(new Dept(2,"销售部"));
        deptList.add(new Dept(3,"财务部"));
        model.addAttribute("employee",employee);
        model.addAttribute("deptList",deptList);
        return "checkboxesForm3";
    }

    @GetMapping("/selectForm")
    public String selectForm(Model model){
        User4 user=new User4();
        user.setDeptId(2);
        model.addAttribute("user",user);
        return "selectForm";
    }
    @GetMapping("selectForm2")
    public String selectForm2(Model model){
        User4 user=new User4();
        user.setDeptId(2);
        Map<Integer,String> deptmap=new HashMap<Integer,String>();
        deptmap.put(1,"财务部");
        deptmap.put(2,"开发部");
        deptmap.put(3,"销售部");
        model.addAttribute("user",user);
        model.addAttribute("deptmap",deptmap);
        return "selectForm2";
    }

    @GetMapping(value = "/registerForm2")
    public String registerForm2(Model model){
        User5 user=new User5();
        model.addAttribute("user5",user);
        return "registerForm2";
    }
    @InitBinder
    public void initBinder(DataBinder binder){
        binder.setValidator(new UserValidator());
    }
    @PostMapping(value = "/register2")
    public String register(@Validated User5 user5, Errors errors){
        if(errors.hasFieldErrors()){
            return "registerForm2";
        }
        return "submit";
    }

}

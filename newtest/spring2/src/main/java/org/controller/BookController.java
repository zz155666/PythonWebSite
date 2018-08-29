package org.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.domain.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/json")
public class BookController {
    private static final Log logger= LogFactory.getLog(BookController.class);
    @RequestMapping("/testRequestBody")
    public void setJson(@RequestBody Book book,
                        HttpServletResponse response) throws Exception{
        ObjectMapper mapper=new ObjectMapper();
        System.out.println(mapper.writeValueAsString(book));
        book.setAuthor("ceshi");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println(mapper.writeValueAsString(book));
    }

    @RequestMapping("/testRequestBody2")
    public void setJson2(@RequestBody Book book,
                        HttpServletResponse response) throws Exception{
        System.out.println(JSONObject.toJSONString(book));
        book.setAuthor("ceshi");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println(JSONObject.toJSONString(book));
    }

    @RequestMapping("/testRequestBody3")
    @ResponseBody
    public Object getJson(){
        List<Book> list=new ArrayList<Book>();
        list.add(new Book(1,"test","1111"));
        list.add(new Book(2,"test2","2222"));
        return list;
    }
}

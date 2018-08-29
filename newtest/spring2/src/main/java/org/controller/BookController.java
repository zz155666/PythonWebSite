package org.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.domain.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;


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
}

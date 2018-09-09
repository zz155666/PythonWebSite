package org.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * @ProjectName: spring3
 * @Package: org.controller
 * @ClassName: FileUploadController
 * @Description: java类作用描述
 * @Author: teerus
 * @CreateDate: 2018/9/8 22:53
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Controller
public class FileUploadController {
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String upload(HttpServletRequest request,
                         @RequestParam("description") String description,
                         @RequestParam("file")MultipartFile file) throws Exception{
        System.out.println(description);
        if(!file.isEmpty()){
            String path=request.getServletContext().getRealPath("/images/");
            String filename=file.getOriginalFilename();
            File filepath=new File(path,filename);
            if(!filepath.getParentFile().exists()){
                filepath.getParentFile().mkdirs();
            }
            file.transferTo(new File(path+File.separator+filename));
            return "success4";
        }
        return "error";
    }

    @GetMapping(value="/uploadForm")
    public String uploadForm(){
        // 跳转到文件上传页面
        return "uploadForm";
    }

}

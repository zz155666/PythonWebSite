package org.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.net.URLEncoder;

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

    @GetMapping("/download")
    public ResponseEntity<byte[]> download(HttpServletRequest request,
                                           @RequestParam("filename") String filename, @RequestHeader("User-Agent") String userAgent) throws  Exception{
        String path=request.getServletContext().getRealPath("/images");
        File file=new File(path+File.separator+filename);
        ResponseEntity.BodyBuilder builder=ResponseEntity.ok();
        builder.contentLength(file.length());
        builder.contentType(MediaType.APPLICATION_OCTET_STREAM);
        filename= URLEncoder.encode(filename,"UTF-8");
        if(userAgent.indexOf("MSIE")>0){
            builder.header("Content-Disposition","attachment;filename="+filename);
        }else{
            builder.header("Content-Disposition","attachment;filename*=UTF-8''"+filename);
        }
        return builder.body(FileUtils.readFileToByteArray(file));
    }

    @GetMapping(value="/uploadForm")
    public String uploadForm(){
        // 跳转到文件上传页面
        return "uploadForm";
    }

}

package com.ohgiraffers.fileupload;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadContoroller {

    /* 설명.  multipart/form-data로 넘어오는 값은 MultipartFile로 받아내야 한다. */
    @PostMapping("single-file")
    public String singleFile(@RequestParam MultipartFile singleFile,
                             @RequestParam String singleFileDescription) {

        System.out.println("singleFile = " + singleFile);
        System.out.println("singleFileDescription = " + singleFileDescription);

        return "redirect:/result";
    }

    @GetMapping("result")
    public void result() {}

}

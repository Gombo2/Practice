package com.ohgiraffers.fileupload;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
public class FileUploadController {

    @Value("${filepath}")
    private String filePath;

    /* 설명. multipart/form-data로 넘어오는 값은 MultipartFile로 받아내야 한다. */
    @PostMapping("single-file")
    public String singleFile(@RequestParam MultipartFile singleFile,
                             @RequestParam String singleFileDescription,
                             RedirectAttributes rttr) {
//        System.out.println("singleFile = " + singleFile);
//        System.out.println("singleFileDescription = " + singleFileDescription);

        /* 설명. 1. 저장될 파일의 경로 설정 후 파일 저장 */
        /* 설명. 2. 파일의 이름 리네임 */
        /* 설명. 3. DB로 보낼 데이터 만들기(Map<String, String>, List<Map<String, String>>) */
//        String filePath = "C:\\uploadFiles";

        /* 설명. 사용자가 넘긴 파일의 원본이름을 확인하고 rename해보자.
         *       (자바의 UUID 클래스를 이용한 무작위 문자열 형태로 생성)
         *  */
        String originFileName = singleFile.getOriginalFilename();
        System.out.println("originFileName = " + originFileName);

        String ext = originFileName.substring(originFileName.lastIndexOf("."));
        System.out.println("ext = " + ext);

        String savedName = UUID.randomUUID().toString().replace("-", "") + ext;
        System.out.println("savedName = " + savedName);

        /* 설명. 우리가 지정한 경로로 파일을 저장 */
        try {
            singleFile.transferTo(new File(filePath + "/img/single/" + savedName));

            /* 설명. DB로 보낼 데이터 Map으로 가공 처리 */
            Map<String, String> file = new HashMap<>();
            file.put("originFileName", originFileName);
            file.put("savedName", savedName);
            file.put("filePath", "/img/single");
            file.put("singleFileDescription", singleFileDescription);

            /* 설명. 이후 service 계층을 통해 DB에 사용자가 업로드 한 파일의 내용을 저장하고 옴(지금 작성할 내용은 X) */
//            fileUploadService.registFile(file);

            rttr.addFlashAttribute("message", originFileName + " 파일 업로드 성공!");
            rttr.addFlashAttribute("img", "/img/single/" + savedName);
            rttr.addFlashAttribute("singleFileDescription", singleFileDescription);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return "redirect:/result";
    }

    @PostMapping("multi-file")
    public String multiFileUpload(@RequestParam List<MultipartFile> multiFiles,
                                  @RequestParam String multiFileDescription,
                                  RedirectAttributes rttr) {

//        String filePath = "C:\\uploadFiles";

        /* 설명. DB에 보낼 값을 담기 위한 컬렉션 */
        List<Map<String, String>> files = new ArrayList<>();

        /* 설명. 화면에서 각 파일마다 img 태그의 src 속성으로 적용하기 위한 문자열을 담은 컬렉션 */
        List<String> imgSrcs = new ArrayList<>();

        try {
            for (int i = 0; i < multiFiles.size(); i++) {

                /* 설명. 각 파일마다 리네임 */
                String originFileName = multiFiles.get(i).getOriginalFilename();
                String ext = originFileName.substring(originFileName.lastIndexOf("."));
                String savedName = UUID.randomUUID().toString().replace("-", "") + ext;

                /* 설명. 파일 저장 경로에 저장 */
                multiFiles.get(i).transferTo(new File(filePath + "/img/multi/" + savedName));

                /* 설명. DB에 보낼 값 설정(Map<String, String>) */
                Map<String, String> file = new HashMap<>();
                file.put("originFileName", originFileName);
                file.put("savedName", savedName);
                file.put("filePath", "/img/multi");
                file.put("multiFileDescription", multiFileDescription);

                files.add(file);
                imgSrcs.add("/img/multi/" + savedName);
            }   // for end

            /* 설명. singleFile 업로드 때와 마찬가지로 DB를 다녀옴(지금 작성할 내용은 X) */
//            fileUploadService.registFile(files);

            /* 설명. 여기까지 성공했다면 파일 저장 및 DB insert까지 모두 완성되었으니 화면의 재료 작성 */
            rttr.addFlashAttribute("message", "다중 파일 업로드 성공!");
            rttr.addFlashAttribute("imgs", imgSrcs);
            rttr.addFlashAttribute("multiFileDescription", multiFileDescription);
        } catch (IOException e) {

            /* 설명. transferTo로 파일을 경로에 저장하다가 예외가 발생하면 앞에 이미 성공해서 저장된 파일들을 찾아 지움 */
            for (int i = 0; i < files.size(); i++) {
                Map<String, String> file = files.get(i);
                new File(filePath + "/img/multi/" + file.get("savedName")).delete();
            }

            rttr.addFlashAttribute("message", "파일 업로드 실패");
        }


        return "redirect:/result";
    }

    @GetMapping("result")
    public void result() {}

}
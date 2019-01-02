package com.zking.ssm01.controller;



import com.zking.ssm01.model.Book;
import com.zking.ssm01.model.BookFile;
import com.zking.ssm01.Service.IBookFileService;
import com.zking.ssm01.model.BookFileVo;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;


@Controller
@RequestMapping("/bookFile")
public class BookFileController {


    @Autowired
    private IBookFileService bookFileService;

    @RequestMapping("/upload")
    public String upload(BookFileVo bookFileVo,HttpServletRequest req) throws IOException {

        //BookFileVo
        //1)File文件 （文件名、文件类型、File）
        //2)bookId
        //3)使用UUID生产fileId

        System.out.println(bookFileVo.getBookId());
        MultipartFile img = bookFileVo.getImg();
        System.out.println(img.getContentType());
        System.out.println(img.getOriginalFilename());
        String fileId= UUID.randomUUID().toString().replace("-","");

        //文件路径
//      String filePath=req.getSession().getServletContext().getRealPath("/WEB-INF/image/"+img.getOriginalFilename());
        String filePath="D:\\"+img.getOriginalFilename();
        System.out.println(img.getOriginalFilename()+"--------------------------------");
        System.out.println(filePath+"===========================");
        //1.保存文件上传信息和修改书本的图片信息
        BookFile bookFile=new BookFile();
        bookFile.setFileId(fileId);
        bookFile.setContentType(img.getContentType());
        bookFile.setRealName(img.getOriginalFilename());
        bookFile.setUrl(filePath);


        Book book=new Book();
        book.setId(bookFileVo.getBookId());
        book.setPhoto(fileId);

        bookFileService.insert(bookFile,book);
        //2.上传文件到指定目录
        img.transferTo(new File(filePath));

        return "redirect:/book/toList";
    }



    @RequestMapping("/toBookFile")
    public String toBookFile(@RequestParam  Integer bookId,Model model){
        System.out.println(bookId+"==================================");
        model.addAttribute("bookId",bookId);
        return "book/bookFile";
    }



    @RequestMapping("/download")
    public ResponseEntity<byte[]> download(@RequestParam String fileId){
        try {
            //先根据文件id查询对应图片信息
            BookFile bookFile = bookFileService.selectByPrimaryKey(fileId);

            //下载关键代码
            File file=new File(bookFile.getUrl());
            String fileName = bookFile.getRealName();
            HttpHeaders headers = new HttpHeaders();//http头信息
            String downloadFileName = new String(fileName.getBytes("UTF-8"),"iso-8859-1");//设置编码
            headers.setContentDispositionFormData("attachment", downloadFileName);
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            //MediaType:互联网媒介类型  contentType：具体请求中的媒体类型信息
            return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

package com.zking.ssm01.controller;

import com.zking.ssm01.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Locale;

@Controller
//@RequestMapping("/toHome")
public class toController {
    @RequestMapping("/home/index.shtml")
    public String toIndex(){
        System.out.println("欢迎进入");
        return "index";
    }

    @RequestMapping("/toHome")
   public String toHome(Book book,HttpServletRequest request,@RequestParam HashMap<String,Object> params,Model model){
       System.out.println(book);
       System.out.println(request.getRequestURL());
       System.out.println(request.getRequestURI());
//       System.out.println(sex);
       System.out.println(params);
       model.addAttribute("params",params);

       return  "forward:toHome1";
   }
   @RequestMapping("/toHome1")
   public String toHome1(HttpSession session,@RequestParam String str){
       if(str.equals("en"))
           session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,Locale.US);
       else
           session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, Locale.CHINA);
       return "index";
   }
}

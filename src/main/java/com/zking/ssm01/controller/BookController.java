package com.zking.ssm01.controller;

import com.zking.ssm01.Service.IBookService;
import com.zking.ssm01.model.Book;
import com.zking.ssm01.model.BookType;
import com.zking.ssm01.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@RequestMapping("/book")
public class BookController  {

    @Autowired
    private IBookService bookService;

    @ModelAttribute
    public void init(Model model){
        List<BookType> lst=new ArrayList<BookType>();
        lst.add(new BookType("休闲","休闲"));
        lst.add(new BookType("衍生","衍生"));
        lst.add(new BookType("保健","保健"));

        Book book=new Book();
        model.addAttribute("bType",lst);
        model.addAttribute("book",book);
    }

    @RequestMapping("/toAdd")
    public  String toAdd(){
        System.out.println("toAdd");
        return "book/addBook";
    }



    @RequestMapping("/addBook")
    public  String addBook(@Validated(value = Book.ValidateGroups.del.class)  Book book, BindingResult bindingResult, Model model){


//        if (insert>0)
//            model.addAttribute("message","新增书本成功");
//        else
//            model.addAttribute("message","新增书本失败");

        if (bindingResult.hasErrors()){

            return "book/addBook";
        }else{
            int insert = bookService.insert(book);
            return "redirect:toList";
        }

    }

    @RequestMapping("/toList")
    public  String bookList(Book book, HttpServletRequest req,Model model){
        PageBean pageBean=new PageBean();
        pageBean.setRequest(req);

        List<Book> books = bookService.queryBookPager(book, pageBean);

        model.addAttribute("rows",books);
        model.addAttribute("pageBean",pageBean);

        return "book/bookList";
    }

    @RequestMapping("/toList1")
    @ResponseBody
    public Map<String,Object> bookList1(Book book, HttpServletRequest req, Model model){
        PageBean pageBean=new PageBean();
        pageBean.setRequest(req);
        List<Book> books = bookService.queryBookPager(book, pageBean);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("rows",books);
        map.put("total",pageBean.getTotal());

        return map;

    }
    @RequestMapping("/toList2")
    @ResponseBody
    public Book bookList2(@RequestParam Integer id){
        Book book = bookService.selectByPrimaryKey(id);
        book.setDate(new Date());
        return book;

    }


}

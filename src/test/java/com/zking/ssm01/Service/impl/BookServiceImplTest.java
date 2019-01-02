package com.zking.ssm01.Service.impl;

import com.zking.ssm01.Service.IBookService;
import com.zking.ssm01.model.Book;
import com.zking.ssm01.util.PageBean;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class BookServiceImplTest extends BaseTestCase{

    @Autowired
    private IBookService bookService;

    public void setUP(){
        super.setUp();
    }

    @Test
    public void insert() {
        book.setBookname("魅黑");
        book.setBooktype("神话");
        book.setPrice(100f);
        bookService.insert(book);
    }

    @Test
    public void queryBookPager() {
        book.setBookname("%1%");

        PageBean pageBean=new PageBean() ;
        pageBean.setRows(6);
        pageBean.setPage(2);

        List<Book> books = bookService.queryBookPager(book, pageBean);
        for (Book book1 : books) {
            System.out.println(book1);
        }
//        System.out.println("PageBean的总记录数:"+pageBean.getTotal());

        System.out.println("---------------------------");
        List<Book> booksa = bookService.queryBookPager(book, pageBean);
        for (Book book1 : booksa) {
            System.out.println(book1);
        }
    }

    @Test
    public void querySingleBook(){
        Book book1 = bookService.selectByPrimaryKey(1);
        System.out.println(book1);

        System.out.println("-----------------------------------------");
        Book book2 = bookService.selectByPrimaryKey(1);
        System.out.println(book2);

    }

}
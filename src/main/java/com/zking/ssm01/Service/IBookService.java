package com.zking.ssm01.Service;

import com.zking.ssm01.model.Book;
import com.zking.ssm01.util.PageBean;

import java.util.List;

public interface IBookService {
    int deleteByPrimaryKey(Integer id);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);

    List<Book> queryBookPager(Book book, PageBean pageBean);
}
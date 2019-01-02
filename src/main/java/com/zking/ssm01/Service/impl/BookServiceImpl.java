package com.zking.ssm01.Service.impl;

import com.zking.ssm01.Service.IBookService;
import com.zking.ssm01.mapper.BookMapper;
import com.zking.ssm01.model.Book;
import com.zking.ssm01.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class BookServiceImpl implements IBookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Transactional
    @Override
    public int insert(Book record) {
        return bookMapper.insert(record);

    }

    @Override
    public int insertSelective(Book record) {
        return 0;
    }

    @Transactional
    @Override
    public Book selectByPrimaryKey(Integer id) {
        return bookMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Book record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Book record) {
        return 0;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> queryBookPager(Book book, PageBean pageBean) {
        return bookMapper.queryBookPager(book);
    }
}

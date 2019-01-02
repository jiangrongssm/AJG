package com.zking.ssm01.Service.impl;

import com.sun.org.glassfish.external.arc.Taxonomy;
import com.zking.ssm01.Service.IBookFileService;
import com.zking.ssm01.mapper.BookFileMapper;
import com.zking.ssm01.mapper.BookMapper;
import com.zking.ssm01.model.Book;
import com.zking.ssm01.model.BookFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class BookFileServiceImpl implements IBookFileService {

    @Autowired
    private BookFileMapper bookFileMapper;

    @Autowired
    private BookMapper bookMapper;

    @Transactional
    @Override
    public int insert(BookFile record, Book book) {

        bookFileMapper.insert(record);

        bookMapper.updateBookFileBy(book);

        return 1;
    }

    @Transactional(readOnly = true)

    @Override
    public BookFile selectByPrimaryKey(String fileId) {
        return bookFileMapper.selectByPrimaryKey(fileId);
    }
}

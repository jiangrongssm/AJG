package com.zking.ssm01.Service;

import com.zking.ssm01.model.Book;
import com.zking.ssm01.model.BookFile;
import org.springframework.stereotype.Repository;

public interface IBookFileService {

    int insert(BookFile record, Book book);

    BookFile selectByPrimaryKey(String fileId);


}
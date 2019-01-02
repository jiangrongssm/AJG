package com.zking.ssm01.mapper;

import com.zking.ssm01.model.BookFile;
import org.springframework.stereotype.Repository;

@Repository
public interface BookFileMapper {


    int insert(BookFile record);


    BookFile selectByPrimaryKey(String fileId);


}
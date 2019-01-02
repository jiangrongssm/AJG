package com.zking.ssm01.model;

import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

@ToString
public class BookFileVo implements Serializable {

    private Integer bookId;

    private MultipartFile img;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public MultipartFile getImg() {
        return img;
    }

    public void setImg(MultipartFile img) {
        this.img = img;
    }

    public BookFileVo(Integer bookId, MultipartFile img) {
        this.bookId = bookId;
        this.img = img;
    }

    public BookFileVo() {
    }
}

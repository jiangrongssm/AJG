package com.zking.ssm01.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@ToString
//多列忽略前端不显示
//@JsonIgnoreProperties(value = {"bookname","booktype"})
public class Book implements Serializable{

    public  static  interface ValidateGroups{
        interface add{}
        interface del{}
    }
    @NotNull(message = "书本ID不能为空",groups = Book.ValidateGroups.del.class)
//    @NotNull(message = "书本ID不能为空")
    private Integer id;

    @NotBlank(message = "书本名称不能为空",groups = Book.ValidateGroups.add.class)
//    @NotBlank(message = "书本名称不能为空")
    private String bookname;

    @NotNull(message = "书本价格不能为空",groups = Book.ValidateGroups.add.class)
//      @NotNull(message = "书本价格不能为空")
//    @Range(min = 60,message = "书本价格不能低于60$")
    private Float price;

    //起别名
    @JsonProperty("type")
    private String booktype;

    @JsonIgnore
    private String photo;


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Book(Integer id, String bookname, Float price, String booktype) {
        this.id = id;
        this.bookname = bookname;
        this.price = price;
        this.booktype = booktype;
    }

    public Book() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getBooktype() {
        return booktype;
    }

    public void setBooktype(String booktype) {
        this.booktype = booktype;
    }
}
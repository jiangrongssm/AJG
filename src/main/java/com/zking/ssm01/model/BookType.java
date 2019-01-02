package com.zking.ssm01.model;

import lombok.ToString;

import java.io.Serializable;

@ToString
public class BookType implements Serializable {

    private String bname;
    private String bvalue;

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getBvalue() {
        return bvalue;
    }

    public void setBvalue(String bvalue) {
        this.bvalue = bvalue;
    }

    public BookType(String bname, String bvalue) {
        this.bname = bname;
        this.bvalue = bvalue;
    }

    public BookType() {
    }
}

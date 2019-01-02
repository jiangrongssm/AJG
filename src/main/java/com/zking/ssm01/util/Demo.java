package com.zking.ssm01.util;


import java.util.Locale;

public class Demo {
    public static void main(String[] args) {
        Locale locale = Locale.CHINA;
        System.out.println(locale.getLanguage());
        System.out.println(locale.toString());
        System.out.println(locale.getDisplayName());
    }
}

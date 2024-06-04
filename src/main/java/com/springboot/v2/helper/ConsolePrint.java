package com.springboot.v2.helper;

import org.springframework.stereotype.Component;

public class ConsolePrint implements Printer {

    @Override
    public void print(String str) {
        System.out.println(str);
    }
}

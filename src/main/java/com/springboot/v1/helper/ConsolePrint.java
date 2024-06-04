package com.springboot.v1.helper;

import org.springframework.stereotype.Component;

public class ConsolePrint implements Printer {

    @Override
    public void print(String str) {
        System.out.println(str);
    }
}

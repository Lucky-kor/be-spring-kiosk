package com.springboot.v4.helper;

import org.springframework.stereotype.Component;

@Component
public class ConsolePrint implements Printer {

    @Override
    public void print(String str) {
        System.out.println(str);
    }
}

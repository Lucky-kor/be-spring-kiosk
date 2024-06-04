package com.springboot.v5.helper;

import org.springframework.stereotype.Component;

@Component
public class ConsolePrint implements Printer {

    @Override
    public void print(String str) {
        System.out.println(str);
    }
}

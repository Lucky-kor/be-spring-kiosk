package com.springboot.v3.helper;

public class DisplayPrinter implements Printer {
    @Override
    public void print(String str) {
        System.out.print(str);
    }
}

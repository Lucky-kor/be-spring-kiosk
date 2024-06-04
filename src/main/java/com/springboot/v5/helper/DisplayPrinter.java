package com.springboot.v5.helper;

public class DisplayPrinter implements Printer {
    @Override
    public void print(String str) {
        System.out.print(str);
    }
}

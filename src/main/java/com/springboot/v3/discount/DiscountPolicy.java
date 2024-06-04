package com.springboot.v3.discount;

public interface DiscountPolicy {
    double applyDiscount(double price);
}
package com.springboot.v2.discount;

public interface DiscountPolicy {
    double applyDiscount(double price);
}
package com.springboot.v1.discount;

public interface DiscountPolicy {
    double applyDiscount(double price);
}
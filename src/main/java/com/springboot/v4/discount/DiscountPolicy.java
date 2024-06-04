package com.springboot.v4.discount;

public interface DiscountPolicy {
    double applyDiscount(double price);
}
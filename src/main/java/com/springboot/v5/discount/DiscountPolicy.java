package com.springboot.v5.discount;

public interface DiscountPolicy {
    double applyDiscount(double price);
}
package com.springboot.v2.discount;

public class FixedAmountDiscountPolicy implements DiscountPolicy {
    private double discountAmount;

    public FixedAmountDiscountPolicy(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    @Override
    public double applyDiscount(double price) {
        return price - discountAmount;
    }
}
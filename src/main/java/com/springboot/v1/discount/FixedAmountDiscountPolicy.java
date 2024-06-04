package com.springboot.v1.discount;

public class FixedAmountDiscountPolicy implements com.springboot.v1.discount.DiscountPolicy {
    private double discountAmount;

    public FixedAmountDiscountPolicy(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    @Override
    public double applyDiscount(double price) {
        return price - discountAmount;
    }
}
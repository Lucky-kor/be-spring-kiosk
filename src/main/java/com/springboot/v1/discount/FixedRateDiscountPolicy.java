package com.springboot.v1.discount;

public class FixedRateDiscountPolicy implements com.springboot.v1.discount.DiscountPolicy {
    private double discountRate;

    public FixedRateDiscountPolicy(double discountRate) {
        this.discountRate = discountRate;
    }

    @Override
    public double applyDiscount(double price) {
        return price * (1 - discountRate);
    }
}

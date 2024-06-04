package com.springboot.v2.discount;

public class FixedRateDiscountPolicy implements DiscountPolicy {
    private double discountRate;

    public FixedRateDiscountPolicy(double discountRate) {
        this.discountRate = discountRate;
    }

    @Override
    public double applyDiscount(double price) {
        return price * (1 - discountRate);
    }
}

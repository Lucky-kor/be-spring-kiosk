package com.springboot.v5.discount;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("fixedAmount")
public class FixedAmountDiscountPolicy implements DiscountPolicy {
    private double discountAmount;
    private final double amount = 100;

    public FixedAmountDiscountPolicy() {
        this.discountAmount = amount;
    }

    @Override
    public double applyDiscount(double price) {
        return price - discountAmount;
    }
}
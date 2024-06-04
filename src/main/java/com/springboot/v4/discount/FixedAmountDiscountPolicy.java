package com.springboot.v4.discount;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Qualifier("fixedAmount")
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
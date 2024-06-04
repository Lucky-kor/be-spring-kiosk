package com.springboot.v4.discount;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Qualifier("fixedRate")
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

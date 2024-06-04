package com.springboot.v5.discount;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("fixedRate")
public class FixedRateDiscountPolicy implements DiscountPolicy {
    private double discountRate;
    private final double rate = 20.0;
    public FixedRateDiscountPolicy() {
        this.discountRate = rate;
    }

    @Override
    public double applyDiscount(double price) {
        return price * (100 - discountRate);
    }
}

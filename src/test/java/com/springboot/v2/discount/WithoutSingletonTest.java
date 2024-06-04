package com.springboot.v2.discount;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class WithoutSingletonTest {
    // 싱글톤 구현 X
    @Test
    void runWithoutSingleton() {

        TestConfig testConfig = new TestConfig();

        // productRepository 객체 생성
        DiscountPolicy discountPolicy = testConfig.getDiscountPolicy();
        DiscountPolicy discountPolicy2 = testConfig.getDiscountPolicy();

        // 출력
        System.out.println("discountPolicy = " + discountPolicy);
        System.out.println("discountPolicy2 = " + discountPolicy2);

        // 생성한 두 개의 객체가 다른 참조값을 가지고 있는지 검증
        Assertions.assertThat(discountPolicy).isNotSameAs(discountPolicy2);
    }

    // 테스트를 위한 TestConfig 클래스
    static class TestConfig {

        public DiscountPolicy getDiscountPolicy() {
            return new FixedAmountDiscountPolicy(100);
        }
    }
}
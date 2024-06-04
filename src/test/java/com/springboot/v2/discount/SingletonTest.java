package com.springboot.v2.discount;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SingletonTest {
    // 싱글톤 구현 X
    @Test
    void runWithoutSingleton() {

        TestConfig2 testConfig = new TestConfig2();

        // productRepository 객체 생성
        DiscountPolicy discountPolicy = testConfig.getDiscountPolicy();
        DiscountPolicy discountPolicy2 = testConfig.getDiscountPolicy();

        // 출력
        System.out.println("discountPolicy = " + discountPolicy);
        System.out.println("discountPolicy2 = " + discountPolicy2);

        // 생성한 두 개의 객체가 다른 참조값을 가지고 있는지 검증
        Assertions.assertThat(discountPolicy).isSameAs(discountPolicy2);
    }

    // 테스트를 위한 TestConfig 클래스
    static class TestConfig2 {

        private final DiscountPolicy discountPolicy = new FixedAmountDiscountPolicy(100);

        private TestConfig2(){}

        public DiscountPolicy getDiscountPolicy() {
            return discountPolicy;
        }
    }
}
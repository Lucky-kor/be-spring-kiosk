package com.springboot.v2;

import com.springboot.v2.discount.DiscountPolicy;
import com.springboot.v2.helper.Printer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class KioskApplicationTest {
    // 스프링 컨테이너 생성
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

    // 빈 조회 테스트케이스
    @Test
    void findBean() {

        // (1) given => 초기화 또는 테스트에 필요한 입력 데이터
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        // (2) when => 테스트 할 동작
        DiscountPolicy discountPolicy = applicationContext.getBean("discountPolicy", DiscountPolicy.class);

        // (3) then => 검증
        Assertions.assertThat(discountPolicy).isInstanceOf(DiscountPolicy.class);
    }

    @Test
    void findBean_2() {

        // (1) given => 초기화 또는 테스트에 필요한 입력 데이터
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        // (2) when => 테스트 할 동작
        Printer printer = applicationContext.getBean("printer", Printer.class);

        // (3) then => 검증
        Assertions.assertThat(printer).isInstanceOf(DiscountPolicy.class);
    }
}
package com.springboot.v2;

import com.springboot.v2.discount.DiscountPolicy;
import com.springboot.v2.discount.FixedAmountDiscountPolicy;
import com.springboot.v2.helper.DisplayPrinter;
import com.springboot.v2.helper.Printer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public DiscountPolicy discountPolicy() {
        return new FixedAmountDiscountPolicy(100); // 할인 금액을 여기서 설정
    }

    @Bean
    public MenuItem[] menuItems() {
        return new MenuItem[]{
                new MenuItem("김밥", 1500),
                new MenuItem("계란 김밥", 2000),
                new MenuItem("충무 김밥", 8000),
                new MenuItem("치즈 김밥", 4000),
                new MenuItem("참치 김밥", 4500),
                new MenuItem("돈까스 김밥", 5000),
                new MenuItem("떡볶이", 5000),
                new MenuItem("라볶이", 6000),
                new MenuItem("쫄면", 6500),
                new MenuItem("우동", 4500)
        };
    }

    @Bean
    public DisplayPrinter printer() {
        return new DisplayPrinter();
    }

    @Bean
    public Kiosk kiosk(MenuItem[] menuItems, DisplayPrinter printer, DiscountPolicy discountPolicy) {
        return new Kiosk(menuItems, printer, discountPolicy);
    }
}

package com.springboot.v2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppConfigTest {
    @Test
    void checkCartSingleton() {

        // given - 컨테이너 생성
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        // when - 빈 조회
        Kiosk kiosk = applicationContext.getBean("kiosk", Kiosk.class);
        Kiosk kiosk2 = applicationContext.getBean("kiosk", Kiosk.class);

        // 출력
        System.out.println("kiosk = " + kiosk);
        System.out.println("kiosk2 = " + kiosk2);

        // then - 검증
        Assertions.assertThat(kiosk).isSameAs(kiosk2);

    }
}

package com.springboot.v4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class KioskApplication implements CommandLineRunner {

    private Kiosk kiosk;

    @Autowired
    public KioskApplication(Kiosk kiosk) {
        this.kiosk = kiosk;
    }

    public static void main(String[] args) {
        SpringApplication.run(KioskApplication.class, args);
    }

    @Override
    public void run(String... args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = applicationContext.getBean(beanDefinitionName);
            System.out.println("beanName=" + beanDefinitionName + " object=" + bean);
        }

        kiosk.welcomePrintMessage();
        MenuItem menu = kiosk.selectMenu();
        int count = kiosk.selectMenuCount();
        int currentOrderPrice = kiosk.calculateOrderPrice(menu, count);
        if(currentOrderPrice == -1) {
            System.out.println("알 수 없는 오류가 발생했습니다.\n" +
                    " 처음부터 다시 주문을 시작해 주세요.");
            return;
        }
        kiosk.printOrderPriceMessage(currentOrderPrice, menu, count);
    }
}


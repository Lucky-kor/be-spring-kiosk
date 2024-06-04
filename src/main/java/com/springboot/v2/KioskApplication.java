package com.springboot.v2;

import com.springboot.v2.discount.DiscountPolicy;
import com.springboot.v2.helper.Printer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
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

        // (2) 빈 조회
        DiscountPolicy discountPolicy = applicationContext.getBean("discountPolicy", DiscountPolicy.class);
        Printer printer = applicationContext.getBean("printer", Printer.class);
        Kiosk kiosk_check = applicationContext.getBean("kiosk", Kiosk.class);

//        System.out.println(discountPolicy);
//        System.out.println(printer);
//        System.out.println(kiosk_check);

//        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
//
//        for (String beanDefinitionName : beanDefinitionNames) {
//            Object bean = applicationContext.getBean(beanDefinitionName);
//            System.out.println("beanName=" + beanDefinitionName + " object=" + bean);
//        }

//        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
//
//        for (String beanDefinitionName : beanDefinitionNames) {
//            BeanDefinition beanDefinition = applicationContext.getBeanFactory().getBeanDefinition(beanDefinitionName);
//            System.out.println("Bean name: " + beanDefinitionName + ", Scope: " + beanDefinition.getScope());
//        }


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


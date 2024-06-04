package com.springboot.v5;

import com.springboot.v5.discount.DiscountPolicy;
import com.springboot.v5.helper.Printer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Kiosk {
    private MenuItem[] menuItemArray;
    private Printer printer;
    private DiscountPolicy discountPolicy;

    @Autowired
    public Kiosk(MenuItem[] menuItemArray, Printer printer, @Qualifier("fixedAmount") DiscountPolicy discountPolicy) {
        this.menuItemArray = menuItemArray;
        this.printer = printer;
        this.discountPolicy = discountPolicy;
    }

    public void setMenuItemArray(MenuItem[] menuItemArray) {
        this.menuItemArray = menuItemArray;
    }

    private Scanner sc = new Scanner(System.in);

    public void welcomePrintMessage() {
        printer.print("[안내]안녕하세요. 김밥천국에 오신 것을 환영합니다.\n");
        printer.print("------------------------------\n");
    }

    public MenuItem selectMenu() {
        int menuNumber;
        while (true) {
            printMenuSelectMessage(menuItemArray);
            menuNumber = inputMenuNumber();
            if (menuNumber <= menuItemArray.length && menuNumber >= 1) {
                return menuItemArray[menuNumber - 1];
            }
            printMenuSelectExceptionMessage();
        }
    }

    private void printMenuSelectExceptionMessage() {
        printer.print("[안내]메뉴에 포함된 번호를 입력하여 주세요.\n");
    }

    private void printMenuSelectMessage(MenuItem[] arr) {
        printer.print("[안내]원하시는 메뉴의 번호를 입력하여 주세요.\n");
        for (int i = 0; i < arr.length; i++) {
            printer.print(String.format("메뉴 %d) %s(%d원)\n", i + 1, arr[i].getName(), arr[i].getPrice()));
        }
        printer.print("------------------------------\n");
        printer.print("메뉴를 입력해 주세요: \n");
    }

    private int inputMenuNumber() {
        int menuNumber = Integer.parseInt(sc.nextLine());
        return menuNumber;
    }

    public int selectMenuCount() {
        int count = 0;
        do {
            printMenuCountMessage();
            count = inputMenuCountNumber();
            if (count < 1 || count > 99) {
                printMenuCountExceptionMessage(count);
            }
        } while (count < 1 || count > 99);
        return count;
    }

    private void printMenuCountMessage() {
        printer.print("------------------------------\n" +
                "[안내]선택하신 메뉴의 수량을 입력하여 주세요.\n" +
                "(※ 최대 주문 가능 수량 : 99)");
    }

    private int inputMenuCountNumber() {
        int count = Integer.parseInt(sc.nextLine());
        return count;
    }

    private void printMenuCountExceptionMessage(int count) {
        printer.print("[경고]" + count + "개는 입력하실 수 없습니다.\n" +
                "[경고]수량 선택 화면으로 돌아갑니다.");
    }

    public int calculateOrderPrice(MenuItem menu, int count) {
        int price = menu.getPrice();
        price = (int)discountPolicy.applyDiscount(price);
        if (price == -1) {
            return -1;
        }
        return count * price;
    }

    public void printOrderPriceMessage(int currentOrderPrice, MenuItem menu, int count) {
        printer.print("[안내]주문하신 상품은 " + menu.getName() + " 총 상품의 갯수는 : " + count + "개 입니다.");
        printer.print("[안내]주문하신 메뉴의 총 금액은 : " + currentOrderPrice + "원 입니다.\n" +
                "[안내]이용해 주셔서 감사합니다.");
    }
}

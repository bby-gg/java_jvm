package day07;

public class Alipay implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("支付宝支付：" + amount + " 元，手续费 0.6%");
    }
}
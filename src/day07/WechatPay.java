package day07;

public class WechatPay implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("微信支付：" + amount + " 元，优惠 10%");
    }
}
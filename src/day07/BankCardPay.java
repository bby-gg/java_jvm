package day07;

public class BankCardPay implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("银行卡支付：" + amount + " 元，需要密码验证");
    }
}
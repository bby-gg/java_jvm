package day07;

public class Main {

    public static void main(String[] args) {

        // ★★★ 核心：接口引用指向不同的实现类 ★★★

        Payment payment;  // 接口引用

        // 指向支付宝
        payment = new Alipay();
        payment.pay(100);  // 输出：支付宝支付：100.0 元，手续费 0.6%

        // 指向微信（同一个引用，不同行为）
        payment = new WechatPay();
        payment.pay(200);  // 输出：微信支付：200.0 元，优惠 10%

        // 指向银行卡（同一个引用，不同行为）
        payment = new BankCardPay();
        payment.pay(300);  // 输出：银行卡支付：300.0 元，需要密码验证
    }
}
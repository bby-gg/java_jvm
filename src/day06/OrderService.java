package day06;

public class OrderService {
    public void createOrder(String userInput) {
        // 直接用类名调用，不需要 new StringUtils()
        if (StringUtils.isEmpty(userInput)) {
            throw new IllegalArgumentException("输入不能为空");
        }
        // ... 业务逻辑
    }
}

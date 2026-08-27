package day06;

public class Demo01 {
    public static void staticMethod() {
        System.out.println("静态方法");
    }

    public void instanceMethod() {
        System.out.println("实例方法");
    }

    public static void main(String[] args) {
        // 静态方法：类一加载就能用
        Demo01.staticMethod();   // ✅ 不需要任何对象

        // 实例方法：必须先有对象
        // Demo.instanceMethod(); // ❌ 编译错误！
        Demo01 d = new Demo01();    // 先创建对象
        d.instanceMethod();      // ✅ 然后才能调用
    }
}

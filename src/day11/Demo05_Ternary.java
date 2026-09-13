package day11;

/**
 * 三目运算符的隐式拆箱陷阱
 * 当一个分支是基本类型时，另一个包装类分支会被强制拆箱
 */
public class Demo05_Ternary {

    public static void main(String[] args) {
        Integer a = null;
        Integer b = 1;

        // 下面这行会抛 NullPointerException
        // Integer c = true ? a : b;

        // 原因：b 是 Integer，但 a 参与时会被拆箱比较
        // 准确说：三目运算符的类型统一规则会把 Integer 提升为 int
        // 于是 a 被拆箱 → NPE

        // 规避：显式保证两个分支都是对象
        Integer safe = true ? a : (Integer) b;
        System.out.println("safe = " + safe); // null

        // 另一个观察：类型提升
        Integer x = 1;
        Integer y = 2;
        // 下面这个表达式结果类型是 int，不是 Integer
        int r = true ? x : y;
        System.out.println("r = " + r);
    }
}
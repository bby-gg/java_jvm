package day11;

/**
 * 装箱拆箱的本质：编译器的语法糖
 * 用 javap -c day11.Demo01_Boxing 可看到 valueOf / intValue 指令
 */
public class Demo01_Boxing {

    public static void main(String[] args) {
        // 自动装箱：底层 Integer.valueOf(10)
        Integer a = 10;

        // 自动拆箱：底层 a.intValue()
        int b = a;

        // 手动装箱（和自动等价）
        Integer c = Integer.valueOf(10);

        // 手动拆箱
        int d = c.intValue();

        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
        System.out.println("d = " + d);

        // 反编译后你会发现：a 和 c 的字节码完全一样
    }
}
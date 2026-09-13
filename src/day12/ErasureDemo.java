package day12;

import java.util.ArrayList;
import java.util.List;

public class ErasureDemo {
    public static void main(String[] args) {
        List<String> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();

        // true：擦除后是同一个 Class
        System.out.println(a.getClass() == b.getClass());

        // true：都是 java.util.ArrayList
        System.out.println(a.getClass().getName());
        System.out.println(b.getClass().getName());

        // 直接放进去，编译不过：
        // a.add(123);

        // 绕过编译器，运行时也不报错（因为擦除后 add 接收 Object）
        List raw = a;
        raw.add(123);
        System.out.println("raw list = " + a);   // [123]

        // 但取出来当 String 用就炸了
        try {
            String s = a.get(0);   // 编译器插入 checkcast String
            System.out.println(s);
        } catch (ClassCastException e) {
            System.out.println("ClassCastException: " + e.getMessage());
        }
    }
}
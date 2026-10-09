package day18;

import java.util.List;
import java.util.function.BiFunction;

public class Demo6 {
    public static void main(String[] args) {
        // 普通 lambda
        BiFunction<Integer, Integer, Integer> add1 = (a, b) -> a + b;
        System.out.println(add1.apply(1, 2));

        // 用 var 的 lambda（可加注解）
        BiFunction<Integer, Integer, Integer> add2 = (var a, var b) -> a + b;
        System.out.println(add2.apply(3, 4));

        // 用 var 才能加注解
        BiFunction<Integer, Integer, Integer> add3 =
                (@Deprecated var a, @Deprecated var b) -> a + b;
        System.out.println(add3.apply(5, 6));
    }
}

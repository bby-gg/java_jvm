package day15;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;

public class Demo1 {
    public static void main(String[] args) {

        // 1. 平方：完整写法
        Function<Integer, Integer> square1 = x -> {
            return x * x;
        };

        // 2. 平方：简写
        Function<Integer, Integer> square2 = x -> x * x;

        // TODO 3: 两个数的最大值，用 BinaryOperator，先完整再简写

        // TODO 4: 打印字符串，用 Consumer，先完整再简写

        System.out.println(square1.apply(5)); // 25
        System.out.println(square2.apply(5)); // 25
    }
}
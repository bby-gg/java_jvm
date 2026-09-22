package day16;

import java.util.*;
import java.util.stream.*;

public class Demo01_Create {
    public static void main(String[] args) {
        // 1. 集合（最常用）
        List<String> list = Arrays.asList("a", "b", "c");
        Stream<String> s1 = list.stream();

        // 2. 数组
        int[] arr = {1, 2, 3};
        IntStream s2 = Arrays.stream(arr);

        // 3. Stream.of
        Stream<String> s3 = Stream.of("x", "y", "z");

        // 4. 数值流（避免装箱）
        IntStream s4 = IntStream.rangeClosed(1, 5); // 1,2,3,4,5

        System.out.println(s1.collect(Collectors.toList()));
        System.out.println(s2.boxed().collect(Collectors.toList()));
        System.out.println(s3.collect(Collectors.toList()));
        System.out.println(s4.boxed().collect(Collectors.toList()));
    }
}
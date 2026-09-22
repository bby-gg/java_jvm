package day15;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Demo2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("java", "c", "python", "go", "javascript"));

        // 1. 按长度从小到大排序
        list.sort(Comparator.comparingInt(String::length));
        System.out.println(list);

        // 重置
        list = new ArrayList<>(List.of("java", "c", "python", "go", "javascript"));

        // 2. 按长度从大到小排序
        list.sort(Comparator.comparingInt(String::length).reversed());
        System.out.println(list);

        // 3. 用方法引用打印每个元素
        list.forEach(System.out::println);
    }
}
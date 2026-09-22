package day16;

import java.util.*;
import java.util.stream.*;

public class Demo02_Operate {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(5, 3, 8, 1, 3, 9, 2, 8);

        // 中间操作链 + 终端操作 collect
        List<Integer> result = nums.stream()
                .filter(n -> n > 2)                 // 过滤
                .distinct()                         // 去重
                .sorted(Comparator.reverseOrder())  // 排序（降序）
                .limit(4)                           // 取前4
                .collect(Collectors.toList());      // 终端：收集
        System.out.println("链式操作: " + result); // [9,8,5,3]

        // map：转换
        List<String> strs = nums.stream()
                .map(n -> "值" + n)
                .collect(Collectors.toList());
        System.out.println("map: " + strs);

        // flatMap：扁平化
        List<List<Integer>> nested = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4)
        );
        List<Integer> flat = nested.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        System.out.println("flatMap: " + flat); // [1,2,3,4]

        // 终端操作：forEach / count / anyMatch / findFirst / reduce
        nums.stream().forEach(n -> System.out.print(n + " "));
        System.out.println();

        System.out.println("count: " + nums.stream().count());
        System.out.println("anyMatch(>8): " + nums.stream().anyMatch(n -> n > 8));
        System.out.println("findFirst(>5): " + nums.stream().filter(n -> n > 5).findFirst().orElse(-1));

        int sum = nums.stream().reduce(0, Integer::sum);
        System.out.println("reduce求和: " + sum);
    }
}
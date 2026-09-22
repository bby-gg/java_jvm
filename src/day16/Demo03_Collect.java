package day16;

import java.util.*;
import java.util.stream.*;

public class Demo03_Collect {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("Tom", 20, "北京"),
                new User("Jerry", 25, "上海"),
                new User("Mike", 30, "北京"),
                new User("Tony", 25, "广州")
        );

        // 1. 转 List / Set
        List<String> names = users.stream().map(User::getName).collect(Collectors.toList());
        System.out.println("names: " + names);

        // 2. 转 Map（键冲突传合并函数）
        Map<String, Integer> nameAge = users.stream()
                .collect(Collectors.toMap(User::getName, User::getAge, (a, b) -> a));
        System.out.println("nameAge: " + nameAge);

        // 3. 分组 groupingBy
        Map<String, List<User>> byCity = users.stream()
                .collect(Collectors.groupingBy(User::getCity));
        System.out.println("按城市分组: " + byCity);

        // 4. 拼接 joining
        String joined = users.stream().map(User::getName)
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println("joining: " + joined);

        // 5. 统计
        IntSummaryStatistics stat = users.stream()
                .collect(Collectors.summarizingInt(User::getAge));
        System.out.println("年龄: sum=" + stat.getSum() + ", avg=" + stat.getAverage()
                + ", max=" + stat.getMax() + ", min=" + stat.getMin());

        // 6. 并行流（一行切换）
        long count = users.parallelStream().filter(u -> u.getAge() >= 25).count();
        System.out.println("并行流 count(>=25): " + count);
    }
}
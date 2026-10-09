package day18;

import java.util.*;

public class Demo2 {
    public static void main(String[] args) {
        // 传统写法：类型名又长又重复
        Map<String, List<Integer>> oldWay = new HashMap<>();

        // var 写法：清爽
        var map = new HashMap<String, List<Integer>>();

        map.put("a", List.of(1, 2, 3));
        map.put("b", List.of(4, 5));

        for (var entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // 注意：这个推断成 ArrayList<Object>，不是 ArrayList<String>
        var list = new ArrayList<>();
        list.add("hello");
        System.out.println(list);
    }
}
package day14;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        // 增
        map.put("语文", 90);
        map.put("数学", 95);
        map.put("英语", 88);

        // 改
        map.put("数学", 100);

        // 查
        System.out.println(map.get("数学"));              // 100
        System.out.println(map.getOrDefault("物理", 0));  // 0

        // 删
        map.remove("英语");

        // 遍历
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            System.out.println(e.getKey() + " = " + e.getValue());
        }
    }
}
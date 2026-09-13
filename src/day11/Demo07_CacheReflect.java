package day11;

import java.lang.reflect.Field;

/**
 * 用反射破坏 IntegerCache
 * 经典谜题：让 2 + 2 == 5
 * 仅作原理演示，实际项目禁止这么干
 */
public class Demo07_CacheReflect {

    public static void main(String[] args) throws Exception {
        Class<?> clazz = Integer.class.getDeclaredClasses()[0]; // IntegerCache
        Field cacheField = clazz.getDeclaredField("cache");
        cacheField.setAccessible(true);

        Integer[] cache = (Integer[]) cacheField.get(null);

        // cache[i + 128] 对应值 i
        // 我们想把"4"的位置改成"5"的引用
        int index4 = 4 + 128;
        int index5 = 5 + 128;
        cache[index4] = cache[index5];

        // 此时 Integer.valueOf(4) 返回的其实是值为 5 的对象
        Integer a = 2;
        Integer b = 2;
        Integer result = a + b; // 自动装箱时命中缓存槽位 4

        System.out.println("2 + 2 = " + result);              // 打印 5
        System.out.println("result.intValue() = " + result.intValue()); // 5

        // 注意：这是通过反射改缓存引用，非常规手段
        // 用 Integer.toString 验证缓存内容
        System.out.println("Integer.valueOf(4) == Integer.valueOf(5) : "
                + (Integer.valueOf(4) == Integer.valueOf(5))); // true，已被改
    }
}
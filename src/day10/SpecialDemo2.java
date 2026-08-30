package day10;

/**
 * String 和包装类的特殊行为
 * 不可变 + 传地址副本 + 操作创建新对象
 */
public class SpecialDemo2 {
    public static void main(String[] args) {
        // 1. String 的不可变性
        String str = "Hello";
        System.out.println("调用前: " + str);
        changeString(str);
        System.out.println("调用后: " + str);

        // 2. Integer 的不可变性
        Integer num = 100;
        System.out.println("\n调用前: " + num);
        changeInteger(num);
        System.out.println("调用后: " + num);

        // 3. 特殊：StringBuilder 是可变的！
        StringBuilder sb = new StringBuilder("Hello");
        System.out.println("\n调用前: " + sb);
        changeStringBuilder(sb);
        System.out.println("调用后: " + sb);

        // 4. 特殊：包装类的缓存池陷阱
        Integer a = 100;
        Integer b = 100;
        System.out.println("\na == b: " + (a == b));

        Integer c = 200;
        Integer d = 200;
        System.out.println("c == d: " + (c == d));
    }

    public static void changeString(String s) {
        s = s + " World";
        System.out.println("方法内: " + s);
    }

    public static void changeInteger(Integer i) {
        i = i + 100;
        System.out.println("方法内: " + i);
    }

    public static void changeStringBuilder(StringBuilder sb) {
        sb.append(" World");
        System.out.println("方法内: " + sb);
    }
}
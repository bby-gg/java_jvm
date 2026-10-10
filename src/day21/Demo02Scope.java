package day21;

public class Demo02Scope {
    public static void main(String[] args) {
        Object obj = "hello";

        if (!(obj instanceof String s)) {
            // System.out.println(s); // 编译错误：这里 s 不可用
            System.out.println("不是字符串");
        } else {
            System.out.println("长度：" + s.length()); // 这里可用
        }
    }
}
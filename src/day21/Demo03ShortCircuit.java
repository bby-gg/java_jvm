package day21;

public class Demo03ShortCircuit {
    public static void main(String[] args) {
        Object obj = "hello";

        // && 右侧安全
        if (obj instanceof String s && s.length() > 5) {
            System.out.println("长字符串：" + s);
        }

        // || 右侧会编译错误
        // if (obj instanceof String s || s.length() > 5) { }
    }
}
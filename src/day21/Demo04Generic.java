package day21;

import java.util.List;

public class Demo04Generic {
    public static void main(String[] args) {
        Object obj = List.of("a", "b");

        if (obj instanceof List<?> list) { // 只能写 ?
            System.out.println("大小：" + list.size());
        }
        // if (obj instanceof List<String> list) { } // 编译错误
    }
}
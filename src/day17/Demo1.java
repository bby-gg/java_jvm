package day17;

public class Demo1 {
    public static void main(String[] args) {
        String a = """
                Hello
                World
                """;   // 结束定界符单独一行 → 末尾有 \n

        String b = """
                Hello
                World""";  // 结束定界符紧跟内容 → 末尾无 \n

        System.out.println("[" + a + "]");
        System.out.println("[" + b + "]");
    }
}

package day17;

public class Demo3 {
    public static void main(String[] args) {
        String json = """
                {"name": "Tom", "age": 20}""";

        String sql = """
                SELECT id, name FROM users WHERE age > 18""";

        System.out.println(json);
        System.out.println(sql);
    }
}
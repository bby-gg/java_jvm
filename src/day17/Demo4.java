package day17;

public class Demo4 {
    public static void main(String[] args) {
        String name = "Tom";
        int age = 20;

        String json = """
                {
                    "name": "%s",
                    "age": %d
                }
                """.formatted(name, age);

        System.out.println(json);
    }
}

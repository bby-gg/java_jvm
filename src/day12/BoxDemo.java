package day12;

public class BoxDemo {
    public static void main(String[] args) {
        Box<String> box = new Box<>();
        box.set("hello");
        String s = box.get();
        System.out.println(s);
    }
}
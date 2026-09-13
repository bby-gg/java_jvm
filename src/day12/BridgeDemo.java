package day12;

public class BridgeDemo {
    public static void main(String[] args) {
        Node<Integer> node = new MyNode();

        // 编译能过：擦除后 setData 的参数是 Object
        // 运行时会走桥接方法，里面 checkcast Integer 失败，抛 ClassCastException
        node.setData((Integer) (Object) "hello");
    }
}
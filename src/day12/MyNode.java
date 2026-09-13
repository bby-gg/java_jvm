package day12;

public class MyNode extends Node<Integer> {
    @Override
    public void setData(Integer data) {
        System.out.println("MyNode.setData(Integer): " + data);
        super.setData(data);
    }

    @Override
    public Integer getData() {
        System.out.println("MyNode.getData()");
        return super.getData();
    }
}
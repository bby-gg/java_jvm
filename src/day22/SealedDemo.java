package day22;

/**
 * 演示：有 sealed 时，switch 可以穷尽，不需要 default。
 *
 * 关键：编译器知道"全部子类"，能检查你有没有漏。
 */
public class SealedDemo {

    // 计算面积：没有 default！
    static double area(Shape s) {
        if (s instanceof Circle c) {
            return Math.PI * c.radius() * c.radius();
        } else if (s instanceof Rectangle r) {
            return r.width() * r.height();
        } else if (s instanceof Square q) {
            return q.side() * q.side();
        }
        // 没有 else！编译器知道已经穷尽
        throw new IllegalStateException("不可能到这里");
    }

    public static void main(String[] args) {
        System.out.println("=== 有 sealed 的世界 ===\n");

        Shape c = new Circle(2);
        Shape r = new Rectangle(3, 4);
        Shape q = new Square(5);

        System.out.println("圆形面积 = " + String.format("%.2f", area(c)));
        System.out.println("矩形面积 = " + String.format("%.2f", area(r)));
        System.out.println("正方形面积 = " + String.format("%.2f", area(q)));

        System.out.println("\n关键：编译器知道 Shape 只有 Circle、Rectangle、Square");
        System.out.println("      所以这里的 else 是'不可能到达'的");
        System.out.println("      如果漏掉任何一个 instanceof，编译器会报错");
    }
}
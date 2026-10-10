package day22;

/**
 * 演示：没有 sealed 时，switch 被迫加 default。
 *
 * 关键：default 是"定时炸弹"——它静默吞掉新分支。
 */
public class NoSealedDemo {

    // 用传统抽象类，不用 sealed
    static abstract class OldShape { }
    static class OldCircle extends OldShape { double r; }
    static class OldRectangle extends OldShape { double w, h; }
    static class OldSquare extends OldShape { double side; }

    // 计算面积：被迫加 default
    static double area(OldShape s) {
        if (s instanceof OldCircle c) {
            return Math.PI * c.r * c.r;
        } else if (s instanceof OldRectangle r) {
            return r.w * r.h;
        } else if (s instanceof OldSquare q) {
            return q.side * q.side;
        } else {
            // 编译器不知道有没有别的子类，逼你兜底
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== 没有 sealed 的世界 ===\n");

        OldShape c = new OldCircle();
        ((OldCircle) c).r = 2;
        System.out.println("圆形面积 = " + String.format("%.2f", area(c)));

        OldShape r = new OldRectangle();
        ((OldRectangle) r).w = 3;
        ((OldRectangle) r).h = 4;
        System.out.println("矩形面积 = " + String.format("%.2f", area(r)));

        System.out.println("\n问题：如果以后有人加 OldTriangle，");
        System.out.println("area 会走 else 返回 0，运行时才发现 bug。");
    }
}
//package day22;
//
///**
// * 演示：新增 Triangle 后，没有 sealed 和 有 sealed 的差异。
// *
// * 运行前需要先手动做实验：
// *   实验 A：给 Shape 加 permits Triangle，并新建 Triangle 类
// *   实验 B：观察 NoSealedDemo 和 SealedDemo 的编译结果
// */
//public class AddTriangleDemo {
//
//    // 新增的子类
//    record Triangle(double base, double height) implements Shape { }
//
//    // ============================================================
//    // 实验 1：没有 sealed 时，编译器不提醒
//    // ============================================================
//    static double areaNoSealed(NoSealedDemo.OldShape s) {
//        if (s instanceof NoSealedDemo.OldCircle c) {
//            return Math.PI * c.r * c.r;
//        } else if (s instanceof NoSealedDemo.OldRectangle r) {
//            return r.w * r.h;
//        } else if (s instanceof NoSealedDemo.OldSquare q) {
//            return q.side * q.side;
//        } else {
//            // Triangle 会走这里，返回 0，运行时才发现
//            return 0;
//        }
//    }
//
//    // ============================================================
//    // 实验 2：有 sealed 时，编译器强制你处理 Triangle
//    // ============================================================
//    static double areaSealed(Shape s) {
//        if (s instanceof Circle c) {
//            return Math.PI * c.radius() * c.radius();
//        } else if (s instanceof Rectangle r) {
//            return r.width() * r.height();
//        } else if (s instanceof Square q) {
//            return q.side() * q.side();
//        } else if (s instanceof Triangle t) {   // ← 必须加这个！
//            return 0.5 * t.base() * t.height();
//        }
//        throw new IllegalStateException("不可能到这里");
//    }
//
//    public static void main(String[] args) {
//        System.out.println("=== 新增 Triangle 后的差异 ===\n");
//
//        System.out.println("--- 没有 sealed ---");
//        System.out.println("编译器不提醒，Triangle 走 else 返回 0");
//        System.out.println("运行时才会发现 bug\n");
//
//        System.out.println("--- 有 sealed ---");
//        System.out.println("编译器强制你加 case/instanceof Triangle");
//        System.out.println("不加就编译报错\n");
//
//        System.out.println("验证：有 sealed 的 areaSealed 正确处理了 Triangle");
//        Shape t = new Triangle(6, 4);
//        System.out.println("三角形面积 = " + areaSealed(t));
//    }
//}
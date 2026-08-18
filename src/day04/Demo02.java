package day04;

public class Demo02 {

    // 场景1：for循环 + 循环内定义变量（写法A）
    public void forLoopWithLocalVar() {
        for (int i = 0; i < 3; i++) {
            Object obj = new Object();
            System.out.println(obj);
        }
    }

    // 场景2：for循环 + 循环外定义变量（写法B）
    public void forLoopWithOuterVar() {
        Object obj;
        for (int i = 0; i < 3; i++) {
            obj = new Object();
            System.out.println(obj);
        }
    }

    // 场景3：while循环
    public void whileLoop() {
        int i = 0;
        while (i < 3) {
            Object obj = new Object();
            System.out.println(obj);
            i++;
        }
    }

    // 场景4：do-while循环
    public void doWhileLoop() {
        int i = 0;
        do {
            Object obj = new Object();
            System.out.println(obj);
            i++;
        } while (i < 3);
    }

    // 场景5：if-else判断
    public void ifElse(int score) {
        if (score >= 90) {
            System.out.println("优秀");
        } else if (score >= 60) {
            System.out.println("及格");
        } else {
            System.out.println("不及格");
        }
    }

    // 场景6：switch判断
    public void switchCase(int day) {
        switch (day) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                System.out.println("工作日");
                break;
            case 6:
            case 7:
                System.out.println("周末");
                break;
            default:
                System.out.println("非法日期");
        }
    }

    // 场景7：break跳出循环
    public void breakDemo() {
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                System.out.println("遇到5，跳出循环");
                break;
            }
            System.out.println(i);
        }
    }

    // 场景8：continue跳过本次循环
    public void continueDemo() {
        for (int i = 0; i < 5; i++) {
            if (i == 2) {
                System.out.println("遇到2，跳过本次");
                continue;
            }
            System.out.println(i);
        }
    }

    // 场景9：嵌套循环 + 带标签的break
    public void nestedLoop() {
        outer:
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    System.out.println("在(1,1)处跳出外层循环");
                    break outer;
                }
                System.out.println("i=" + i + ", j=" + j);
            }
        }
    }

    // 场景10：main方法 - 调用所有场景
    public static void main(String[] args) {
        Demo02 demo = new Demo02();

        System.out.println("=== 场景1: for循环内部定义变量 ===");
        demo.forLoopWithLocalVar();

        System.out.println("\n=== 场景2: for循环外部定义变量 ===");
        demo.forLoopWithOuterVar();

        System.out.println("\n=== 场景3: while循环 ===");
        demo.whileLoop();

        System.out.println("\n=== 场景4: do-while循环 ===");
        demo.doWhileLoop();

        System.out.println("\n=== 场景5: if-else判断 ===");
        demo.ifElse(85);
        demo.ifElse(50);

        System.out.println("\n=== 场景6: switch判断 ===");
        demo.switchCase(3);
        demo.switchCase(6);
        demo.switchCase(10);

        System.out.println("\n=== 场景7: break演示 ===");
        demo.breakDemo();

        System.out.println("\n=== 场景8: continue演示 ===");
        demo.continueDemo();

        System.out.println("\n=== 场景9: 嵌套循环+标签break ===");
        demo.nestedLoop();
    }
}
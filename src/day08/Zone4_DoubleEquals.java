package day08;

/**
 * 禁区4：使用 == 比较字符串内容
 * 后果：地址不同返回 false，产生隐蔽Bug
 * 正确做法：永远用 equals() 比较内容
 */
public class Zone4_DoubleEquals {

    public static void main(String[] args) {
        System.out.println("=== 字符串比较的陷阱 ===");
        System.out.println();

        // 准备测试数据
        String s1 = "hello";
        String s2 = "hello";
        String s3 = new String("hello");
        String s4 = "he" + "llo";  // 编译期常量折叠
        String s5 = "he";
        String s6 = s5 + "llo";    // 运行期拼接，创建新对象

        // ❌ 错误示例：使用 == 比较
        System.out.println("❌ 使用 == 比较（比较的是内存地址）:");
        System.out.println("s1 == s2 : " + (s1 == s2));   // true（常量池同一对象）
        System.out.println("s1 == s3 : " + (s1 == s3));   // false（一个在常量池，一个在堆）
        System.out.println("s1 == s4 : " + (s1 == s4));   // true（编译期常量折叠）
        System.out.println("s1 == s6 : " + (s1 == s6));   // false（运行期创建新对象）
        System.out.println();

        // ✅ 正确示例：使用 equals() 比较
        System.out.println("✅ 使用 equals() 比较（比较的是内容）:");
        System.out.println("s1.equals(s2) : " + s1.equals(s2));  // true
        System.out.println("s1.equals(s3) : " + s1.equals(s3));  // true
        System.out.println("s1.equals(s4) : " + s1.equals(s4));  // true
        System.out.println("s1.equals(s6) : " + s1.equals(s6));  // true
        System.out.println();

        // 特别注意：空指针安全
        System.out.println("=== 空指针安全提醒 ===");
        String nullStr = null;
        // ❌ 错误：nullStr.equals("hello") 会抛出 NullPointerException
        // ✅ 正确：使用常量或 Objects.equals()
        System.out.println("\"hello\".equals(nullStr) : " + "hello".equals(nullStr));  // false，安全
        // System.out.println(nullStr.equals("hello"));  // 这行会报NPE，已注释
        System.out.println("java.util.Objects.equals(nullStr, \"hello\") : " + java.util.Objects.equals(nullStr, "hello"));
    }
}
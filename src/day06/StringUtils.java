package day06;

// 这是一个真实的工具类，实际项目每天都在写
public class StringUtils {

    // 私有构造方法：防止别人 new 这个类
    private StringUtils() {}

    // 静态方法：判断字符串是否为空
    public static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    // 静态方法：判断字符串是否不为空
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }
}

// 在业务代码中使用

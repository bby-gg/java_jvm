package day01;

import java.lang.reflect.Modifier;

public class demo01 {

    public static void main(String[] args) {
        // 直接看每个关键字对应的数字
        System.out.println("PUBLIC      = " + Modifier.PUBLIC);
        System.out.println("PRIVATE     = " + Modifier.PRIVATE);
        System.out.println("PROTECTED   = " + Modifier.PROTECTED);
        System.out.println("STATIC      = " + Modifier.STATIC);
        System.out.println("FINAL       = " + Modifier.FINAL);
        System.out.println("SYNCHRONIZED= " + Modifier.SYNCHRONIZED);
        System.out.println("VOLATILE    = " + Modifier.VOLATILE);
        System.out.println("TRANSIENT   = " + Modifier.TRANSIENT);
        System.out.println("NATIVE      = " + Modifier.NATIVE);
        System.out.println("ABSTRACT    = " + Modifier.ABSTRACT);
        System.out.println("INTERFACE   = " + Modifier.INTERFACE);
        System.out.println("STRICT      = " + Modifier.STRICT);
    }
}
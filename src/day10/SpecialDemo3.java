package day10;

import java.util.*;

/**
 * 返回内部对象的陷阱
 * 破坏封装性，外部可以修改内部数据
 */
public class SpecialDemo3 {
    private String[] names = {"Alice", "Bob", "Charlie"};
    private List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C"));
    private Person person = new Person("系统用户");

    public static void main(String[] args) {
        SpecialDemo3 demo = new SpecialDemo3();

        // 危险1：返回数组
        System.out.println("=== 返回数组的危险 ===");
        String[] result = demo.getNames();
        System.out.println("修改前: " + Arrays.toString(demo.names));
        result[0] = "Hacker";
        System.out.println("修改后: " + Arrays.toString(demo.names));

        // 危险2：返回 List
        System.out.println("\n=== 返回 List 的危险 ===");
        List<String> listResult = demo.getList();
        System.out.println("修改前: " + demo.list);
        listResult.add("Hacker");
        System.out.println("修改后: " + demo.list);

        // 危险3：返回 Person 对象
        System.out.println("\n=== 返回对象的危险 ===");
        Person p = demo.getPerson();
        System.out.println("修改前: " + demo.person.name);
        p.name = "Hacker";
        System.out.println("修改后: " + demo.person.name);

        // ===== 安全做法 =====
        System.out.println("\n=== 安全做法 ===");
        String[] safe = demo.getNamesSafe();
        safe[0] = "Safe";
        System.out.println("修改副本后，原数组: " + Arrays.toString(demo.names));

        List<String> immutable = demo.getListSafe();
        // immutable.add("X");  // 运行时会抛异常！

        Person safePerson = demo.getPersonSafe();
        safePerson.name = "Safe";
        System.out.println("修改克隆后，原对象: " + demo.person.name);
    }

    // ❌ 危险
    public String[] getNames() {
        return names;
    }

    public List<String> getList() {
        return list;
    }

    public Person getPerson() {
        return person;
    }

    // ✅ 安全
    public String[] getNamesSafe() {
        return names.clone();
    }

    public List<String> getListSafe() {
        return Collections.unmodifiableList(list);
    }

    public Person getPersonSafe() {
        return new Person(person.name);
    }
}


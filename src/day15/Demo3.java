package day15;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Demo3 {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // TODO 1: 过滤出偶数
        Predicate<Integer> even = x -> x % 2 ==0;
        System.out.println(filter(nums, even));

        // TODO 2: 过滤出大于 5 的数
        Predicate<Integer> gt5 = x -> x % 5 == 0;
        System.out.println(filter(nums, gt5));

        // TODO 3: 过滤出偶数且大于 5
        // 提示：even.and(gt5)
        Predicate<Integer> end = x -> x % 2 == 0 && x > 5;
    }

    static List<Integer> filter(List<Integer> list, Predicate<Integer> p) {
        List<Integer> result = new ArrayList<>();
        for (Integer x : list) {
            // TODO: 判断并加入]
            if((p.test(x))){
                result.add(x);
            }
        }
        return result;
    }
}
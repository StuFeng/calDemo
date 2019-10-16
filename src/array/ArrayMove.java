package array;

import java.util.Arrays;
import java.util.function.Predicate;

/**
 * @author fengsihan
 * @date 2019/10/16 23:20
 * @desc 数组移动
 */
public class ArrayMove {

    /**
     * 将所有奇数移到偶数前面
     * 维护两个指针，一个指向开头，一个结尾，第一个指针走到偶数，走第二个指针，如果是奇数交换
     *
     * @param aa
     */
    static void reorderOddEven(int[] aa) {
        int begin = 0;
        int end = aa.length - 1;

        while (begin < end) {
            // 如果头指针是偶数数
            if ((aa[begin] & 1) == 0) {
                // 判断尾指针是否为奇数
                if ((aa[end] & 1) == 1) {
                    //如果是偶数交换值
                    int tmp = aa[begin];
                    aa[begin] = aa[end];
                    aa[end] = tmp;
                    begin++;
                    end--;
                } else {
                    //如果是奇数end继续移动
                    end--;
                }
            } else {
                begin++;
            }
        }


    }

    static void reorderOddEven1(int[] aa) {
        int begin = 0;
        int end = aa.length - 1;

        while (begin < end) {
            // 如果头指针是偶数数
            while ((begin < end) && (aa[begin] & 1) == 1) begin++;
            while ((begin < end) && (aa[end] & 1) == 0) end--;

            if ((begin < end)) {
                int tmp = aa[begin];
                aa[begin] = aa[end];
                aa[end] = tmp;
            }
        }
    }

    static void reorder(int[] aa, Predicate<Integer> condition) {
        int begin = 0;
        int end = aa.length - 1;

        while (begin < end) {
            // 如果头指针是偶数数
            while ((begin < end) && condition.test(aa[begin])) begin++;
            while ((begin < end) && !condition.test(aa[end])) end--;

            if ((begin < end)) {
                int tmp = aa[begin];
                aa[begin] = aa[end];
                aa[end] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] aa = {1, 2, 3, 4, 5, 6};
//        reorderOddEven1(aa);
        reorder(aa, (n) -> (n & 1) == 1);
        System.out.println(Arrays.toString(aa));
    }
}

package string;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author fengsihan
 * @date 2019/11/18 23:46
 * @desc 字符串排列组合
 */
public class Permutation {

    private static void printPermutation(int[] aa) {
        loop(aa, aa.length, new int[aa.length], new int[aa.length]);
    }

    /**
     * @param aa
     * @param length 长度
     * @param value  存放具体的结果值
     * @param index  存放下标
     */
    private static void loop(int[] aa, int length, int[] value, int[] index) {
        if (length == 0) {
            long count = Arrays.stream(index).distinct().count();
            if (count == value.length) {
                System.out.println(Arrays.toString(value));
            }

        } else {
            for (int i = 0; i < aa.length; i++) {
                value[value.length - length] = aa[i];
                index[value.length - length] = i;
                loop(aa, length - 1, value, index);
            }
        }

    }


    public static void main(String[] args) {
//        int[] aa = {1, 2, 2, 4};
//        printPermutation(aa);

        char[] str = new char[]{'a', 'b', 'c'};
//        permutation(str, 0);
        combination(str);
    }

    /**
     * 当前字符串位置
     */
//    public static int index = 0;

    /**
     * 交换位置
     *
     * @param str
     */
    public static void permutation(char[] str, int index) {

        if (index == (str.length - 1)) {
            System.out.println(Arrays.toString(str));
        } else {
            for (int i = index; i < str.length; i++) {
                char tmp = str[i];
                str[i] = str[index];
                str[index] = tmp;
                int tmpIdx = index + 1;
                permutation(str, tmpIdx);

                tmp = str[i];
                str[i] = str[index];
                str[index] = tmp;
            }
        }

    }

    public static void combination(char[] str) {
        ArrayList<Character> result = new ArrayList<>();
        for (int i = 1; i <= str.length; i++)
            // n个字符， m中情况
            combination1(str, 0, i, result);
    }

    /**
     * @param str
     * @param index 定义当前遍历的数组起始下标
     * @param m     当前字符组合个数
     */
    public static void combination1(char[] str, int index, int m, ArrayList<Character> result) {
        if (str == null || str.length == 0) {
            return;
        }
        if (m == 0) {
            System.out.println(result);
            return;
        }
        // 当前索引大于下标
        if (index > str.length - 1)
            return;
        // 当前的字符被选中 第一中情况 穷举完毕后，进行第二种情况
        result.add(str[index]);
        int tmp = index + 1;
        combination1(str, tmp, m - 1, result);
        // 当前字符未被选中，穷举
        result.remove(result.size() - 1);
        combination1(str, tmp, m, result);
    }


}

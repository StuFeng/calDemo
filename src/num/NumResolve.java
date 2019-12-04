package num;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fengsihan
 * @date 2019/12/4 23:53
 * @desc 数字处理
 */
public class NumResolve {

    /**
     * 从m个数子中去n个数字组合起来
     */
    public static void getResult(int[] m, int n) {
        List<Integer> list = new ArrayList<>();
        printf(m, 0, m.length - n + 1, n, list);
    }

    private static void printf(int[] m, int startIdx, int endIdx, int n, List<Integer> list) {
        if (list.size() == n) {
            System.out.println(list);
        } else {
            for (int i = startIdx; i < endIdx; i++) {
                list.add(m[i]);
                // 输出下面的值
                printf(m, startIdx + 1, endIdx + 1, n, list);
                // 删除当前值
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        getResult(new int[]{1, 2, 3, 4, 5}, 3);
    }

}

package num;

import java.util.HashMap;

/**
 * @author fengsihan
 * @date 2019/12/10 0:35
 * @desc 数组下标和为某值
 */
public class ArrayIndexSum {

    public static void findBathIndex(int[] arr, int k) {
        if (arr == null) {
            return;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        int i = 0;
        for (i = 0; i <= arr.length / 2; i++) {
            if (map.get(k - arr[i]) != null && map.get(k - arr[i]) != i) {
                System.out.println(i + " " + map.get(k - arr[i]));
            }
        }
        if (i == arr.length / 2 + 1) {
            System.out.println("不存在");
        }
    }

    public static void main(String[] args) {
        findBathIndex(new int[]{1,2,3,4,5,6}, 7);
    }
}

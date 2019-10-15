package array;

/**
 * @author fengsihan
 * @date 2019/9/22 20:54
 * @desc 输出数组中重复数字
 */
public class Duplice {

    /**
     * 使用临时数组存放 检查数组的值，然后
     *
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public static void duplicate(int numbers[], int length, int[] duplication) {
        int index = 0;
        int[] help = new int[length];
        for (int i = 0; i < length; i++) {
            if (help[numbers[i]] == 0) {
                help[numbers[i]]++;
            } else {
                duplication[index++] = numbers[i];
//                return true;
            }
        }

//        return false;
    }

    /**
     * 在二位数组中找到一个数组的步骤
     */
    public static void find(int[][] aa, int number) {
        if (aa == null || aa.length == 0){
            return;
        }
        int width = aa[0].length;
        int height = 0;

        for (int j = height; j < aa.length; j++) {
            int i = width - 1;
            if (aa[j][i] == number) {
                System.out.println("位置：第" + (j + 1) + "行" + "第" + (i + 1) + "列");
            } else if (aa[j][i] > number) {
                width--;
            } else {
                height++;
            }
        }
    }

    public static void main(String[] args) {
//        int[] duplication = new int[7];
//        duplicate(new int[]{1, 3, 5, 4, 2, 1, 3}, 7, duplication);
//        System.out.println(Arrays.toString(duplication));

        int[][] arr1 = {{1, 2, 8, 9}, {2, 3, 9, 12}, {4, 7, 10, 13}, {6, 8, 10, 15}};
        int[][] arr11 = {{1}};
        find(arr11, 16);
    }
}

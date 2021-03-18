package insert;

import java.util.Arrays;

/**
 * @author fengsihan
 * @date 2019/9/8 17:21
 * @desc 拆分的思想，将队列拆分成小的队列进行排序，然后再合并
 * 最坏 O(NlogN)
 */
public class MergeSort {

    public static void mergeSort(int[] aa) {
        int[] tmp = new int[aa.length];
        mergeSort(aa, tmp, 0, aa.length - 1);
    }

    /**
     * @param aa    目标数组
     * @param tmp   临时数据，存放merged结果
     * @param left  左边界
     * @param right 右边界
     */
    private static void mergeSort(int[] aa, int[] tmp, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(aa, tmp, left, center);
            mergeSort(aa, tmp, center + 1, right);

            merge(aa, tmp, left, center + 1, right);
        }
    }

    private static void merge(int[] aa, int[] tmp, int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos + 1; // 涉及到的所有元素

        // 循环比较两个队列中的值
        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (aa[leftPos] <= aa[rightPos]) {
                tmp[tmpPos++] = aa[leftPos++];
            } else {
                tmp[tmpPos++] = aa[rightPos++];
            }
        }

        while (leftPos <=leftEnd){
            tmp[tmpPos++] = aa[leftPos++];
        }

        while (rightPos <= rightEnd){
            tmp[tmpPos++] = aa[rightPos++];
        }

        /**
         * 将排好序的临时数组，按照排序的前后下标, 赋值给最终的数组
         *
         */
        for(int i=0;i<numElements;i++, rightEnd--){
            aa[rightEnd] = tmp[rightEnd];
        }
    }

    public static void main(String[] args) {
        long stime = System.currentTimeMillis();
        int[] sort = new int []{9,1,7,5,5,4,3,2,1,0};
        mergeSort(sort);
        System.out.println(Arrays.toString(sort));
        long etime = System.currentTimeMillis();
        System.out.println(etime - stime);

    }
}

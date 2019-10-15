package insert;

import java.util.Arrays;

/**
 * @author fengsihan
 * @date 2019/9/15 14:06
 * @desc 快速排序
 */
public class QuidkSort {

    public static void quickSort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }

    private static void quickSort(int[] a, int left, int right) {
        // 枢纽值
        if (left + 3 <= right) {
            int pivot = meidian3(a, left, right);
            System.out.println("枢纽值:" + pivot);

            System.out.println(Arrays.toString(a));

            // 开始位置，现在枢纽值存放在 right -1的位置
            int i = left, j = right - 1;

            for (; ; ) {
                // 循环移动两个指针i,j 当i>=枢纽值时，和j<=枢纽的值交换；如果没有能交换的值，退出循环

                while (a[++i] < pivot) {
                }
                while (a[--j] > pivot) {
                }
                // 如果发现i j 已经出现交叉的情况， 即 j>=i 则退出循环
                if (i < j)
                    swapReferences(a, i, j);
                else
                    break;
            }

            // 将i最后指向的值与枢纽值交换
            swapReferences(a, i, right - 1);
            System.out.println(Arrays.toString(a));

            quickSort(a, left, i - 1);  // sort small elements

            quickSort(a, i + 1, right); // sort large elements
        } else {
            System.out.println("插入排序" + Arrays.toString(a));
            insertionSort(a, left, right);
        }

    }

    /**
     * 取数组中三个数的中值为最终的枢纽值
     *
     * @param a
     * @param left
     * @param right
     * @return
     */
    private static int meidian3(int[] a, int left, int right) {
        int center = (left + right) / 2;

        if (a[center] < a[left]) {
            // 将center换成更大的值，left换成小值
            swapReferences(a, center, left);
        }

        if (a[right] < a[left]) {
            swapReferences(a, right, left);
        }
        if (a[right] < a[center]) {
            swapReferences(a, right, center);
        }

        // 交换过后，三者的值为从小到大排序

        // 然后将中间值与倒数第二个值交换
        swapReferences(a, center, right - 1);
        return a[right - 1];
    }

    /**
     * 交换引用
     *
     * @param a
     * @param swapper   交换者
     * @param exchanger 被交换者
     */
    private static void swapReferences(int[] a, int swapper, int exchanger) {
        int tmp = a[swapper];
        a[swapper] = a[exchanger];
        a[exchanger] = tmp;
    }


    public static void main(String[] args) {
        int a[] = new int[]{10, 4, 5, 3, 6, 8, 11, 9, 7, 1};

        quickSort(a);

        System.out.println(Arrays.toString(a));


    }

    public static void insertionSort(int[] a, int left, int right) {
        int j;

        for (int p = left + 1; p < right + 1; p++) {
            int tmp = a[p];
            for (j = p; j > 0 && tmp < a[j - 1]; j--) {
                a[j] = a[j - 1];
            }
            a[j] = tmp;
        }
    }

}

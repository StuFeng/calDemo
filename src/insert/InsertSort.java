package insert;

import java.util.Arrays;

/**
 * @author fengsihan
 * @date 2019/9/7 16:40
 * @desc 插入排序
 */
public class InsertSort {

    public static void insertionSort(int[] a){
        int j;

        for (int p =1;p<a.length;p++){
            // 插入的值，从数组的第二位开始
            int tmp = a[p];
            // 每个元素都与tmp元素比较 小于才进行交换

            //找到 tmp元素在 p 往前的位置
            for (j=p; j>0 && tmp < a[j-1];j--){
                // 交换比tmp大的元素到后面位置
                a[j] = a[j-1];
            }
            a[j] = tmp;
        }
    }


    public static void main(String[] args) {
        int[] sort = new int []{4,3,2,1};
        insertionSort(sort);
        System.out.println(Arrays.toString(sort));


    }
}

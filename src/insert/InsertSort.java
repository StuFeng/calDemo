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
            int tmp = a[p];
            for (j=p; j>0 && tmp < a[j-1];j--){
                a[j] = a[j-1];
            }
            a[j] = tmp;
        }
    }


    public static void main(String[] args) {
        long stime = System.currentTimeMillis();
        int[] sort = new int []{4,3,2,1};
        insertionSort(sort);
        System.out.println(Arrays.toString(sort));
        long etime = System.currentTimeMillis();
        System.out.println(etime - stime);

    }
}

package insert;

import java.util.Arrays;

/**
 * @author fengsihan
 * @date 2019/9/7 22:25
 * @desc 希尔排序，使用一组队列定点的队列 gap=1时为p
 * 按照一定的序列，一般使用希尔建议的序列 N/2
 * 先将大概几个点排好顺序，
 * 然后将所有点排好顺序，减少交换的次数
 * 最好的序列 {1,5,19,41,109,...}
 * 9*（4的i次方) -9*(2的i次方) +1的形式
 * （4的i次方) -3*(2的i次方)+1的形式
 */
public class Shellsort {

    public static void shellsort(int[] a) {
        int j;
        // 假设a的长度为12   6 3 1
        for (int gap = a.length /2 ; gap > 0; gap /=2) {

            // 从gap开始到length结束 分段进行处理
            for(int i =gap; i< a.length; i++){
                int tmp = a[i];
                for (j = i; j>= gap && tmp < a[j-gap]; j -=gap)
                    a[j] = a[j -gap];
                a[j] = tmp;
            }


        }



    }

    public static void main(String[] args) {
        long stime = System.currentTimeMillis();
        int[] sort = new int []{9,8,7,6,5,4,3,2,1};
        shellsort(sort);
        System.out.println(Arrays.toString(sort));
        long etime = System.currentTimeMillis();
        System.out.println(etime - stime);

    }
}

package array;

import java.util.Arrays;

/**
 * @description:
 * @author: fengsihan
 * @time: 2021-04-21 20:28
 */
public class ArraySort {

  public static void main(String[] args) {
    int[] aa = new int[]{0,1,1,2,2,1,0};
    sort(aa);

    System.out.println(Arrays.toString(aa));
  }

  public static void sort(int aa[]){
    int startIdx = 0;
    int endIdx = aa.length -1;
    for (int i=startIdx;i<endIdx;i++){
       if (aa[i] == 2){
        int tmp = aa[i];
        aa[i] = aa[endIdx];
        aa[endIdx--] = tmp;
      }
       if (aa[i] == 0){
        int tmp = aa[i];
        aa[i] = aa[startIdx];
        aa[startIdx++] = tmp;
      }
    }
  }
}

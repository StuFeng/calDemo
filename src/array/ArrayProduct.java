package array;

import java.util.Arrays;

/**
 * @description: 计算数组除一个数字外的其他乘积
 * @author: fengsihan
 * @time: 2021-04-08 19:25
 */
public class ArrayProduct {

  public static void main(String[] args) {
    int[] aa =new int[]{1,2,3,4};
    int[] ints = ArrayExceptSelf2N(aa);
    System.out.println(Arrays.toString(ints));

  }

  public static int[] ArrayExceptSelf2N(int[] input)
  {
    if (input == null)
    {
      return null;
    }

    int length = input.length;
    int[] left = new int[length];
    int[] right = new int[length];
    int[] output = new int[length];
    left[0] = 1;
    right[length - 1] = 1;
    //先算出左边的
    for (int i = 1; i < length; i++)
    {
      left[i] = left[i - 1] * input[i - 1];
    }

    //倒数第二个开始，最后一个是length - 1,
    for (int i = length - 2; i >= 0; i--)
    {
      right[i] = right[i + 1] * input[i + 1];
    }

    for (int i = 0; i < length; i++)
    {
      output[i] = left[i] * right[i];
    }
    return output;
  }
}

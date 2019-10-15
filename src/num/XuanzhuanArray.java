package num;

/**
 * @author fengsihan
 * @date 2019/10/6 21:26
 * @desc
 */
public class XuanzhuanArray {

    // 利用二分法求旋转排序数组的最小值
    static  int min(int[] nums) {
        int index1 = 0;
        int index2 = nums.length - 1;
        int indexMid = index1;

        while (nums[index1] >= nums[index2]) {
            if (index2 - index1 == 1) {
                indexMid = index2;
                break;
            }

            indexMid = (index1 + index2) / 2;

            if (nums[index1] == nums[index2] && nums[index2] == nums[indexMid]) {
                int result = nums[index1];

                for (int i = index1 + 1; i < index2; i++) {
                    if (result > nums[i]) {
                        result = nums[i];
                    }
                }

                return result;
            }


            if (nums[indexMid] >= nums[index1]) {
                index1 = indexMid;
            } else if (nums[indexMid] <= nums[index2])
                index2 = indexMid;
        }

        return nums[indexMid];
    }


    public static void main(String[] args) {
        System.out.println(min(new int[]{1,0,1,1,1}));
        System.out.println(min(new int[]{3,4,5,1,2}));
    }
}

package num;

/**
 * @author fengsihan
 * @date 2019/10/7 15:50
 * @desc 把绳子剪成m段，可能的最大乘积
 */
public class MaxProductAfterCutting {

    static int solution1(int length) {
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }

        // 用于表示子问题的最优解
        int[] products = new int[length + 1];

        // 基础值，因数值用于计算
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;

        int max = 0;
        for (int i = 4; i <= length; i++) {
            // 计算每个长度的最优解时，将max设置为0
            max = 0;
            for (int j = 1; j <= i / 2; j++) {
                int product = products[j] * products[i - j];
                if (max < product) {
                    max = product;
                }
            }
            products[i] = max;

        }

        max = products[length];

        return max;
    }

    static int solution2(int length) {
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }

        int timesOf3 = length / 3;

        if ((length - timesOf3 * 3) == 1) {
            timesOf3 -= 1;
        }

        int timeOf2 = (length - timesOf3 * 3) >> 1;
        double result = Math.pow(3, timesOf3) * Math.pow(2, timeOf2);
        return (int)result;
    }

    public static void main(String[] args) {
        System.out.println(solution1(16));
        System.out.println(solution2(16));
    }
}

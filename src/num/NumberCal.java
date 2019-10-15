package num;

/**
 * @author fengsihan
 * @date 2019/10/7 16:53
 * @desc 位运算
 */
public class NumberCal {

    /**
     * 二进制中1的个数
     *
     * @param n
     * @return
     */
    static int numberOf1(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) == 1) count++;
            n = n >> 1; // 等价于 n = n/2;
        }
        return count;
    }

    static int numberOf2(int n) {
        int count = 0;
        int flag = 1;
        while (flag > 0) {
            if ((n & flag) > 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }

    static int numberOf3(int n) {
        int count = 0;
        while (n > 0) {
            count++;
            n = (n - 1) & n;
        }
        return count;
    }


    static double power(double base, int exponent) {
        if (Math.abs(base - 0.0) <= 0.001 && exponent < 0) {
            return 0.0;
        }
        int absExponent = Math.abs(exponent);

        double result = powerWithExponent1(base, absExponent);

        if (exponent < 0) {
            return 1.0 / result;
        }

        return result;
    }

    private static double powerWithExponent(double base, int absExponent) {
        double result = 1.0;
        for (int i = 0; i < absExponent; i++) {
            result *= base;
        }
        return result;
    }

    private static double powerWithExponent1(double base, int absExponent) {
        if (absExponent == 0) {
            return 1;
        }
        if (absExponent == 1) {
            return base;
        }
        double result = powerWithExponent1(base, absExponent >> 1);
        result = result * result;
        // 奇数偶数的判断,就是判定最后一位是0或者1
        if ((absExponent & 1) == 1) {
            result = result * base;
        }
        return result;
    }




    public static void main(String[] args) {
        System.out.println(-2 & 4);
//        System.out.println(numberOf1(10));
        System.out.println(numberOf3(-10));
//        System.out.println(numberOf1(100));
//        System.out.println(numberOf2(-10));
        System.out.println(0x1);
        System.out.println(power(2,     3));
        System.out.println(power(2,     -3));
        System.out.println(power(0,     3));
        System.out.println(power(0,     -3));
    }

}

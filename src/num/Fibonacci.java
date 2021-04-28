package num;

/**
 * @author fengsihan
 * @date 2019/10/6 16:12
 * @desc 斐波那契数列
 */
public class Fibonacci {

    public long fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
//        return fibonacci(n-1) + fibonacci(n -2);

        long fibNMinusOne = 1;
        long fibNMinusTwo = 0;

        long fibN = 0;

        for (int i = 2; i <= n; i++) {
            fibN = fibNMinusOne + fibNMinusTwo;
            fibNMinusTwo = fibNMinusOne;
            fibNMinusOne = fibN;
        }
        return fibN;
    }

    public int palouti(int n){
        if (n ==0){
            return 0;
        }
        if (n <= 2){
            return 2;
        }

        int[] res = new int[n];

        res[0] = 1;
        res[1] = 2;
        for (int i=0;i<n-2;i++){
            res[i+2] = res[i] + res[i+1];
        }

        return res[n-1];
    }
}

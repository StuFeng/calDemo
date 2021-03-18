package string;

/**
 * @author fengsihan
 * @date 2019/12/11 0:45
 * @desc
 */
public class MaxSubStr {

    /**
     * 最大公共字串
     *
     * @param str1
     * @param str2
     * @return
     */
    public static StringBuilder maxUtil2(String str1, String str2) {
        //把字符串转成字符数组
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        // 把两个字符串分别以行和列组成一个二维矩阵
        int[][] temp = new int[arr1.length][arr2.length];
        // 存储最长公共子串长度
        int length = 0;
        //start表明最长公共子串的起始点，end表明最长公共子串的终止点
        int end = 0;
        int start = 0;
        ////初始化二维矩阵中的第一行
        for (int i = 0; i < arr2.length; i++) {
            temp[0][i] = (arr1[0] == arr2[i]) ? 1 : 0;
        }
        //初始化二维矩阵中的第一列
        for (int j = 0; j < arr1.length; j++) {
            temp[j][0] = (arr2[0] == arr1[j]) ? 1 : 0;
        }
        //嵌套for循环：比较二维矩阵中每个点对应行列字符中否相等，相等的话值设置为1，否则设置为0
        for (int i = 1; i < arr1.length; i++) {
            for (int j = 1; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    temp[i][j] = temp[i - 1][j - 1] + 1;

                    if (temp[i][j] > length) {
                        length = temp[i][j];
                        end = j;
                    }
                } else
                    temp[i][j] = 0;

            }

        }
        //求出最长公共子串的起始点
        start = end - length + 1;
        StringBuilder sb = new StringBuilder();
        //通过查找出值为1的最长对角线就能找到最长公共子串
        for (int j = start; j < end + 1; j++) {
            sb.append(arr2[j]);
        }

        return sb;
    }

    /**
     * 最长不含重复字符的子字符串
     */
    public static Integer maxSubStrWithoutDup(String str1) {

        int curLen = 0;
        int maxLen = 0;

        int[] array = new int[26];

        for (int i = 0; i < 26; i++) {
            //
            array[i] = -1;
        }

        for (int i = 0; i < str1.length(); i++) {
            // 定位之前是否存在当前字符
            int preIdx = array[str1.charAt(i) - 'a'];

            if (// 没有定位到
                preIdx < 0
                // 如果定位到了之前的值，判断长度是否比当前长度大，
                // 如果大于说明之前的值对当前长度没有影响
                || i - preIdx > curLen) {
                ++curLen;
            }else{
                if (curLen > maxLen){
                    maxLen = curLen;
                }
                // 重新计算当前长度，为当前字母到上个字母的长度
                curLen = i - preIdx;
            }
            // 存储当前字母的索引
            array[str1.charAt(i) - 'a'] = i;
        }

        if (curLen > maxLen){
            maxLen= curLen;
        }
        return maxLen;


    }

    public static void main(String[] args) {
        Integer len = maxSubStrWithoutDup("arabcacfr");
        System.out.println(len);

        System.out.println(maxUtil2("abcdea", "deacb"));;
    }
}

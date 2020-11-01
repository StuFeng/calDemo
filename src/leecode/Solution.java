package leecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author fengsihan
 * @description
 * @create 2020-10-23 11:21
 **/
public class Solution {

    public static void main(String[] args) {
//        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
        ;
        ListNode listNode = new ListNode("a");
        ListNode listNode1 = new ListNode("b");
        ListNode listNode2 = new ListNode("c");
        ListNode listNode3 = new ListNode("b");
        ListNode listNode4 = new ListNode("a");
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        System.out.println(listNode);
//        System.out.println(reverse(listNode));


        System.out.println(isPalindrome(listNode));;
    }

    /**
     * 划分字母区间
     *
     * @param S
     * @return
     */
    static List<Integer> partitionLabels(String S) {
        int a[] = new int[26];//记录每个小写字母最后出现的位置
        int len = S.length();
        List<Integer> res = new ArrayList();
        int start = 0;//片段的起始位置
        int end = 0;//片段的结束位置

        for (int i = 0; i < len; i++) {
            // S.charAt(i) - 'a' 小写字母在数组中最后的位置 a0:'a' a1:'b'
            a[S.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < len; i++) {
            // 循环取一段字母中最大的位置
            end = Math.max(end, a[S.charAt(i) - 'a']);
            // 这一段中最大的字母位置就是当前位置，则拆分这段。
            if (end == i) {//说明后面的片段没有出现重复的字母了
                res.add(end - start + 1);
                start = end + 1;//新的起始位置是结束位置 + 1
            }
        }

        return res;
    }


    static class ListNode {
        public ListNode next;
        public String value;

        public ListNode(String value) {
            this.value = value;
        }


        @Override
        public String toString() {
            return "ListNode{" +
                    "next=" + next +
                    ", value='" + value + '\'' +
                    '}';
        }
    }

    /**
     * 回文链表
     *
     * @param head
     * @return
     */
    static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode fastNode = head;
        ListNode slowNode = head;

        while (fastNode.next != null && fastNode.next.next != null) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }

        // 反转链表
//        ListNode reverse = reverse(slowNode.next);
//
//        while (reverse != null){
//            if (!reverse.value.equals(head.value)){
//                return false;
//            }
//            head = head.next;
//            reverse = reverse.next;
//        }
        return true;
    }


    static ListNode1 reverse(ListNode1 head) {
        ListNode1 tmp = head;

        ListNode1 lastNode = null;

        while (tmp != null) {
            ListNode1 next = tmp.next;
            tmp.next = lastNode;
            if (next == null) {
                return tmp;
            }
            lastNode = tmp;
            tmp = next;
        }
        return null;
    }


     public class ListNode1 {
         int val;
         ListNode1 next;

         ListNode1() {
         }

         ListNode1(int val) {
             this.val = val;
         }

         ListNode1(int val, ListNode1 next) {
             this.val = val;
             this.next = next;
         }
     }


        public ListNode1 addTwoNumbers(ListNode1 l1, ListNode1 l2) {
            l1 = reverse(l1);
            l2 = reverse(l2);

            int tmp =0;

            while(l1 != null && l2 != null){
                int val = l1.val + l2.val + tmp;
                if (val >= 10){
                    tmp =1;
                }else{
                    tmp =0;
                }
                l1.val = val % 10;
                l1 = l1.next;
                l2 = l2.next;
            }

            // while(l1 != null){
            //    l1.val = l1.val + tmp;
            //    tmp = 0;
            // }

            //  while(l2 != null){

            //    l3.val = l2.val + tmp;
            //    l2 = l2.next;
            //     tmp = 0;
            // }
            return l1;
        }

    /**
     *  找出一段字符串中的无重复最长子串
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha)+1, start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end);
        }
        return ans;

    }
}

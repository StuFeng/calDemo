package stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author fengsihan
 * @date 2019/11/9 14:49
 * @desc 判断栈是不是弹出序列
 */
public class IsPopOrder {

    static boolean isPopOrder(int[] push, int[] pop) {

        // 用于模拟入栈出栈动作
        Deque<Integer> stack = new ArrayDeque<>();


        int length = push.length;
        int index = 0;
        int popIndex = 0;
        while (index < length) {
            // 先压入栈中
            stack.push(push[index]);
            // 判断该值是否与弹出队列中的值相同
            while (stack.peek()!= null && (stack.peek() == pop[popIndex])) {
                stack.pop();
                popIndex++;
            }
            index++;
        }

        // 如果所有数据都压栈完毕，则判断弹出队列是否与指定队列相同
        if (stack.peek() != null){
            return false;
//            if (stack.pop() != pop[popIndex++]){
//                return false;
//            }
        }
        return true;
    }

    public static void main(String[] args) {
        // 压栈队列
         int[] push = new int[]{1, 2, 3, 4, 5};
        // 弹出队列
         int[] pop = new int[]{4, 3, 5, 1, 2};
        System.out.println(isPopOrder(push, pop));
    }
}

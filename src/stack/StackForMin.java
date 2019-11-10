package stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author fengsihan
 * @date 2019/11/7 0:28
 * @desc 使用栈实现O(1)时间取出最小值
 */
public class StackForMin {

    private final Deque dataStack = new ArrayDeque();
    /**
     * 存放辅助的数据
     */
    private final Deque minStack = new ArrayDeque();


    void push(int value) {
        dataStack.push(value);
        if (minStack.size() == 0 || (int) minStack.pop() > value) {
            minStack.push(value);
        } else {
            minStack.push(minStack.peek());
        }
    }

    int pop() {
        // 判断size
        minStack.pop();
        return (int) dataStack.pop();
    }

    /**
     * 当前栈的最小值
     *
     * @return
     */
    int min() {
        return (int) minStack.peek();
    }

}

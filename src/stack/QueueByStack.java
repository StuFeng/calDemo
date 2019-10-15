package stack;

import tree.BinaryTreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author fengsihan
 * @date 2019/10/5 18:58
 * @desc 使用两个栈实现队列
 */
public class QueueByStack<T> {
//    private final Deque<T> stack1 = new ArrayDeque<>();
//    private final Deque<T> stack2 = new ArrayDeque<>();
    private final StackByArray<T> stack1 = new StackByArray<>(10);
    private final StackByArray<T> stack2 = new StackByArray<>(10);

    // 尾部插入
    public void appendTail(T data) {
        stack1.push(data);
    }

    // 头部删除
    public T deleteHead() {
        if (stack2.size() <= 0) {
            while (stack1.size() > 0) {
                T pop = stack1.peek();
                stack1.pop();
                stack2.push(pop);
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        QueueByStack<String> queue = new QueueByStack<>();
        queue.appendTail("aa");
        queue.appendTail("bb");
        queue.appendTail("cc");
        queue.appendTail("dd");
        System.out.println(queue.deleteHead());
        queue.appendTail("ee");
        System.out.println(queue.deleteHead());
    }
}

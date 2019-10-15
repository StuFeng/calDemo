package stack;

import tree.BinaryTreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author fengsihan
 * @date 2019/10/5 20:30
 * @desc
 */
public class StackByQueue<T> {
    Queue<T> queue1 = new ArrayDeque<>();
    Queue<T> queue2 = new ArrayDeque<>();

    public void push(T data){
        queue1.add(data);
    }

    public T pop(){
        if (queue1.size() >0){
            while (queue1.size() > 1){
                T poll = queue1.poll();
                queue2.add(poll);
            }
            return queue1.poll();
        }
        if (queue2.size() > 0){
            while (queue2.size() > 1){
                T poll = queue2.poll();
                queue1.add(poll);
            }
            return queue2.poll();
        }
        return null;
    }


    public static void main(String[] args) {
        StackByQueue<String> stackByQueue = new StackByQueue<>();
        stackByQueue.push("aa");
        stackByQueue.push("bb");
        stackByQueue.push("cc");
        stackByQueue.push("dd");
        System.out.println(stackByQueue.pop());
        stackByQueue.push("ee");
        System.out.println(stackByQueue.pop());
    }
}

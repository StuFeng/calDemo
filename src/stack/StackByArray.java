package stack;

/**
 * @author fengsihan
 * @date 2019/10/5 17:01
 * @desc 使用数组实现栈，后进先出
 */
public class StackByArray<T> {

    private Object[] elements;
    // 长度
    private int size = 0;

    public StackByArray(int size) {
        elements = new Object[size];
    }

    public T push(T item) {
        elements[size++] = item;
        return item;

    }


    public T pop() {
        T e = peek();                    //取得栈顶数据
        if (size > 0) {                    //检查栈中是否有数据
            elements[size - 1] = null;            //将出栈后的位置置为空
            size--;
        }
        //将栈中元素个数减一
        return e;
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return (T) elements[size - 1];
    }

    //判断栈是否为空
    public boolean isEmpty() {
        return size == 0;
    }


    public int size() {
        return size;
    }

    public static void main(String[] args) {
        StackByArray<String> stack = new StackByArray<>(10);
        stack.push("aa");
        stack.push("bb");
        stack.push("cc");
        stack.push("dd");

        System.out.println(stack.peek());
        System.out.println(stack.toString());
        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        int aa = (2 + 1) & (4);
        System.out.println(aa);
    }
}

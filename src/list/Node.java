package list;

/**
 * @author fengsihan
 * @date 2019/10/20 19:16
 * @desc
 */
public class Node<T> {
    private Node next;
    private T value;

    public Node(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

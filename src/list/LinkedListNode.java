package list;

/**
 * @author fengsihan
 * @date 2019/9/28 17:17
 * @desc 链表增删改查
 */
public class LinkedListNode<T> {

    /**
     * 头节点
     */
    private Node<T> head = new Node<>(null);
    int size;

    /**
     * 添加元素
     *
     * @param value
     */
    void add(T value) {
        Node tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = new Node(value);
        size++;
    }

    /**
     * 指定链表位置添加元素
     *
     * @param i 从0开始
     */
    void add(int i, T value) {
        if (i < 0 || i > size) {
            throw new ArrayIndexOutOfBoundsException("插入的位置不合法");
        } else {
            // 加上头节点，相当于指针从-1开始遍历，通过遍历当前指定的值，可以遍历完当前链表 悖论
            int index = 0;
            Node tmp = head;
            while (tmp != null) {
                if (index == i) {
                    Node node = new Node(value);
                    Node preNode = tmp;
                    Node nextNode = tmp.next;
                    preNode.next = node;
                    node.next = nextNode;
                    size++;
                    break;
                }
                tmp = tmp.next;
                index++;
            }
        }
    }

    T get(int i) {
        if (i < 0 || i > size) {
            throw new ArrayIndexOutOfBoundsException("插入的位置不合法");
        } else {
            int index = 0;
            Node tmp = head;
            while (tmp.next != null) {
                if (index == i) {
                    return (T) tmp.next.getValue();
                }
                tmp = tmp.next;
                index++;
            }
        }
        return null;
    }

    void delete(int i) {
        if (i < 0 || i > size) {
            throw new ArrayIndexOutOfBoundsException("删除的位置不合法");
        } else {
            int index = 0;
            Node tmp = head;
            while (tmp.next != null) {
                if (index == i) {
                    tmp.next = tmp.next.next;
                    size--;
                    break;
                }
                tmp = tmp.next;
                index++;
            }
        }
    }

    /**
     * 从末尾到头打印链表，将遍历后的值装在栈的数据结构中，输出
     * 使用递归的方法，在输出前一个值后再输出当前值
     */
    void printList() {
        Node tmp = head;
        printValue(tmp);
    }

    private void printValue(Node tmp) {
        if (tmp.next != null) {
            printValue(tmp.next);
            System.out.println(tmp.next.getValue());
        }
    }

    /**
     * 反向删除
     *
     * @param k
     */
    T reverseGet(int k) {
        if (k < 0 || k > size) {
            throw new ArrayIndexOutOfBoundsException("删除的位置不合法");
        } else {
            int index = 0;
            Node tmp = head;
            Node tmp1 = head.next;
            while (tmp.next != null) {
                if (index >= k) {
                    tmp1 = tmp1.next;
                }
                tmp = tmp.next;
                index++;
            }
            return (T) tmp1.getValue();
        }
    }


    @Override
    public String toString() {
        Node tmp = head;
        StringBuilder stringBuilder = new StringBuilder();
        while (tmp.next != null) {
            stringBuilder.append(tmp.next.getValue()).append(" ");
            tmp = tmp.next;
        }
        return stringBuilder.toString();
    }

    private class Node<T> {
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
    }

    /**
     * 删除重复节点
     */
    public void deleteDuplicaiton() {
        if (head.next == null) {
            return;
        }
        // 第一个节点为head
        Node preNode = head;
        Node pNode = head.next;
        while (pNode != null) {
            Node pNext = pNode.next;
            boolean needDel = false;
            if (pNext != null && pNext.getValue() == pNode.getValue()) {
                needDel = true;
            }

            if (!needDel) {
                preNode = pNode;
                pNode = pNext;
            } else {
                Object value = pNode.getValue();
                Node pToBeDel = pNode;
                // 检查后面是否存在重复的节点
                while (pToBeDel != null && pToBeDel.getValue() == value) {
                    pNext = pToBeDel.next;
                    pToBeDel = null;
                    pToBeDel = pNext;
                }
                preNode.next = pNext;
                pNode = pNext;
            }
        }
    }
}

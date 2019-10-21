package list;

/**
 * @author fengsihan
 * @date 2019/10/20 16:40
 * @desc 找到链表中的环节点
 */
public class EntryNodeOfLoop {

    /**
     * 找到链表中两个指针的相遇的节点，该节点必在链表中
     * <p>
     * 一个指针走一步，一个指针走两步
     *
     * @param node
     * @return
     */
    static Node meetingNode(Node node) {
        if (node == null) {
            return null;
        }
        Node slow = node.next;
        if (slow == null) {
            return null;
        }
        Node fast = slow.next;
        while (fast != null && slow != null) {
            if (fast == slow) {
                return slow;
            }
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }
        return null;
    }

    /**
     * 找到链表环节点
     *
     * @param node
     * @return
     */
    static Node entryNodeOfLoop(Node node) {
        // 找到环内节点
        Node node1 = meetingNode(node);

        Node tmp = node1;

        int nodeNum = 0;
        while (tmp != null) {
            nodeNum++;
            tmp = tmp.next;
            if (tmp == node1) {
                break;
            }
        }
        // 继续定义两个指针，一个先走nodeNum，一个再走
        Node p1 = node;
        Node p2 = node;
        for (int i = 0; i < nodeNum; ++i) {
            p1 = p1.next;
        }
        // 直到两个节点相等时，即为环的入口节点
        while (p1 != p2) {
            System.out.println("循环");
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

    /**
     * 反转链表
     *
     * @param node
     */
    public Node reverseList(Node node) {
        if (node == null) {
            return null;
        }
        Node preNode = null;
        Node reversedHead = null;
        while (node != null) {
            Node pNext = node.next;
            // 代表是尾节点
            if (pNext == null) {
                reversedHead = node;
            }
            // 将node的下个节点变为前一个节点
            node.next = preNode;
            // 继续循环，当前node变为前一个节点
            preNode = node;
            // 将下个节点变为循环的node节点
            node = pNext;
        }
        return reversedHead;
    }


    private static class Node<T> {
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

    public static void main(String[] args) {
        Node node1 = new Node("aa");
        Node node2 = new Node("bb");
        Node node3 = new Node("cc");
        Node node4 = new Node("dd");
        Node node5 = new Node("ee");
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node3;

        Node node = entryNodeOfLoop(node1);
        System.out.println(node.getValue());


    }

}



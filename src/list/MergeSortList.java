package list;

/**
 * @author fengsihan
 * @date 2019/10/20 19:18
 * @desc 合并排序的链表
 */
public class MergeSortList {

    public static Node mergeSortList(Node<Integer> node1, Node<Integer> node2) {
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }

        Node pMergeHead = null;

        if (node1.getValue() < node2.getValue()) {
            pMergeHead = node1;
            pMergeHead.setNext(mergeSortList(node1.getNext(), node2));
        } else {
            pMergeHead = node2;
            pMergeHead.setNext(mergeSortList(node1, node2.getNext()));
        }
        return pMergeHead;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(3);
        Node node3 = new Node(5);
        Node node4 = new Node(2);
        Node node5 = new Node(4);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        node1.setNext(node2);
        node2.setNext(node3);

        node4.setNext(node5);
        node5.setNext(node6);
        node6.setNext(node7);

        Node node = mergeSortList(node1, node4);
        while (node != null) {
            System.out.println(node.getValue());
            node = node.getNext();
        }
    }
}

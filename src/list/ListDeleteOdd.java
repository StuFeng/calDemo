package list;

/**
 * @description: list删除奇数位置的节点
 * @author: fengsihan
 * @time: 2021-04-09 00:07
 */
public class ListDeleteOdd {

  public static void main(String[] args) {
    Node node4 = new Node(1);
    Node node5 = new Node(2);
    Node node6 = new Node(3);
    Node node7 = new Node(4);
    Node node8 = new Node(5);
    Node node9 = new Node(6);
    Node node10 = new Node(7);
    Node node11 = new Node(8);

    node4.setNext(node5);
    node5.setNext(node6);
    node6.setNext(node7);
    node7.setNext(node8);
    node8.setNext(node9);
    node9.setNext(node10);
    node10.setNext(node11);

    Node node = deleteOddNode(node4);

    while (node != null) {
      System.out.println(node.getValue());
      node = node.getNext();
    }

  }

  public static Node deleteOddNode(Node node) {
    if (node == null) {
      return null;
    }

    if (node.getNext() == null) {
      return null;
    }

    int n = 0;
    Node newHead = node.getNext();
    Node tmp = newHead.getNext();
    while (tmp.getNext() != null) {
        // 删除node1
      Node next = tmp.getNext().getNext(); // 4
      tmp.setNext(next);// 2-->4
      if (next==null) {
        break;
      }
      tmp= tmp.getNext();// 4
    }

    return newHead;
  }
}

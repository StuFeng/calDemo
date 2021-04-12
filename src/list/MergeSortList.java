package list;

import java.util.ArrayList;
import java.util.List;

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
    Node node8 = new Node(8);
    Node node9 = new Node(9);

    node1.setNext(node2);
    node2.setNext(node3);

    node4.setNext(node5);
    node5.setNext(node6);
    node6.setNext(node7);

    node8.setNext(node9);

    List<Node<Integer>> list = new ArrayList<>();

    list.add(node1);
    list.add(node4);
    list.add(node8);

    Node node = mergeSortList(list);

//    Node node = mergeSortList(node1, node4);
    while (node != null) {
      System.out.println(node.getValue());
      node = node.getNext();
    }
  }

  private static Node mergeSortList(List<Node<Integer>> list) {
    if (list == null || list.size() == 0) {
      return null;
    }
    if (list.size() == 1) {
      return list.get(0);
    }

    int k = list.size();

    List<Node<Integer>> list1 = new ArrayList<>();
    if (k % 2 == 0) {
      for (int i = 0; i < list.size(); i = i + 2) {
        Node node = mergeSortList(list.get(i), list.get(i + 1));
        list1.add(node);
      }
    } else {
      for (int i = 0; i < list.size() - 1; i = i + 2) {
        Node node = mergeSortList(list.get(i), list.get(i + 1));
        list1.add(node);
      }
      list1.add(list.get(k - 1));
    }
    return mergeSortList(list1);
  }
}

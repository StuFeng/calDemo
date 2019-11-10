package tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * @author fengsihan
 * @date 2019/11/10 15:30
 * @desc 从上到下打印二叉树
 */
public class PrintFromTopToButtom {

    static void printFromTopToBottom(BinaryTreeNode<String> node){
        // 先入先出队列
        Queue<BinaryTreeNode> queue = new ArrayDeque<>();
        queue.add(node);
        while (queue.size() != 0){
            int size = queue.size();
            int leftFirstIndex = size;
            while (size > 0){
                BinaryTreeNode node1 = queue.poll();
                // 左视图
//                if (leftFirstIndex == size){
//                    System.out.print(node1.getData());
//                }
                // 所有遍历
                System.out.print(node1.getData());

                // 一行打印
                if (node1.getLeftNode() != null){
                    queue.add(node1.getLeftNode());
                }
                if (node1.getRightNode() != null){
                    queue.add(node1.getRightNode());
                }
                size --;
            }
            System.out.println();
        }

        System.out.println();
    }

    public static void main(String[] args) {
        BinaryTreeNode<String> R3 = new BinaryTreeNode<>("F", null, null);
        BinaryTreeNode<String> L2 = new BinaryTreeNode<>("D", null, null);
        BinaryTreeNode<String> R2 = new BinaryTreeNode<>("E", null, R3);
        BinaryTreeNode<String> L1 = new BinaryTreeNode<>("B", L2, R2);

        BinaryTreeNode<String> L3 = new BinaryTreeNode<>("G", null, null);
        BinaryTreeNode<String> R4 = new BinaryTreeNode<>("H", null, null);

        BinaryTreeNode<String> R1 = new BinaryTreeNode<>("C", L3, R4);
        BinaryTreeNode<String> T = new BinaryTreeNode<>("A", L1, R1);
        printFromTopToBottom(T);
    }
}

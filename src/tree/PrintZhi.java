package tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * @author fengsihan
 * @date 2019/11/10 17:15
 * @desc 之字形打印二叉树
 */
public class PrintZhi {


    public static void printZhi(BinaryTreeNode node) {

        // 先入先出队列 单双数存储队列
        Deque[] levels = new Deque[2];
        levels[0] = new ArrayDeque<>();
        levels[1] = new ArrayDeque<>();

        int current = 0;
        int next = 1;

        levels[current].push(node);
        while (levels[current].size() != 0 || levels[next].size() != 0) {
            BinaryTreeNode node1 = (BinaryTreeNode) levels[current].pop();
            System.out.print(node1.getData());

            if (current == 0) {
                if (node1.getLeftNode() != null) {
                    levels[next].push(node1.getLeftNode());
                }
                if (node1.getRightNode() != null) {
                    levels[next].push(node1.getRightNode());
                }
            } else {
                if (node1.getRightNode() != null) {
                    levels[next].push(node1.getRightNode());
                }
                if (node1.getLeftNode() != null) {
                    levels[next].push(node1.getLeftNode());
                }
            }

            // 当前队列空了以后，切换队列进行消费
            if (levels[current].size() == 0) {
                System.out.println();
                current = 1 - current;
                next = 1 - next;
            }
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode<String> R3 = new BinaryTreeNode<>("F", null, null);
        BinaryTreeNode<String> L2 = new BinaryTreeNode<>("D", null, null);
        BinaryTreeNode<String> R2 = new BinaryTreeNode<>("E", null, R3);
        BinaryTreeNode<String> L1 = new BinaryTreeNode<>("B", L2, R2);

        BinaryTreeNode<String> R1 = new BinaryTreeNode<>("C", null, null);
        BinaryTreeNode<String> T = new BinaryTreeNode<>("A", L1, R1);
        PrintFromTopToButtom.printFromTopToBottom(T);
        printZhi(T);

    }
}

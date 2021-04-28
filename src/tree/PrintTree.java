package tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author fengsihan
 * @date 2019/10/5 14:49
 * @desc
 */
public class PrintTree {

    /**
     * 从上到下打印二叉树
     *
     * @param root
     */
    public static void printFromTopToBottom(BinaryTreeNode<String> root){
        if (root == null){
            return;
        }
        // 初始化queue
        Queue<BinaryTreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (queue.peek() != null){
            BinaryTreeNode node = queue.poll();
            System.out.print(node.getData());
            if (node.getLeftNode() != null){
                queue.add(node.getLeftNode());
            }
            if (node.getRightNode() != null){
                queue.add(node.getRightNode());
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        BinaryTreeNode<String> R3 = new BinaryTreeNode<>("F", null, null);
        BinaryTreeNode<String> L2 = new BinaryTreeNode<>("D", null, null);
        BinaryTreeNode<String> R2 = new BinaryTreeNode<>("E", null, R3);
        BinaryTreeNode<String> L1 = new BinaryTreeNode<>("B", L2, R2);
        BinaryTreeNode<String> R1 = new BinaryTreeNode<>("C", null, null);
        BinaryTreeNode<String> T = new BinaryTreeNode<>("A", L1, R1);
        printFromTopToBottom(T);

    }
}

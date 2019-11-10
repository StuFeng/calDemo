package tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author fengsihan
 * @date 2019/11/5 23:49
 * @desc 递归方式求二叉树镜像
 */
public class MirrorRecursively {

    /**
     * 求二叉树的镜像
     *
     * @param node
     */
    static void mirrorRecursively(BinaryTreeNode node) {
        if (node == null) {
            return;
        }
        if (node.getLeftNode() == null && node.getRightNode() == null) {
            return;
        }

        // 交换左右节点
        BinaryTreeNode tmp = node.getLeftNode();
        node.setLeftNode(node.getRightNode());
        node.setRightNode(tmp);

        mirrorRecursively(node.getLeftNode());
        mirrorRecursively(node.getRightNode());
    }


    static void mirrorUnRecursively(BinaryTreeNode node) {
        if (node == null) {
            return;
        }

        Deque<BinaryTreeNode> stack = new ArrayDeque<>();
        stack.push(node);

        while (stack.size() != 0) {
            BinaryTreeNode node1 = stack.pop();
            swapNode(node1);
            if (node1.getLeftNode() != null) {
                stack.push(node1.getLeftNode());
            }
            if (node1.getRightNode() != null) {
                stack.push(node1.getRightNode());
            }
        }
    }

    static void swapNode(BinaryTreeNode node) {
        BinaryTreeNode tmp = node.getLeftNode();
        node.setLeftNode(node.getRightNode());
        node.setRightNode(tmp);
    }

    public static void main(String[] args) {
        BinaryTreeNode<String> R3 = new BinaryTreeNode<>("F", null, null);
        BinaryTreeNode<String> L2 = new BinaryTreeNode<>("D", null, null);
        BinaryTreeNode<String> R2 = new BinaryTreeNode<>("E", null, R3);
        BinaryTreeNode<String> L1 = new BinaryTreeNode<>("B", L2, R2);
        BinaryTreeNode<String> R1 = new BinaryTreeNode<>("C", null, null);
        BinaryTreeNode<String> T = new BinaryTreeNode<>("A", L1, R1);
        BinaryTree.posOrderUnRecur2(T);
        mirrorUnRecursively(T);
        BinaryTree.posOrderUnRecur2(T);
    }
}

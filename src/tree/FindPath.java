package tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author fengsihan
 * @date 2019/11/12 0:43
 * @desc 查找树路径上值的总和
 */
public class FindPath {

    public static void findPath(BinaryTreeNode node, int expectedSum) {

        if (node == null) {
            return;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        int currentSum = 0;

        findPath(node, expectedSum, stack, currentSum);


    }

    /**
     * @param node        根节点
     * @param expectedSum 期望值
     * @param stack       存放各节点的值，并打印
     * @param currentSum  当前值
     */
    private static void findPath(BinaryTreeNode node, int expectedSum, Deque<Integer> stack, int currentSum) {
        currentSum += (int) node.getData();
        stack.push((int) node.getData());

        boolean isLeaf = node.getLeftNode() == null && node.getRightNode() == null;

        if (currentSum == expectedSum && isLeaf) {
            System.out.print("path is found: ");
            Deque<Integer> stack1 = new ArrayDeque<>();
            for (Integer num : stack) {
                stack1.push(num);
            }
            for (Integer num : stack1) {
                System.out.print(num + "\t");
            }

            System.out.println();
        }

        if (node.getLeftNode() != null) {
            findPath(node.getLeftNode(), expectedSum, stack, currentSum);//
        }
        if (node.getRightNode() != null) {
            findPath(node.getRightNode(), expectedSum, stack, currentSum);
        }

        stack.pop();
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> L2 = new BinaryTreeNode<>(4, null, null);
        BinaryTreeNode<Integer> R2 = new BinaryTreeNode<>(7, null, null);
        BinaryTreeNode<Integer> L1 = new BinaryTreeNode<>(5, L2, R2);

        BinaryTreeNode<Integer> R1 = new BinaryTreeNode<>(12, null, null);
        BinaryTreeNode<Integer> T = new BinaryTreeNode<>(10, L1, R1);
        findPath(T, 22);
    }
}

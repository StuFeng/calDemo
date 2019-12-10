package tree;

/**
 * @author fengsihan
 * @date 2019/12/11 1:31
 * @desc 是否为平衡二叉树
 */
public class IsBalanced {

    static int depth = 0;


    static boolean isBananced(BinaryTreeNode node) {
        if (node == null) {
            return true;
        }

        boolean leftState = isBananced(node.getLeftNode());
        if (!leftState) {
            return false;
        }
        int left = depth;
        boolean rightState = isBananced(node.getRightNode());
        if (!rightState) {
            return false;
        }
        int right = depth;


        int diff = left - right;
        if (diff <= 1 && diff >= -1) {
            depth = 1 + (left > right ? left : right);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
//        BinaryTreeNode<String> R3 = new BinaryTreeNode<>("F", null, null);
        BinaryTreeNode<String> L2 = new BinaryTreeNode<>("D", null, null);
        BinaryTreeNode<String> R2 = new BinaryTreeNode<>("E", null, null);
        BinaryTreeNode<String> L1 = new BinaryTreeNode<>("B", L2, R2);
        BinaryTreeNode<String> R1 = new BinaryTreeNode<>("C", null, null);
        BinaryTreeNode<String> T = new BinaryTreeNode<>("A", L1, R1);
        boolean bananced = isBananced(T);
        System.out.println(bananced);
    }
}

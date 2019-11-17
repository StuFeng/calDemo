package tree;

/**
 * @author fengsihan
 * @date 2019/11/10 19:19
 * @desc 二叉查找树
 */
public class BST {

    /**
     * 是否为二叉搜索树的后续遍历序列
     *
     * @param sequence
     * @return
     */
    static boolean verifySequenceOfBST(int[] sequence, int leftIndex, int rightIndex) {
        if (sequence == null) {
            return false;
        }

        // 二叉树后续遍历根节点
        int root = sequence[rightIndex];

        // 二叉搜索树中左子树的节点值小于根节点的值
        // 确定左子树的位置
        int i = leftIndex;
        for (; i < rightIndex; i++) {
            if (sequence[i] > root) {
                break;
            }
        }

        // 确定右子树的位置
        int j = i;
        for (; j < rightIndex; j++) {
            // 发现小于根节点则不是搜索树序列
            if (sequence[j] < root) {
                return false;
            }
        }

        boolean left = true;
        // 处理左子树
        if (i > leftIndex) {
            left = verifySequenceOfBST(sequence, leftIndex, i - 1);
        }

        boolean right = true;
        if (i < rightIndex) {
            right = verifySequenceOfBST(sequence, i, rightIndex - 1);
        }

        return (left && right);
    }

    public static void main(String[] args) {
        int[] aa = new int[]{5, 8, 7, 11, 13, 12, 10};
        boolean b = verifySequenceOfBST(aa, 0, 6);
//        int[] aa = new int[]{7, 4, 6, 5};
//        boolean b = verifySequenceOfBST(aa, 0, 4);
        System.out.println(b);

    }
}

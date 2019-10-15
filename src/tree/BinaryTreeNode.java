package tree;

/**
 * @author fengsihan
 * @date 2019/10/1 12:26
 * @desc 二叉树
 *
 * 二叉树特征  数据 + 左子节点 + 右子节点
 */
public class BinaryTreeNode<T> {
    private T data;
    private BinaryTreeNode<T> leftNode;
    private BinaryTreeNode<T> rightNode;
    private BinaryTreeNode<T> parentNode;

    public BinaryTreeNode(T data, BinaryTreeNode<T> leftNode, BinaryTreeNode<T> rightNode) {
        this.data = data;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BinaryTreeNode<T> getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(BinaryTreeNode<T> leftNode) {
        this.leftNode = leftNode;
    }

    public BinaryTreeNode<T> getRightNode() {
        return rightNode;
    }

    public void setRightNode(BinaryTreeNode<T> rightNode) {
        this.rightNode = rightNode;
    }

    public BinaryTreeNode<T> getParentNode() {
        return parentNode;
    }

    public void setParentNode(BinaryTreeNode<T> parentNode) {
        this.parentNode = parentNode;
    }
}

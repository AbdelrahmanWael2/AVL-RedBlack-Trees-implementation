package Trees;

public class AVLNode<K extends Comparable<K>> implements INode<K> {
    private int leftHeight;
    private int rightHeight;
    private K key;
    private AVLNode<K> left;
    private AVLNode<K> right;
    private AVLNode<K> parent;

    // constructor
    public AVLNode(K key, AVLNode<K> left, AVLNode<K> right, AVLNode<K> parent) {
        this.key = key;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }

    public int getLeftHeight() {
        return leftHeight;
    }

    public void setLeftHeight(int leftHeight) {
        this.leftHeight = leftHeight;
    }

    public int getRightHeight() {
        return rightHeight;
    }

    public void setRightHeight(int rightHeight) {
        this.rightHeight = rightHeight;
    }

    @Override
    public K getKey() {
        return this.key;
    }

    public AVLNode<K> getRight() {
        return this.right;
    }

    @Override
    public void setKey(K key) {
        this.key = key;
    }

    public void setRight(AVLNode<K> right) {
        this.right = right;
    }

    public void setLeft(AVLNode<K> left) {
        this.left = left;
    }

    public AVLNode<K> getLeft() {
        return this.left;
    }

    public void setParent(AVLNode<K> parent) {
        this.parent = parent;
    }

    public AVLNode<K> getParent() {
        return this.parent;
    }

}

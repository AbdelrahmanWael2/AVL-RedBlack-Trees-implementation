package Trees;

public class AVLNode<K extends Comparable<K>> implements INode<K> {
    private K key;
    private INode<K> left;
    private INode<K> right;
    private INode<K> parent;

    public AVLNode(K key, INode<K> left, INode<K> right, INode<K> parent) {
        this.key = key;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }

    @Override
    public K getKey() {
        return this.key;
    }

    @Override
    public INode<K> getRight() {
        return this.right;
    }

    @Override
    public void setKey(K key) {
        this.key = key;
        throw new UnsupportedOperationException("Unimplemented method 'setKey'");
    }

    @Override
    public void setRight(INode<K> right) {
        this.right = right;
    }

    @Override
    public void setLeft(INode<K> left) {
        this.left = left;
    }

    @Override
    public INode<K> getLeft() {
        return this.left;
    }

    @Override
    public void setParent(INode<K> parent) {
        this.parent = parent;
    }

    @Override
    public INode<K> getParent() {
        return this.parent;
    }

}

package Trees;

public class RBNode<K extends Comparable<K>, V> implements INode {
    K key;
    char color;
    INode parent;
    INode right;
    INode left;

    public RBNode(K key, char color) {
        this.key = key;
        this.color = color;
    }

    @Override
    public Comparable getKey() {
        return null;
    }

    @Override
    public void setKey(Comparable key) {

    }

    public void setRight(INode right) {

    }

    public INode getRight() {
        return null;
    }

    public void setLeft(INode left) {

    }

    public INode getLeft() {
        return null;
    }

    public void setParent(INode parent) {

    }

    public INode getParent() {
        return null;
    }

    public int getColor() {
        return 0;
    }

    public void setColor(int color) {

    }

}

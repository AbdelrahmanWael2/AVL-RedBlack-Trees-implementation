package Trees;

public class AVLTree<K extends Comparable<K>> implements ITree<K> {

    private int height = 0;
    private int size = 0;

    AVLNode<K> root;

    public AVLTree(K value) {
        root = new AVLNode<K>(value, null, null, null);
    }

    @Override
    public String insert(K key) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    @Override
    public String delete() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public String getHeight() {
        return "The tree height is" + this.height + "\n";
    }

    private AVLNode<K> searchRecursion(AVLNode<K> currentNode, K value) {
        int found = currentNode.getKey().compareTo(value);
        if (found < 0) {
            if (currentNode.getRight() != null)
                searchRecursion(currentNode.getRight(), value);
            else
                return null;
        } else if (found > 0) {
            if (currentNode.getLeft() != null)
                searchRecursion(currentNode.getLeft(), value);
            else
                return null;
        } else
            return currentNode;
        return currentNode;
    }

    public String search(K value) {
        AVLNode<K> temp = root;
        if (searchRecursion(temp, value) != null) {
            return "Item found";
        } else
            return "Not found";
    }

}

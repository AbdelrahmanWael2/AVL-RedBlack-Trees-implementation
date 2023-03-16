package Trees;

public class AVLTree<K extends Comparable<K>> implements ITree<K> {

    private int height = 0;
    private int size = 0;
    private AVLNode<K> root;

    // constructor
    public AVLTree(K value) {
        root = new AVLNode<K>(value, null, null, null);
    }

    @Override
    public String insert(K key) {
        AVLNode<K> currentNode = searchRecursion(root, key);
        if (currentNode.getKey() == key)
            return "Item already exits";
        else {
            if (currentNode.getKey().compareTo(key) < 0) {
                currentNode.setRight(new AVLNode<K>(key, null, null, currentNode));
                // check and adjust hight by rotate
                return "Item added as a right child";
            } else {
                currentNode.setLeft(new AVLNode<K>(key, null, null, currentNode));
                // check and adjust hight by rotate
                return "Item added as a left child";
            }
        }

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
        return "The tree height is" + this.height;
    }

    private int max(int leftHeight, int rightHeight) {
        if(leftHeight >= rightHeight) return leftHeight;
        else return rightHeight;
    }

    private void rightRotate(AVLNode<K> currentNode){
        AVLNode<K> temp1 = currentNode.getLeft();
        AVLNode<K> temp2 = temp1.getRight();
        AVLNode<K> temp3 = currentNode.getParent();
        // rotate around currentNode
        temp1.setRight(currentNode);
        currentNode.setParent(temp1);
        temp1.setParent(temp3);
        currentNode.setLeft(temp2);
        temp2.setParent(currentNode);
        //update heights for currentNode and temp1
        currentNode.setLeftHeight(max(temp2.getLeftHeight(), temp2.getRightHeight()));
        temp1.setRightHeight(max(currentNode.getLeftHeight(), currentNode.getRightHeight()));
    }

    private void leftRotate(AVLNode<K> currentNode){
        AVLNode<K> temp1 = currentNode.getRight();
        AVLNode<K> temp2 = temp1.getLeft();
        AVLNode<K> temp3 = currentNode.getParent();
        // rotate around currentNode
        temp1.setLeft(currentNode);
        currentNode.setParent(temp1);
        temp1.setParent(temp3);
        currentNode.setRight(temp2);
        temp2.setParent(currentNode);
        //update heights for currentNode and temp1
        currentNode.setRightHeight(max(temp2.getLeftHeight(), temp2.getRightHeight()));
        temp1.setLeftHeight(max(currentNode.getLeftHeight(), currentNode.getRightHeight()));
    }

    // start search
    private AVLNode<K> searchRecursion(AVLNode<K> currentNode, K value) {
        int found = currentNode.getKey().compareTo(value);
        if (found < 0) {
            if (currentNode.getRight() != null)
                searchRecursion(currentNode.getRight(), value);
            else
                return currentNode;
        } else if (found > 0) {
            if (currentNode.getLeft() != null)
                searchRecursion(currentNode.getLeft(), value);
            else
                return currentNode;
        } else
            return currentNode;
        return currentNode;
    }

    public String search(K value) {
        AVLNode<K> temp = root;
        if (searchRecursion(temp, value).getKey() == value) {
            return "Item found";
        } else
            return "Not found";
    }
    // end search

}

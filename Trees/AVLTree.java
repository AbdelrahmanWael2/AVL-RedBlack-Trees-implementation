package Trees;

import java.math.*;

public class AVLTree<K extends Comparable<K>> implements ITree<K> {

    private int height = 0;
    private int size = 0;
    private AVLNode<K> root;

    // constructor
    public AVLTree(K value) {
        root = new AVLNode<K>(value, null, null, null);
    }

    private void modifyHeights(AVLNode<K> node) {
        AVLNode<K> p = node.getParent();
        if (p != null) {
            int h1 = p.getLeft().getHeight();
            int h2 = p.getRight().getHeight();
            p.setHeight(Math.max(h1, h2) + 1);
        }
    }

    private AVLNode<K> getFirstUnBalance(AVLNode<K> node) {
        while (node != null) {
            if (Math.abs(node.getLeft().getHeight() - node.getRight().getHeight()) > 1) {
                break;
            } else
                node = node.getParent();
        }
        return node;
    }

    @Override
    public String insert(K key) {
        AVLNode<K> currentNode = searchRecursion(root, key);
        if (currentNode.getKey() == key)
            return "Item already exits";
        else {
            size++;
            AVLNode<K> newNode = new AVLNode<K>(key, null, null, currentNode);
            if (currentNode.getKey().compareTo(key) < 0) {
                currentNode.setRight(newNode);
            } else {
                currentNode.setLeft(newNode);
            }
            modifyHeights(newNode);
            // rotate if neccessary
            return "Item added successfully";
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
        if (leftHeight >= rightHeight)
            return leftHeight;
        else
            return rightHeight;
    }

    private void rightRotate(AVLNode<K> currentNode) {
        AVLNode<K> temp1 = currentNode.getLeft();
        AVLNode<K> temp2 = temp1.getRight();
        AVLNode<K> temp3 = currentNode.getParent();
        // rotate around currentNode
        temp1.setRight(currentNode);
        currentNode.setParent(temp1);
        temp1.setParent(temp3);
        currentNode.setLeft(temp2);
        temp2.setParent(currentNode);
        // update heights for currentNode and temp1
        currentNode.setHeight(currentNode.getHeight() - 1);
        temp1.setHeight(currentNode.getHeight() + 1);
    }

    private void leftRotate(AVLNode<K> currentNode) {
        AVLNode<K> temp1 = currentNode.getRight();
        AVLNode<K> temp2 = temp1.getLeft();
        AVLNode<K> temp3 = currentNode.getParent();
        // rotate around currentNode
        temp1.setLeft(currentNode);
        currentNode.setParent(temp1);
        temp1.setParent(temp3);
        currentNode.setRight(temp2);
        temp2.setParent(currentNode);
        // update heights for currentNode and temp1
        currentNode.setHeight(currentNode.getHeight() - 1);
        temp1.setHeight(currentNode.getHeight() + 1);
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

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

    // incriment hights after insert
    private void incHeights(AVLNode<K> node) {
        AVLNode<K> p = node.getParent();
        if (p != null) {
            int h1 = p.getLeft().getHeight();
            int h2 = p.getRight().getHeight();
            p.setHeight(Math.max(h1, h2) + 1);
        }
    }

    // determine the first node having the problem
    private AVLNode<K> getFirstUnBalance(AVLNode<K> node) {
        while (node != null) {
            if (Math.abs(node.getLeft().getHeight() - node.getRight().getHeight()) > 1) {
                break;
            } else
                node = node.getParent();
        }
        return node;
    }

    // determine ll, rr, rl, lr
    private int getPath(AVLNode<K> node) {
        int ans = 0;
        AVLNode<K> temp;
        if (node.getLeft().getHeight() > node.getRight().getHeight()) {
            temp = node.getLeft();
            ans = 10;
        } else
            temp = node.getRight();
        if (temp.getLeft().getHeight() > temp.getRight().getHeight())
            ans += 1;
        return ans;
    }

    // rotate for 4 cases
    private void rotates(int n, AVLNode<K> node) {
        switch (n) {
            // ll
            case 11:
                rightRotate(node);
                break;
            // rr
            case 0:
                leftRotate(node);
                break;
            // lr
            case 10:
                leftRotate(node.getLeft());
                rightRotate(node);
                break;
            // rl
            case 1:
                rightRotate(node.getRight());
                leftRotate(node);
            default:
                break;
        }
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
            incHeights(newNode);
            AVLNode<K> first = getFirstUnBalance(newNode);
            rotates(getPath(first), first);
            return "Item added successfully";
        }
    }

    @Override
    public String delete(K value) {
        AVLNode<K> temp = root;
        if (deleteRecursion(temp, value).getKey() == value) {
            return "Item deleted";
        } else
            return "Not found";
    }

    private AVLNode<K> deleteRecursion(AVLNode<K> root, K value){

        // first: we perform normal BST deletion

        if(root == null) return root;   // nothing to delete
        int found = root.getKey().compareTo(value); // found: -ve if key < value, +ve if key > value, 0 if key = value
        if(found < 0) root.setRight(deleteRecursion(root.getRight(), value));
        else if(found > 0) root.setLeft(deleteRecursion(root.getLeft(), value));
        else{
            if(root.getLeft() == null && root.getRight() == null){  // no children
                root = null;
            }else if(root.getLeft() == null || root.getRight() == null){    // only one child
                if(root.getLeft() != null)
                    root = root.getLeft();
                else
                    root = root.getRight();
            }else{  // two children
                AVLNode<K> temp = root;
                while(temp.getRight() != null) temp = temp.getRight();  // get the inorder successor
                root.setKey(temp.getKey()); // swap the deleted key with the successor's key
                root.setRight(deleteRecursion(root.getRight(), temp.getKey())); //delete the successor
            }
        }
        // after finishing the recursive calls, 
        // return a null node if the deleted node was the root of its own recursive call
        if(root == null) return root;

        // second: update heights and check for balance

        root.setHeight(1 + max(root.getLeft().getHeight(), root.getRight().getHeight()));
        int balance = getBalance(root);
        if(balance > 1){    // case 1 (left)
            int subBalance1 = getBalance(root.getLeft());
            if(subBalance1 >= 0){   // case 1.1 (left left)
                rightRotate(root);
            }else if(subBalance1 < 0){  // case 1.2 (left right)
                leftRotate(root.getLeft());
                rightRotate(root);
            }
        }else if(balance < -1){ //case 2 (right)
            int subBalance2 = getBalance(root.getRight());
            if(subBalance2 >= 0){   // case 2.1 (right left)
                rightRotate(root.getRight());
            }else if(subBalance2 < 0){  // case 2.2 (right right)
                leftRotate(root);
            }
        }

        return root;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public String getHeight() {
        return "The tree height is" + this.height;
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

    /* --------Utils-------- */

    private int max(int leftHeight, int rightHeight) {
        if (leftHeight >= rightHeight)
            return leftHeight;
        else
            return rightHeight;
    }

    private int heightUtil(AVLNode<K> node){
        if(node == null) return 0;
        else return node.getHeight();
    }

    private int getBalance(AVLNode<K> node){
        if(node == null) return 0;
        else
            return heightUtil(node.getLeft()) - heightUtil(node.getRight());
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
        currentNode.setHeight(1 + max(currentNode.getLeft().getHeight(), currentNode.getRight().getHeight()));
        temp1.setHeight(1 + max(temp1.getLeft().getHeight(), temp1.getRight().getHeight()));
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
        currentNode.setHeight(1 + max(currentNode.getLeft().getHeight(), currentNode.getRight().getHeight()));
        temp1.setHeight(1 + max(temp1.getLeft().getHeight(), temp1.getRight().getHeight()));
    }
}

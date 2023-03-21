package Trees;

public class RedBlack<K extends Comparable<K>> implements ITree<K> {

    RBNode<K> root;

    /*
     * root is black by default
      */
    public RedBlack() {
        this.root = new RBNode<>(null, 'B', null, null, null);
    }

    int size = 0;

    @Override
    public String insert(K key) {

        RBNode<K> node = new RBNode<>(key, 'R', null, null, null);

        if (key == null) {
            throw new RuntimeException("key not found");
        }

        /* Insert to empty tree */
        if (size == 0) {
            node.setColor('B');
            node.setRight(new RBNode<>(null, 'B', null, null, null));
            node.setLeft(new RBNode<>(null, 'B', null, null, null));
            this.root = node;
            size++;
            return "Inserted to empty tree";
        }

        // n to find right place in the tree
        // node has the key value
        RBNode<K> parent = null;
        RBNode<K> current = this.root;
        while (current != null && !current.isNull()) {
            parent = current;

            if (current.getKey().compareTo(key) == 0) {
                System.out.println("key already inserted");
            }else if(current.getKey().compareTo(key) < 0){
                        current = current.getRight();
            } else {
                current = current.getLeft();
            }
        }

        assert parent != null;

        node.setParent(parent);

        if (parent.getKey().compareTo(key) > 0) {
            parent.setLeft(node);
        } else {
            parent.setRight(node);
        }

        // set nil children to new node
        node.setLeft(new RBNode<K>(null, 'B', null, null, node));

        fixThisTree(node);

        /*
         * increment size by one after each SUCCESSFUL insertion
         * getting size is O(1)
         */
        size++;
        return "key added successfully";

    }

    void fixThisTree(RBNode<K> node) {

        if (node.getParent().getColor() == 'B') {
            return;
        }
        /*
         * recursion from node to root
         */
        while (!node.getParent().isNull() && node.getParent().getColor() == 'R') {

            RBNode<K> gp = node.getParent().getParent();
            RBNode<K> u;

            // CASE 1 : parent is left child of grandparent
            if (node.getParent().equals(gp.getLeft())) {
                u = gp.getRight();
                if (u != null && !u.isNull() && u.getColor() == 'R') {
                    node.getParent().setColor('B');
                    u.setColor('B');
                    if (!gp.equals(root)) {
                        gp.setColor('R');
                        // recursive
                        node = gp;
                    }
                } else {
                    if (node.equals(node.getParent().getRight())) {
                        leftRotate(node.getParent());
                        node = node.getLeft();
                    }
                    node.getParent().setColor('B');
                    gp.setColor('R');
                    rightRotate(node.getParent().getParent());
                }
            }

            // CASE 2: parent is right child of grandparent (MIRROR CASE)
            else {
                u = gp.getLeft();
                if (u.getColor() == 'R') {
                    node.getParent().setColor('B');
                    u.setColor('B');
                    if (!gp.equals(root)) {
                        gp.setColor('R');
                        // recursive
                        node = gp;
                    }
                } else {
                    if (node.equals(node.getParent().getLeft())) {
                        rightRotate(node.getParent());
                        node = node.getRight();
                    }
                    node.getParent().setColor('B');
                    node.getParent().getParent().setColor('R');
                    leftRotate(node.getParent().getParent());
                }

            }

        }
        root.setColor('B');
    }

    void leftRotate(RBNode<K> node) {
        RBNode<K> temp = node.getRight();
        node.setRight(temp.getLeft());

        if (!temp.getLeft().isNull()) {
            temp.getLeft().setParent(node);
        }

        temp.setParent(node.getParent());

        if (node.getParent() == null) {
            this.root = temp;
        } else if (node.equals(node.getParent().getLeft())) {
            node.getParent().setLeft(temp);
        } else {
            node.getParent().setRight(temp);
        }
        temp.setLeft(node);
        node.setParent(temp);
    }

    void rightRotate(RBNode<K> node) {

        RBNode<K> temp = node.getLeft();

        node.setLeft(temp.getRight());

        // if (!temp.getRight().isNull()) {
        if (temp.getRight() != null) {
            temp.getRight().setParent(node);
        }

        temp.setParent(node.getParent());

        if (node.getParent() == null) {
            this.root = temp;
        } else if (node.equals(node.getParent().getLeft())) {
            node.getParent().setLeft(temp);
        } else {
            node.getParent().setRight(temp);
        }

        temp.setRight(node);
        node.setParent(temp);
    }

    @Override
    public String delete(K key) {

        if (key == null) {
            throw new RuntimeException("No key");
        }

        RBNode<K> node = this.search2(this.root, key);
        deleteThis(node);

        return "Deleted Successfully";
    }

    void deleteThis(RBNode<K> node) {

    }

    // @Override
    public String search(K key) {
        if (search2(root, key) != null)
            return key + " found";
        else
            return key + " not found";
    }

    private RBNode<K> search2(RBNode<K> root, K key) {
        if (root == null || root.isNull()) {
            return null;
        }
        if (root.getKey().compareTo(key) == 0)
            return root;
        if (root.getKey().compareTo(key) > 0) {
            return search2(root.getLeft(), key);

        }
        if (root.getKey().compareTo(key) < 0) {
            return search2(root.getRight(), key);
        }
        return null;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int getHeight() {
        return height(root);
    }

    // O(n)
    private int height(RBNode<K> node) {
        // base case
        if (node == null || node.isNull()) {
            return 0;
        } else {
            int leftHeight = height(node.getLeft());
            int rightHeight = height(node.getRight());
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public void printInorder(RBNode<K> node) {
        if (node == null || node.isNull())
            return;
        printInorder(node.getLeft());
        if (node == root)
            System.out.print("*");
        System.out.print(node.getKey() + " " + node.getColor() + " ");
        printInorder(node.getRight());
    }

    // overload
    public void printInorder() {
        if (size == 0) {
            System.out.println("Empty tree");
        }
        printInorder(root);
        System.out.println();
    }
}
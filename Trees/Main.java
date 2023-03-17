package Trees;

import javafx.print.PrintColor;

public class Main {
    public static void main(String[] args) {
        AVLTree<Integer> t = new AVLTree<Integer>(10);

        t.delete(10);
        t.insert(5);

        t.printInorder();

        // t.delete(10);

        // t.printInorder();
        // System.out.println(t.insert(5));
        // System.out.println(t.insert(15));
        // System.out.println(t.insert(8));
        // System.out.println(t.insert(3));
        // System.out.println(t.insert(17));
        // System.out.println(t.insert(14));

        // t.printInorder();

        // System.out.println(t.delete(14));
        // System.out.println(t.getLastDeletedNode().getKey());
        // t.printInorder();
        // System.out.println(t.delete(15));
        // System.out.println(t.getLastDeletedNode().getKey());
        // t.printInorder();
        // System.out.println(t.delete(17));
        // System.out.println(t.getLastDeletedNode().getKey());
        // t.printInorder();
        // System.out.println(t.delete(18));
        // System.out.println(t.getLastDeletedNode().getKey());
        // t.printInorder();
        // System.out.println(t.delete(5));
        // System.out.println(t.getLastDeletedNode().getKey());
        // t.printInorder();
        // System.out.println(t.delete(8));
        // System.out.println(t.getLastDeletedNode().getKey());
        // t.printInorder();
        // System.out.println(t.delete(10));
        // System.out.println(t.getLastDeletedNode().getKey());
        // t.printInorder();
        // System.out.println(t.delete(3 ));
        // System.out.println(t.getLastDeletedNode().getKey());
        // t.printInorder();
        // System.out.println("Size: " + t.getSize());
        // System.out.println(t.insert(5));
        // t.printInorder();
    }
}

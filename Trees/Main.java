package Trees;

public class Main {
    public static void main(String[] args) {
        AVLTree<Integer> t = new AVLTree<Integer>(41);

        // System.out.println(t.getSize());
        t.insert(38);
        // System.out.println(t.getHeight());
        // System.out.println(t.getSize());
        t.insert(31);
        // System.out.println(t.getHeight());
        // System.out.println(t.getSize());
        t.insert(12);
        // System.out.println(t.getHeight());
        // System.out.println(t.getSize());
        t.insert(19);
        // System.out.println(t.getHeight());
        // System.out.println(t.getSize());
        t.insert(8);
        // System.out.println(t.getHeight());
        // System.out.println(t.getSize());
        System.out.println(t.delete(8));
        System.out.println(t.getHeight());
        System.out.println(t.getSize());
        System.out.println(t.delete(12));
        System.out.println(t.getHeight());
        System.out.println(t.getSize());
        System.out.println(t.delete(19));
        System.out.println(t.getHeight());
        System.out.println(t.getSize());
        System.out.println(t.delete(31));
        System.out.println(t.getHeight());
        System.out.println(t.getSize());
        System.out.println(t.delete(38));
        System.out.println(t.getHeight());
        System.out.println(t.getSize());
        System.out.println(t.delete(41));
        System.out.println(t.getHeight());
        System.out.println(t.getSize());
        System.out.println(t.insert(50));
        System.out.println(t.getHeight());
        System.out.println(t.getSize());
        // t.delete(10);
        // t.insert(10);
        // t.insert(5);
        // t.insert(11);
        // t.insert(12);
        // t.insert(13);
        // t.insert(14);
        // t.delete(12);
        // t.insert(12);
        // t.printInorder();
        // System.out.println("Size: " + t.getSize());

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

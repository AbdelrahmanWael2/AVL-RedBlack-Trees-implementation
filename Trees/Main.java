package Trees;

public class Main {
    public static void main(String[] args) {
        AVLTree<Integer> t = new AVLTree<Integer>(5);
        System.out.println(t.insert(10));
        System.out.println(t.insert(10));
        System.out.println(t.insert(20));
        System.out.println(t.delete(5));
        // System.out.println(t.delete(10));
        System.out.println(t.getSize());
        System.out.println(t.getHeight());

    }
}

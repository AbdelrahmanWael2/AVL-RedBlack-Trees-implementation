package Trees;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        AVLTree<String> t = new AVLTree<String>("a");

        t.insert("b");
        t.insert("c");
        t.insert("d");
        t.insert("e");
        t.insert("f");
        t.insert("g");
        t.insert("h");
        t.insert("i");
        t.insert("j");
        t.insert("k");
        t.insert("l");
        t.delete("h");



        // try {
        //     File myObj = new File("C:/Users/moham/Desktop/AVL-RedBlack-Trees-implementation/Trees/test.txt");
        //     Scanner myReader = new Scanner(myObj);
        //     while (myReader.hasNextLine()) {
        //       String data = myReader.nextLine();
        //       data = data.toLowerCase();
        //       t.insert(data);
        //     }
        //     myReader.close();
        //   } catch (FileNotFoundException e) {
        //     System.out.println("An error occurred.");
        //     e.printStackTrace();
        //   }
        
        //   try {
        //     File myObj = new File("C:/Users/moham/Desktop/AVL-RedBlack-Trees-implementation/Trees/test2.txt");
        //     Scanner myReader = new Scanner(myObj);
        //     while (myReader.hasNextLine()) {
        //       String data = myReader.nextLine();
        //       data = data.toLowerCase();
        //       t.delete(data);
        //     }
        //     myReader.close();
        //   } catch (FileNotFoundException e) {
        //     System.out.println("An error occurred.");
        //     e.printStackTrace();
        //   }
          
          

        t.printInorder();
        // System.out.println("Size: " + t.getSize());
        // System.out.println(t.getHeight());
        // System.out.println(t.insert(10));
        // System.out.println(t.insert(15));
        // t.printInorder();
        // System.out.println("Size: " + t.getSize());
        // System.out.println(t.getHeight());
        // System.out.println(t.insert(13));
        // System.out.println(t.insert(14));
        // t.printInorder();
        // System.out.println("Size: " + t.getSize());
        // System.out.println(t.getHeight());
        // System.out.println(t.insert(12));
        // t.printInorder();
        // System.out.println("Size: " + t.getSize());
        // System.out.println(t.getHeight());
        // System.out.println(t.delete(6));
        // System.out.println(t.delete(12));
        // System.out.println(t.delete(13));
        // t.printInorder();
        // System.out.println("Size: " + t.getSize());
        // System.out.println(t.getHeight());
        // System.out.println(t.delete(15));
        // t.printInorder();
        // System.out.println("Size: " + t.getSize());
        // System.out.println(t.getHeight());
        // System.out.println(t.delete(10));
        // t.printInorder();
        // System.out.println("Size: " + t.getSize());
        // System.out.println(t.getHeight());
        // System.out.println(t.delete(5));
        // t.printInorder();
        // System.out.println("Size: " + t.getSize());
        // System.out.println(t.getHeight());
        // System.out.println(t.delete(14));
        // t.printInorder();
        // System.out.println("Size: " + t.getSize());
        // System.out.println(t.getHeight());
        // System.out.println(t.delete(15));
        // t.printInorder();
        // System.out.println("Size: " + t.getSize());
        // System.out.println(t.getHeight());
        // System.out.println(t.insert(15));
        // t.printInorder();
        // System.out.println("Size: " + t.getSize());
        // System.out.println(t.getHeight());
        // System.out.println(t.insert(4));
        // t.printInorder();
        // System.out.println("Size: " + t.getSize());
        // System.out.println(t.getHeight());
        // // System.out.println(t.getSize());
        // t.insert(38);
        // // System.out.println(t.getHeight());
        // // System.out.println(t.getSize());
        // t.insert(31);
        // // System.out.println(t.getHeight());
        // // System.out.println(t.getSize());
        // t.insert(12);
        // // System.out.println(t.getHeight());
        // // System.out.println(t.getSize());
        // t.insert(19);
        // // System.out.println(t.getHeight());
        // // System.out.println(t.getSize());
        // t.insert(8);
        // // System.out.println(t.getHeight());
        // // System.out.println(t.getSize());
        // System.out.println(t.delete(8));
        // System.out.println(t.getHeight());
        // System.out.println(t.getSize());
        // System.out.println(t.delete(12));
        // System.out.println(t.getHeight());
        // System.out.println(t.getSize());
        // System.out.println(t.delete(19));
        // System.out.println(t.getHeight());
        // System.out.println(t.getSize());
        // System.out.println(t.delete(31));
        // System.out.println(t.getHeight());
        // System.out.println(t.getSize());
        // System.out.println(t.delete(38));
        // System.out.println(t.getHeight());
        // System.out.println(t.getSize());
        // System.out.println(t.delete(41));
        // System.out.println(t.getHeight());
        // System.out.println(t.getSize());
        // System.out.println(t.insert(50));
        // System.out.println(t.getHeight());
        // System.out.println(t.getSize());
        // System.out.println(t.delete(10));
        // System.out.println(t.insert(10));
        // System.out.println(t.insert(5));
        // System.out.println(t.insert(11));
        // System.out.println(t.insert(12));
        // System.out.println(t.insert(13));
        // t.printInorder();
        // System.out.println("Size: " + t.getSize());
        // System.out.println(t.getHeight());
        // System.out.println(t.insert(14));
        // t.printInorder();
        // System.out.println("Size: " + t.getSize());
        // System.out.println(t.getHeight());
        // System.out.println(t.delete(12));
        // System.out.println(t.insert(12));
        // t.printInorder();
        // System.out.println("Size: " + t.getSize());
        // System.out.println(t.getHeight());
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

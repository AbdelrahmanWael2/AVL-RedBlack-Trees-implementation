package Trees;

/*generic interface*/
public interface ITree<K extends Comparable<K>> {

    String insert(K key);

    String delete();

    int getSize();

    String getHeight();
}

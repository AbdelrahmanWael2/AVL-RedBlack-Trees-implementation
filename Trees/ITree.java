package Trees;

/*generic interface*/
public interface ITree<K extends Comparable<K>> {

    String insert(K key);

    String delete(K key);

    int getSize();

    String getHeight();
}

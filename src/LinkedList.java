import java.util.Iterator;

public class LinkedList<T> implements Iterator<T> {
    private Node<T> head;
    private int count;
    private Node<T> iterator;

    public int getCount() {
        return count;
    }



    public void resetIterator() {
        iterator = null;
    }

    public boolean hasNext() {

        if (iterator == null) {
            if (head == null) {
                return false;
            } else {
                return true;
            }
        }

        if (iterator.getNext() == null) {
            return false;
        }

        return true;
    }

    public T next() {

        if (iterator == null) {
            if (head == null) {
                return null;
            } else {
                iterator = head;
                return iterator.getData();
            }
        }

        if (iterator.getNext() == null) {
            return null;
        } else {
            iterator = iterator.getNext();
            return iterator.getData();
        }
    }

    public void addToHead(T data) {

            Node<T> n = new Node<T>();
            n.setData(data);

            n.setNext(head);
            head = n;
            count++;


    }
}



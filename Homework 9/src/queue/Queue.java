package queue;

/**
 * Created by Nikolay Yarlychenko on 02/12/2018
 */
public interface Queue {
    void enqueue(Object element);
    Object element();
    Object dequeue();
    int size();
    boolean isEmpty();
    void clear();
}

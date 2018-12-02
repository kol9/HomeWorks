package queue;

import com.sun.corba.se.spi.ior.ObjectKey;

/**
 * Created by Nikolay Yarlychenko on 02/12/2018
 */
public interface Queue {
    //      pre: element != null
    //      post: size' = size + 1, ∀i = 1..size: a[i]' = a[i], a[size'] = element
    void enqueue(Object element);

    //      pre: size > 0
    //      post: size' = size, ∀i = 1..size: a[i]' = a[i]
    Object element();

    //      pre: size > 0
    //      post: size' = size - 1, ∀i = 1..size: a[i]' = a[i]
    Object dequeue();

    //      post: size = size', ∀i = 1..size: a[i] = a[i]'
    int size();

    //      post: size' = size, ∀i = 1..size: a[i]' = a[i]
    boolean isEmpty();

    //      post: size' = 0
    void clear();

    Object[] toArray();
}

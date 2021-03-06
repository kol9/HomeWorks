package queue;

/**
 * Created by Nikolay Yarlychenko on 18/11/2018
 */
public class ArrayQueue {
    private int head = 0;
    private int tail = 0;
    private Object[] elements = new Object[5];

    //      pre: element != null
    //      post: size' = size + 1, ∀i = 1..size: a[i]' = a[i], a[size'] = element
    public void enqueue(Object element) {
        assert element != null;
        ensureCapacity(size() + 1);
        elements[tail] = element;
        tail = (tail + 1) % elements.length;
    }

    private void ensureCapacity(int capacity) {
        if (capacity < elements.length) {
            return;
        }
        Object[] newElements = new Object[2 * capacity];
        for (int i = 0; i < capacity - 1; i++) {
            newElements[i] = elements[head];
            head = (head + 1) % capacity;
        }
        elements = newElements;
        head = 0;
        tail = capacity - 1;
    }

    //      pre: size > 0
    //      post: size' = size, ∀i = 1..size: a[i]' = a[i]
    public Object element() {
        assert size() > 0;
        return elements[head];
    }

    //      pre: size > 0
    //      post: size' = size - 1, ∀i = 1..size: a[i]' = a[i]
    public Object dequeue() {
        assert size() > 0;
        Object element = elements[head];
        head = (head + 1) % elements.length;
        return element;
    }

    //      post: size = size', ∀i = 1..size: a[i] = a[i]'
    public int size() {
        return (tail - head + elements.length) % elements.length;
    }

    //      post: size' = size, ∀i = 1..size: a[i]' = a[i]
    public boolean isEmpty() {
        return head == tail;
    }

    //      post: size' = 0
    public void clear() {
        head = 0;
        tail = 0;
    }

    //      pre: element != null
    //      post: size' = size + 1, ∀i = 2..size: a[i]' = a[i], a[1] = element
    public void push(Object element) {
        assert element != null;
        ensureCapacity(size() + 1);
        head = (head - 1 + elements.length) % elements.length;
        elements[head] = element;
    }

    //      pre: size > 0
    //      post: size' = size, ∀i = 1..size: a[i]' = a[i]
    public Object peek() {
        assert size() > 0;
        return elements[(tail - 1 + elements.length) % elements.length];
    }

    //      pre: size > 0
    //      post: size' = size - 1, ∀i = 1..size - 1: a[i]' = a[i]
    public Object remove() {
        assert size() > 0;
        tail = (tail - 1 + elements.length) % elements.length;
        return elements[tail];
    }

}
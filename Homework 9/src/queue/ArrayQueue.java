package queue;

import java.util.Arrays;

/**
 * Created by Nikolay Yarlychenko on 18/11/2018
 */
public class ArrayQueue extends AbstractQueue {
    private int head = 0;
    private int tail = 0;
    private Object[] elements = new Object[5];

    public void enqueueImpl(Object element) {
        ensureCapacity(size + 1);
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

    public Object elementImpl() {
        return elements[head];
    }

    public Object dequeueImpl() {
        Object element = elements[head];
        head = (head + 1) % elements.length;
        return element;
    }

    public void clearImpl() {
        head = 0;
        tail = 0;
    }

    public Object[] toArrayImpl(Object[] newElements) {
        int newHead = head;
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[newHead];
            newHead = (newHead + 1) % elements.length;
        }
        return newElements;
    }
}
package queue;

/**
 * Created by Nikolay Yarlychenko on 18/11/2018
 */
public class ArrayQueue extends AbstractQueue {
    private int head = 0;
    private int tail = 0;
    private Object[] elements = new Object[5];

    public void enqueue(Object element) {
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

    public Object element() {
        return elements[head];
    }

    public Object dequeue() {
        assert size() > 0;
        Object element = elements[head];
        head = (head + 1) % elements.length;
        return element;
    }

    public int size() {
        return (elements.length - head + tail) % elements.length;
    }

    public boolean isEmpty() {
        return head == tail;
    }


    public void clear() {
        head = 0;
        tail = 0;
    }


    public Object[] toArray() {
        Object[] newElements = new Object[size()];

        int newHead = head;
        for(int i = 0; i < size(); i++) {
            newElements[i] = elements[newHead];
            newHead = (newHead + 1) % elements.length;
        }

        return newElements;
    }
}
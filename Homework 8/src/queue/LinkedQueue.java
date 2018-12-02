package queue;

/**
 * Created by Nikolay Yarlychenko on 27/11/2018
 */
public class LinkedQueue {
    private Node head;
    private Node tail;

    public void enqueueImpl(Object element) {
        Node newNode = tail;
        tail = new Node(element, null);
        if (size == 0) {
            head = tail;
        } else {
            newNode.next = tail;
        }
        size++;
    }

    public Object elementImpl() {
        return head.value;
    }

    public Object dequeueImpl() {
        size--;
        Object element = head.value;
        head = head.next;
        return element;
    }

    public int sizeImpl() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        head = tail;
    }


    public class Node {
        private Object value;
        private Node next;

        Node(Object value, Node next) {
            assert value != null;
            this.value = value;
            this.next = next;
        }
    }
}

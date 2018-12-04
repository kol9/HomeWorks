package queue;

/**
 * Created by Nikolay Yarlychenko on 27/11/2018
 */
public class LinkedQueue extends AbstractQueue {
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
    }

    public Object elementImpl() {
        return head.value;
    }

    public Object dequeueImpl() {
        Object element = head.value;
        head = head.next;
        return element;
    }

    public void clearImpl() {
        head = tail;
    }

    public Object[] toArrayImpl(Object[] newElements) {
        Node newHead = head;
        for (int i = 0; i < size; i++) {
            newElements[i] = newHead.value;
            newHead = newHead.next;
        }
        return newElements;
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

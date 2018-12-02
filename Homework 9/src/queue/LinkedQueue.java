package queue;

/**
 * Created by Nikolay Yarlychenko on 27/11/2018
 */
public class LinkedQueue extends AbstractQueue{
    private int size;
    private Node head;
    private Node tail;

    public void enqueue(Object element) {
        Node newNode = tail;
        tail = new Node(element, null);
        if (size == 0) {
            head = tail;
        } else {
            newNode.next = tail;
        }
        size++;
    }

    public Object element() {
        return head.value;
    }

    public Object dequeue() {
        assert size > 0;
        size--;
        Object element = head.value;
        head = head.next;
        return element;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        head = tail;
        size = 0;
    }

    public Object[] toArray() {
        Object[] newElements = new Object[size()];

        Node newHead = head;
        for(int i = 0; i < size; i++) {
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

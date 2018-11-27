/**
 * Created by Nikolay Yarlychenko on 27/11/2018
 */
public class LinkedQueue {
    private int size;
    private Node head;
    private Node tail;

    public void enqueue(Object element) {
        assert element != null;
        tail = new Node(element, tail);
        size++;
    }
    public Object element(){
        assert size > 0;
        size--;
        return head.value;
    }
    public Object dequeue(){
        assert size > 0;
        size--;
        Object result = head.value;
        head = head.next;
        return result;
    }

    public int size() {
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

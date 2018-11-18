/**
 * Created by Nikolay Yarlychenko on 18/11/2018
 */

public class ArrayQueueModule {

    private static int head = 0;
    private static int tail = 0;

    private static Object[] elements = new Object[5];


    public static void enqueue(Object element) {
        assert element != null;
        ensureCapacity(size() + 1);

        elements[tail] = element;
        tail = (tail + 1) % elements.length;
    }

    private static void ensureCapacity(int capacity) {
        if (capacity < elements.length) {
            return;
        }
        System.out.println("ENSURE");
        Object[] newElements = new Object[2 * capacity];
        int currentId = 0;
        if (tail < head) {
            for (int i = head; i < capacity; i++) {
                newElements[currentId++] = elements[i];
            }
            for (int i = tail; i < head; i++) {
                newElements[currentId++] = elements[i];
            }
        } else {
            for (int i = head; i < tail; i++) {
                newElements[currentId++] = elements[i];
            }
        }
        head = 0;
        tail = currentId;
        elements = newElements;
    }

    public static Object element() {
        assert size() > 0;
        return elements[head];
    }

    public static Object dequeue() {
        assert size() > 0;
        Object element = elements[head];
        head = (head + 1) % elements.length;
        return element;
    }


    public static int size() {
        if (head > tail) {
            return elements.length - head + tail;
        } else {
            return tail - head;
        }
    }

    public static boolean isEmpty() {
        return head == tail;
    }

    public static void clear() {
        head = 0;
        tail = 0;
    }
}

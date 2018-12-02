package queue;

import java.util.Queue;

/**
 * Created by Nikolay Yarlychenko on 27/11/2018
 */
abstract class AbstractQueue implements Queue {

    public int size() {
        return sizeImpl();
    }
    protected abstract int sizeImpl();

    public boolean isEmpty() {
        return size() == 0;
    }
    public void clear() {

    }

    public Object element() {
        assert size() > 0;
        return elementImpl();
    }

    protected abstract Object elementImpl();

    public boolean add(Object element) {
        assert element != null;
        addImpl(element);
        return false;
    }

    protected abstract void addImpl(Object element);

    public Object dequeue() {
        assert size() > 0;
        return dequeueImpl();
    }

    protected abstract Object dequeueImpl();
}

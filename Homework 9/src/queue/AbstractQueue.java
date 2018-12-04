package queue;

/**
 * Created by Nikolay Yarlychenko on 02/12/2018
 */
public abstract class AbstractQueue implements Queue {
    int size;

    public void enqueue(Object element) {
        assert element != null;
        enqueueImpl(element);
        size++;
    }

    abstract void enqueueImpl(Object element);

    public Object element() {
        assert size > 0;
        return elementImpl();
    }

    abstract Object elementImpl();

    public Object dequeue() {
        assert size > 0;
        size--;
        return dequeueImpl();
    }

    abstract Object dequeueImpl();


    public int size() {
        return size;
    }

    public void clear() {
        size = 0;
        clearImpl();
    }

    protected abstract void clearImpl();

    public boolean isEmpty() {
        return (size == 0);
    }

    public Object[] toArray() {
        Object[] newElements = new Object[size];
        return toArrayImpl(newElements);
    }

    abstract Object[] toArrayImpl(Object[] a);

}

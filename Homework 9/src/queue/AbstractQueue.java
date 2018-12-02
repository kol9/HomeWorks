package queue;

/**
 * Created by Nikolay Yarlychenko on 02/12/2018
 */
public abstract class AbstractQueue implements Queue{

    public void enqueue(Object element) {
        assert element != null;
    }

}

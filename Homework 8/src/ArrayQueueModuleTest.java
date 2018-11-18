/**
 * Created by Nikolay Yarlychenko on 18/11/2018
 */
public class ArrayQueueModuleTest {
    public static void fill() {
        for (int i = 0; i < 10; i++) {
            System.out.println(ArrayQueueModule.size());
            ArrayQueueModule.enqueue(i);
        }
    }

    public static void dump() {
        while (!ArrayQueueModule.isEmpty()) {
            System.out.println(
                    ArrayQueueModule.size() + " " +
                            ArrayQueueModule.element() + " " +
                            ArrayQueueModule.dequeue());
        }
    }

    public static void main(String[] args) {
        fill();
        dump();
    }
}

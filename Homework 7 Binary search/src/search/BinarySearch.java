package search;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikolay Yarlychenko on 10/11/2018
 */

public class BinarySearch {


    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        List<Integer> array = new ArrayList<>();
        for (int i = 1; i < args.length; i++) {
            array.add(Integer.parseInt(args[i]));
        }

        int left = 0, right = array.size() - 1;
        System.out.println(IterationBinarySearch(array, left, right, x));

    }

    public static int IterationBinarySearch(List<Integer> array, int left, int right, int x) {
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (array.get(mid) > x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static int RecursiveBinarySearch(List<Integer> array, int left, int right, int x) {
        if (left > right) {
            return left;
        }
        int mid = (left + right) >>> 1;
        if (array.get(mid) > x) {
            return RecursiveBinarySearch(array, left + 1, right, x);
        } else {
            return RecursiveBinarySearch(array, left, right - 1, x);
        }
    }
}

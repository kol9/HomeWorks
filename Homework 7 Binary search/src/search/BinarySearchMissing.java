package search;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikolay Yarlychenko on 13/11/2018
 */

public class BinarySearchMissing {
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        List<Integer> array = new ArrayList<>();
        for (int i = 1; i < args.length; i++) {
            array.add(Integer.parseInt(args[i]));
        }

        int left = 0, right = array.size() - 1;
        System.out.println(RecursiveBinarySearch(array, left, right, x));
    }

    private static int IterativeBinarySearch(List<Integer> array, int left, int right, int x) {
        // array is sorted by non-increasing
        // x >= -2147483648 && x <= 2147483647
        // left >= 0, right < array.size()
        // left <= right
        while (left <= right) {
            // left <= right
            int mid = (left + right) / 2;
            // left <= mid <= right
            // 0 <= mid < array.size()
            if (array.get(mid) > x) {
                // x to the right of mid
                // left <= mid
                left = mid + 1;
                // left > mid
            } else {
                // x to the left of mid
                // right >= mid
                right = mid - 1;
                // right' > mid
            }
        }
        // left > right
        if (left > array.size() - 1 || array.get(left) != x) {
            // x not found or array is empty
            return -(left + 1);
        } else {
            // x found
            return left;
            // ans >= 0 && ans < array.size()
        }
        // array' = array

    }

    private static int RecursiveBinarySearch(List<Integer> array, int left, int right, int x) {
        // array is sorted by non-increasing
        // x >= -2147483648 && x <= 2147483647
        // left >= 0, right < array.size()
        if (left > right) {
            if (left > array.size() - 1 || array.get(left) != x) {
                // x not found or array is empty
                return -(left + 1);
            } else {
                // x found
                return left;
            }
        }
        // left <= right
        int mid = (left + right) / 2;
        // left <= mid <= right
        // 0 <= mid < array.size()
        if (array.get(mid) > x) {
            // x to the right of mid
            return RecursiveBinarySearch(array, left + 1, right, x);
        } else {
            // x to the left of mid
            return RecursiveBinarySearch(array, left, right - 1, x);
        }
    }
}

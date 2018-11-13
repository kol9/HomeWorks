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

        while (left <= right) {
            int middle = (left + right) >>> 1;
            if (array.get(middle) > x) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        System.out.println(left);

    }

        private int RecursiveBinarySearch(List<Integer> array, int left, int right, int x) {
        if (left > right) {
            return left;
        }
        int middle = (left + right) >>> 1;
        if (array.get(middle) > x) {
            return RecursiveBinarySearch(array, left + 1, right, x);
        } else {
            return RecursiveBinarySearch(array, left + 1, right, x);
        }
    }
}

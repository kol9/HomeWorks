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

    public int RecursiveBinarySearch(int left, int right) {
        if (left > right) {
            return left;
        }
        int middle = (left + right) >>> 1;
        if (array.get(middle) > x) {
            return RecursiveBinarySearch(left + 1, right);
        } else {
            return RecursiveBinarySearch(left + 1, right);
        }
    }
}

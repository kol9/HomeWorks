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

        while (right - left > 1) {
            int middle = (left + right) / 2;
            if (array.get(middle) >= x) {
                left = middle;
            } else  {
                right = middle;
            }
        }
        System.out.println(left);
    }
}

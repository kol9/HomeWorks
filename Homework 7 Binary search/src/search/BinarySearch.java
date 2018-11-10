package search;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikolay Yarlychenko on 10/11/2018
 */
public class BinarySearch {
    public static void main(String[] args) {

        long x = Long.parseLong(args[0]);
        List<Long> array = new ArrayList<>();
        for (int i = 1; i < args.length; i++) {
            array.add(Long.parseLong(args[i]));
        }


        int left = 0, right = array.size() - 1;
        if (array.size() == 0) {
            System.out.println(0);

        } else {
            while (right - left > 2) {
                int middle = (left + right) / 2;
                if (array.get(middle) > x) {
                    left = middle;
                } else {
                    right = middle;
                }
            }

           // System.out.println(left + " " + right);

            boolean check = false;
            for(int i = left; i <= right; i++) {
                if(array.get(i) <= x) {
                    System.out.println(i);
                    check = true;
                    break;
                }
            }
            if(!check ) {
                System.out.println(array.size());
            }

        }
    }
}

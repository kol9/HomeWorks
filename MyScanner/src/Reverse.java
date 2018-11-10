import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import java.util.Scanner;
import java.util.ArrayList;

public class Reverse {

    public static void main(String[] args) {
        FastScanner scan = new FastScanner();
        //Scanner scan = new Scanner(System.in);
        ArrayList<String> str = new ArrayList<>();

        while (scan.hasNextLine) {
            String s = scan.nextLine();
            //  System.out.println(s);
            str.add(s);
        }


        for (int i = str.size() - 1; i >= 0; i--) {

            String[] s = str.get(i).split("");


            for (int j = s.length - 1; j >= 0; j--) {

                if (s[j].length() > 0) {

                    System.out.print(s[j]);
                }
            }
        }
    }

}
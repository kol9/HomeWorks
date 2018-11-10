import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Test {

    public static void main(String[] args) {


        long startTime = 0;
        File f = new File("in.txt");

        try {


            FastScanner fs = new FastScanner(System.in);
            startTime = System.currentTimeMillis();
            String str = fs.nextLine();
            System.out.println(str);
/* String str1 = fs.nextLine();
System.out.println(str1);

String str2 = fs.nextLine();
System.out.println(str2);*/


        } catch (Exception e) {
            e.printStackTrace();
        }

        long timeSpent = System.currentTimeMillis() - startTime;
        System.out.println("программа выполнялась " + timeSpent + " миллисекунд");
    }

}
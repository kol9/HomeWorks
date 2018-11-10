import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class SumFile {
    public static void main(String[] args) {
        try {
            int sum = 0;
            File in = new File(args[0]);
            FileWriter out = new FileWriter(args[1]);

            in.createNewFile();

            try (Scanner scan = new Scanner(in)) {

                while (scan.hasNext()) {
                    String s = scan.next();
                    String[] StringArr = s.split(" - ");
                    try {
                        for (String num : StringArr) {

                            sum += Integer.parseInt(num);
                        }
                    } catch (NumberFormatException e) {
                        System.out.print("You input a wrong number\n");
                    }
                }
            }

            out.write(sum + "\n");
            out.flush();
        } catch (Exception e) {
            System.out.println("Wrong input or output file name");
        }
    }
}

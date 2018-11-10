import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class SumHexFile {
    public static void main(String[] args) {
        try {
            int sum = 0;
            File in = new File(args[0]);
            try (FileWriter out = new FileWriter(args[1])) {


                in.createNewFile();

                try (Scanner scan = new Scanner(in)) {

                    while (scan.hasNext()) {
                        String s = scan.next();
//                    String[] StringArr = s.split(" ");
                        String[] StringArr = new String[]{s};
                        try {
                            for (String num : StringArr) {
                                num = num.toLowerCase();
                                if (num.startsWith("0x")) {
                                    num = num.replace("0x", "");
                                    long x = Long.parseLong(num, 16);
                                    sum += x;
                                } else {
                                    sum += Integer.parseInt(num, 10);
                                }
                            }
                        } catch (NumberFormatException e) {
                            System.out.print("You input a wrong number\n");
                        }
                    }
                }

                out.write(sum + "\n");
                //out.flush();
            }
        } catch (Exception e) {
            System.out.println("Wrong input or output file name");
        }
    }
}

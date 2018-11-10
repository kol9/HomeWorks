import java.util.Scanner;

public class SumFile {
    public static void main(String[] args) {
        Scanner scan = new Scanner("input.txt");
        int sum = 0;

        while (scan.hasNext()) {
            String s = scan.next();
            String stringArr[] = s.split("[^\\\\d-]");
            for (String goodNum : stringArr) {
                sum += Integer.parseInt(goodNum);
            }
        }
        System.out.println(sum);
    }
}

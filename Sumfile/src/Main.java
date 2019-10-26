import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner("System.in");
        int sum = 0;

        while (scan.hasNext()) {
            String s = scan.nextLine();
            String stringArr[] = s.split("[^\\\\d-]");
            for (String goodNum : stringArr) {
                try {
                    sum += Integer.parseInt(goodNum);
                } catch (NumberFormatException e) {
                    System.out.println("1231");

                }
            }
        }
        System.out.println(sum);
    }
}

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReverseSum {

    public static void main(String[] args) throws IOException {

        FastScanner scan = new FastScanner(System.in);

        List<List<Integer>> arrayInt = new ArrayList<>();

        int maxLength = 0;

        while (scan.hasNextLine()) {
            try {
                arrayInt.add(scan.nextIntLineArrayList());
                maxLength = Math.max(maxLength, arrayInt.get(arrayInt.size() - 1).size());
            } catch (NullPointerException e) {
                arrayInt.remove(arrayInt.size() - 1);
            } catch (NumberFormatException e1) {
                //e1.printStackTrace();
            }
        }
        scan.close();

        int sumColumn[] = new int[maxLength];
        int sumRow[] = new int[arrayInt.size()];

        for (int i = 0; i < arrayInt.size(); i++) {
            for (int j = 0; j < arrayInt.get(i).size(); j++) {
                sumRow[i] += arrayInt.get(i).get(j);
                sumColumn[j] += arrayInt.get(i).get(j);
            }
        }

        for (int i = 0; i < arrayInt.size(); i++) {
            for (int j = 0; j < arrayInt.get(i).size(); j++) {
                int answer = sumColumn[j] + sumRow[i] - arrayInt.get(i).get(j);
                System.out.print(answer + " ");
            }
            System.out.println();
        }
    }
}
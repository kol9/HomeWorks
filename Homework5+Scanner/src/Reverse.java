import java.io.IOException;
import java.util.ArrayList;

public class Reverse {

    public static void main(String[] args) throws IOException {


        CrutchReader scan = new CrutchReader();
        ArrayList<String> arr = new ArrayList<>();


//        while (scan.hasNext()) {
            try {
                arr.add(scan.read());
            } catch (Exception e) {
                //e.printStackTrace();
            }
//        }
        // scan.close();

        for (int i = arr.size() - 1; i >= 0; i--) {
            System.out.print(arr.get(i));
        }
    }
}






























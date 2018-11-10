import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

class FastReader {
    private BufferedReader br;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public boolean hasNextLine() throws IOException {
        return br.ready();
    }

    public String nextLine() throws IOException {
        return br.readLine();
    }


    public ArrayList<Integer> nextIntArrayList() throws NumberFormatException, IOException {
        ArrayList<Integer> numbers = new ArrayList<>();
        String x = br.readLine();
        if (x == null) {
            return null;
        }

        for (String numStr : x.split("[^\\d-]")) {
            if (numStr.length() == 0) {
                continue;
            }
            try {
                numbers.add(Integer.parseInt(numStr));
            } catch (NumberFormatException e) {
                //e.printStackTrace();
            }
        }
        return numbers;
    }

    public void close() throws IOException {
        br.close();
    }
}

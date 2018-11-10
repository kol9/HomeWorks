import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class FastScanner {
    private StringTokenizer st;
    private BufferedReader br;
    private boolean canRead;

    FastScanner(InputStream s) {
        br = new BufferedReader(new InputStreamReader(s));
        canRead = true;
    }

    public String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    public boolean hasNext() throws IOException {
        return canRead || (st != null && st.hasMoreTokens());
    }

    public int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    public long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    public double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    public String nextLine() throws IOException {
        return br.readLine();
    }

    public List<Integer> nextIntLineArrayList() throws IOException, NumberFormatException {
        List<Integer> numbers = new ArrayList<>();
        String x = nextLine();

        if (x == null) {
            canRead = false;
            return null;
        }

        for (String numStr : x.split("[^\\d-]")) {
            if (numStr.length() != 0) {
                numbers.add(Integer.parseInt(numStr));
            }
        }
        return numbers;
    }

    boolean hasNextLine() {
        return canRead;
    }

    public void close() throws IOException {
        br.close();
    }
}
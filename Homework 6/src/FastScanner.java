import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class FastScanner implements AutoCloseable {
    private StringTokenizer st;
    private BufferedReader br;

    FastScanner(InputStream s) {
        br = new BufferedReader(new InputStreamReader(s));
    }

    FastScanner(File s, Charset x) throws FileNotFoundException {
        br = new BufferedReader(new InputStreamReader(new FileInputStream(s), x));
    }

    public String next() throws IOException {
        while (hasNext()) {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    public boolean hasNext() throws IOException {
        return (st != null && st.hasMoreTokens());
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

    public List<Integer> nextIntLineList() throws IOException, NumberFormatException {
        List<Integer> numbers = new ArrayList<>();
        String x = nextLine();

        if (x == null) {
            return null;
        }

        for (String numStr : x.split("[^\\d-]")) {
            if (numStr.length() != 0) {
                numbers.add(Integer.parseInt(numStr));
            }
        }
        return numbers;
    }

    public List<String> nextWordLine() throws IOException {
        String line = nextLine();
        return new ArrayList<>(Arrays.asList(line.toLowerCase().split("[^\\p{L}\\p{Pd}']")));
    }

    boolean hasNextLine() throws IOException {
        return br.ready();
    }

    @Override
    public void close() throws Exception {
        br.close();
    }
}
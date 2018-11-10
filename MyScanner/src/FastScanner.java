
import java.io.InputStream;

public class FastScanner {

    private InputStream is;
    public boolean hasNextLine = true;

    public FastScanner(InputStream is) {
        this.is = is;
    }

    public String nextLine() {
        hasNextLine = true;
        String res = "";
        try {

            while (true) {
                byte b = (byte) is.read();
                if (b == -1) {
                    is.close();
                    hasNextLine = false;
                    break;
                }
                if (b == 10) {
                    res += '\n';
                    continue;
                }
                if (String.valueOf(b).equals(System.getProperty("line.separator"))) {
                    return res;

                } else
                    res += (char) b;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

}

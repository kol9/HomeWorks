import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class FastScanner implements AutoCloseable {
    private BufferedReader br;

    FastScanner(File file) throws FileNotFoundException {
        this.br = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
    }

    String nextLine() throws IOException {
        return this.br.readLine();
    }

    boolean hasNextLine() throws IOException {
        return this.br.ready();
    }

    public void close() throws IOException {
        this.br.close();
    }
}
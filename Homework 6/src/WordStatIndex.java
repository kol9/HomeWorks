import java.io.File;
import java.io.FileWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.util.*;

public class WordStatIndex {


    public static void main(String args[]) {
        //final Charset encoding = StandardCharsets.UTF_8;

        Map<String, ArrayList<Integer>> map = new LinkedHashMap<>();

        try (FastScanner scan = new FastScanner(new File(args[0]), StandardCharsets.UTF_8)) {
            int wordId = 1;
            while (scan.hasNextLine()) {

                List<String> words;
                words = scan.nextWordLine();

                for (String word : words) {
                    if (!word.isEmpty()) {
                        if (!map.containsKey(word)) {
                            map.put(word, new ArrayList<>());
                        }
                        map.get(word).add(wordId++);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        try (FileWriter out = new FileWriter(args[1])) {

            Set<Map.Entry<String, ArrayList<Integer>>> set = map.entrySet();

            for (Map.Entry<String, ArrayList<Integer>> current : set) {
                out.write(current.getKey() + " " + current.getValue().size());
                for (int id : current.getValue()) {
                    out.write(" " + id);
                }
                out.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
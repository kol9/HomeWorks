import javafx.util.Pair;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class WordStatLineIndex {
    public static void main(String args[]) {

        Map<String, List<Pair<Integer, Integer>>> map = new TreeMap<>();
        try (FastScanner scan = new FastScanner(new File(args[0]), StandardCharsets.UTF_8)) {

            int wordId = 1;
            int lineId = 1;
            while (scan.hasNextLine()) {
                List<String> words = scan.nextWordLine();
                for (String word : words) {
                    if (!word.isEmpty()) {
                        if (!map.containsKey(word)) {
                            map.put(word, new ArrayList<>());
                        }
                        map.get(word).add(new Pair<>(lineId, wordId++));
                    }
                }
                lineId++;
                wordId = 1;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        try (FileWriter out = new FileWriter(args[1])) {
            Set<Map.Entry<String, List<Pair<Integer, Integer>>>> set = map.entrySet();

            for (Map.Entry<String, List<Pair<Integer, Integer>>> current : set) {
                out.write(current.getKey() + " " + current.getValue().size());
                for (Pair<Integer, Integer> id : current.getValue()) {
                    out.write(" " + id.getKey() + ":" + id.getValue());
                }
                out.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
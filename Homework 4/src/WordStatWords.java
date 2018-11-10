import java.io.*;
import java.util.TreeMap;
import java.util.Map;
import java.util.Set;


public class WordStatWords {
    public static void main(String[] args) {

        try {
            File in = new File(args[0]);
            in.createNewFile();
            try (FileWriter out = new FileWriter(args[1])) {

                Map<String, Integer> map = new TreeMap<>();

                try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(in), "utf8"))) {

                    String line;
                    while ((line = reader.readLine()) != null) {

                        String[] goodLine = line.toLowerCase().split("[/^]|[^\\p{L}^\\p{Pd}']");

                        for (String curString : goodLine) {
                            if (curString.length() > 0) {
                                System.out.println(curString);
                                if (map.containsKey(curString)) {
                                    map.put(curString, map.get(curString) + 1);
                                } else {
                                    map.put(curString, 1);
                                }
                            }
                        }
                    }
                }

                Set<Map.Entry<String, Integer>> set = map.entrySet();

                for (Map.Entry<String, Integer> current : set) {
                    out.write(current.getKey() + " " + current.getValue() + '\n');
                }
            }
        } catch (IOException e) {
            System.out.println("Wrong input filename");
        }

    }

}



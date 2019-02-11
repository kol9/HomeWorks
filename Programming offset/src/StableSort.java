import java.io.*;
import java.util.*;

/**
 * Created by Nikolay Yarlychenko on 25/12/2018
 */
public class StableSort {
    private static boolean isAppend = false;

    public static void main(String[] args) {
        try {
            String fileName = args[0];
            try (FastScanner in = new FastScanner(new File(fileName))) {
                Map<Integer, ArrayList<String>> mp = new TreeMap<>();
                while (in.hasNextLine()) {
                    String s = in.nextLine();
                    if (s.isEmpty()) continue;
                    String[] arr = s.split(" ");
                    String command = arr[0];
                    switch (command) {
                        case "add":
                            try {
                                if (!mp.containsKey(Integer.parseInt(arr[1]))) {
                                    mp.put(Integer.parseInt(arr[1]), new ArrayList<>());
                                }
                                mp.get(Integer.parseInt(arr[1])).add(arr[2]);
                            } catch (NumberFormatException e) {
                                System.out.println("Wrong index number");
                            } catch (ArrayIndexOutOfBoundsException e) {
                                System.out.println("Expected more arguments");
                            }
                            break;
                        case "print":
                            try {
                                Print(mp, arr[1]);
                            } catch (ArrayIndexOutOfBoundsException e) {
                                System.out.println("Expected more arguments");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            isAppend = true;

                            break;
                        case "remove":
                            try {
                                mp.remove(Integer.parseInt(arr[1]));
                            } catch (ArrayIndexOutOfBoundsException e) {
                                System.out.println("Expected more arguments");
                            }
                            break;
                        default:
                            System.out.println("Wrong command name");
                            System.exit(0);
                    }
                }
            } catch (IOException e) {
                System.out.println("Input file does not exist !!!");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Arguments are clear");
            System.exit(0);
        }

    }

    private static void Print(Map<Integer, ArrayList<String>> mp, String s) throws IOException {
        try (FileWriter out = new FileWriter(new File(s), isAppend)) {
            for (Map.Entry entry : mp.entrySet()) {
                ArrayList newArr = (ArrayList) entry.getValue();
                for (Object arg : newArr) {
                    out.write(entry.getKey() + " " + arg + "\n");
                }
            }
            out.write("\n");
        }
    }
}

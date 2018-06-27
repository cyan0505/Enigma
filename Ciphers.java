import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Ciphers {
    static String alphabet = " abcdefghijklmnopqrstuvwxyz ";
    static String result = "";

    public static String atbash(ArrayList<String> lines) {

        for (String word : lines) {
            for (char c : word.toCharArray()) {
                if (alphabet.indexOf(c) == -1) {
                    result += c;
                } else {
                    int index = alphabet.indexOf(c) + 1;
                    result += alphabet.charAt(alphabet.length() - index);
                }
            }
            result += "\n";
        }
        return result;
    }

    public static String simple(ArrayList<String> lines, String mode, String key) {

        LinkedHashSet<String> newAlphabet = createNewAlphabet(key);
        if (mode.equals("-e")) {
            result = encript(newAlphabet, lines);
        } else if (mode.equals("-d")) {
            result = decript(newAlphabet, lines);
        }
        return result;

    }

    public static LinkedHashSet<String> createNewAlphabet(String key) {

        LinkedHashSet<String> newAlphabet = new LinkedHashSet<String>();
        if (key.length() > 0) {
            for (String c : Arrays.asList(key.split(""))) {
                newAlphabet.add(c);
            }
            newAlphabet.addAll(Arrays.asList(alphabet.split("")));
            newAlphabet.remove(" ");
        } else {
            newAlphabet.addAll(Arrays.asList("qwertyuioplkjhgfdsazxcvbnm".split("")));
        }
        return newAlphabet;
    }

    public static String encript(LinkedHashSet<String> newAlphabet, ArrayList<String> lines) {

        for (String word : lines) {
            for (String c : Arrays.asList(word.split(""))) {
                if(c.equals(" ") || alphabet.indexOf(c) < 0) {
                    result += c;
                } else {
                    int index = alphabet.indexOf(c) -1 ;
                    String[] list = newAlphabet.toArray(new String[26]);
                    result += list[index];
                }
            }
            result += "\n";
        }
        return result;
    }

    public static String decript(LinkedHashSet<String> newAlphabet, ArrayList<String> lines) {

        for (String word : lines) {
            for (String c : Arrays.asList(word.split(""))) {
                if (c.equals(" ") || alphabet.indexOf(c) < 0) {
                    result += c;
                } else {
                    ArrayList<String> listOfNewLetters = new ArrayList<String>(newAlphabet);
                    int indexOfLetter = listOfNewLetters.indexOf(c);
                    result += alphabet.trim().charAt(indexOfLetter);
                }
            }
            result += "\n";
        }
        return result;
    }
}
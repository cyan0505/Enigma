import java.util.*;
import java.io.*;

public class Homophonic {
    static String alphabet = "abcdefghijklmnopqrstuvwxyz ";
    static List<String> homophonicAlphabet = Arrays.asList("d9", "x", "s", "f", "z721", "e", "h", "c", "v3", "i", "t",
            "p", "g", "a5", "q0", "l", "k", "j", "r4", "u6", "o", "w", "m", "y", "b", "n", " ");
    static String result = "";

    public static String cipherHomophonic(ArrayList<String> text, String mode) {
        if (mode.equals("-e")) {
            result = encription(text);
        } else if (mode.equals("-d")) {
            result = decription(text);
        }
        return result;
    }

    public static String encription(ArrayList<String> text) {
        Random random = new Random();
        for (String line : text) {
            for (char c : line.toCharArray()) {
                Integer indexAlpahabet = alphabet.indexOf(c);
                if (!indexAlpahabet.equals(-1)) {
                    String element = homophonicAlphabet.get(indexAlpahabet);
                    Integer indexElement = random.nextInt(element.length());
                    result += element.charAt(indexElement);
                } else {
                    result += c;
                }
            }
            result += "\n";
        }
        return result;
    }

    public static String decription(ArrayList<String> text) {
        for (String line : text) {
            for (char c : line.toCharArray()) {
                for (String element : homophonicAlphabet) {
                    if (element.indexOf(c) != -1) {
                        Integer indexHomophonicAlphabet = homophonicAlphabet.indexOf(element);
                        result += alphabet.charAt(indexHomophonicAlphabet);
                    } 
                }
            }
            result += "\n";
        }
        return result;
    }
}
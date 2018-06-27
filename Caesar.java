import java.util.*;
import java.io.*;

public class Caesar {
    static String alphabet = "abcdefghijklmnopqrstuvwxyz ";
    static String caesarAlphabet = "xyzabcdefghijklmnopqrstuvw ";
    static String result = "";

    public static String cipherCaesar(ArrayList<String> text, String mode) {
        if (mode.equals("-e")) {
            result = encription(text, alphabet, caesarAlphabet);
        } else if (mode.equals("-d")) {
            result = encription(text, caesarAlphabet, alphabet);
        }
        return result;
    }

    public static String encription(ArrayList<String> text, String sourceAlphabet, String targetAlphabet) {
        for (String line : text) {
            for (char c : line.toCharArray()) {
                Integer index = sourceAlphabet.indexOf(c);
                if (!index.equals(-1)) {
                    result += targetAlphabet.charAt(index);
                } else {
                    result += c;
                }
            }
            result += "\n";
        }
        return result;
    }
}
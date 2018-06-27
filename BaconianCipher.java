import java.util.ArrayList;
import java.util.Arrays;

public class BaconianCipher {
    public static String DecodedResult(String byteChar, int alphabetIndex, String result, String alphabet) {

        for (String element : Arrays.asList(byteChar.split(" "))) {
            for (Integer i = 4, j = 0; !(i < 0); i--, j++) {

                if (element.charAt(i) == '1') {
                    alphabetIndex += Math.pow(2, j);
                } else {
                    alphabetIndex += 0;
                }
            }
            result += alphabet.charAt(alphabetIndex);
            alphabetIndex = 0;
        }
        return result;
    }

    public static String Decode(ArrayList<String> lines) {

        String byteChar = "";
        for (String element : lines) {
            for (String item : element.split(" ")) {
                for (Character character : item.toCharArray()) {

                    if (character.equals('a')) {
                        byteChar += 0;
                    } else if (character.equals('b')) {
                        byteChar += 1;
                    } else {
                        System.out.println("Wrong letters in file!");
                        System.exit(0);
                    }
                }
                byteChar += " ";
            }
            byteChar += " ";

        }
        return byteChar;
    }

    public static StringBuilder Encode(int alphabetIndex, String alphabet, ArrayList<String> lines) {

        StringBuilder codedWord = new StringBuilder();

        for (String element : lines) {
            for (char c : element.toCharArray()) {
                if (alphabet.indexOf(c) == -1) {
                    element.replace(c, ' ');
                } else {
                    alphabetIndex += alphabet.indexOf(c);
                    for (int i = 5; i > 0; i--) {

                        if (alphabetIndex % 2 == 0) {
                            codedWord.append('a');
                            alphabetIndex /= 2;
                        } else {
                            codedWord.append('b');
                            alphabetIndex = (alphabetIndex - 1) / 2;
                        }
                    }
                    codedWord.append(' ');
                    alphabetIndex = 0;
                }
            }
        }

        return codedWord;
    }

    public static String ReverseString(StringBuilder codedWord, String result) {
        StringBuilder tempString = new StringBuilder();
        for (String element : Arrays.asList(codedWord.toString().split(" "))) {
            tempString.append(element);
            tempString.reverse();
            result += tempString.toString() + " ";
            tempString.delete(0, 5);
        }
        return result;
    }

    public static String baconian(ArrayList<String> lines, String mode) {

        String alphabet = " abcdefghijklmnopqrstuvwxyz";
        String result = "";
        int alphabetIndex = 0;

        if (mode.equals("-d")) {
            String byteChar = Decode(lines);
            result = DecodedResult(byteChar, alphabetIndex, result, alphabet);

        } else if (mode.equals("-e")) {

            StringBuilder codedWord = Encode(alphabetIndex, alphabet, lines);
            result = ReverseString(codedWord, result);

        }
        return result;
    }
}

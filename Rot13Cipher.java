import java.util.ArrayList;

public class Rot13Cipher {

    public static String rot13(ArrayList<String> lines) {

        String alphabet = " abcdefghijklmnopqrstuvwxyz";
        String code = " nopqrstuvwxyzabcdefghijklm";
        Integer index = null;
        String encriptedWord = "";

        for (String element : lines) {

            for (char character : element.toCharArray()){
                if (alphabet.indexOf(character) == -1) {
                    element.replace(character, ' ');
                } else {
                    index = alphabet.indexOf(character);
                    encriptedWord += code.charAt(index);
                }
            }
            encriptedWord += "\n";
        }
        return encriptedWord;
    }    
}
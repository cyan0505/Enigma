import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<String> options = Arrays.asList("Atbash", "Baconian", "Caesar", "Homophonic", "ROT13", "Simple");
        if (args[0].equals("-l") && args.length == 1) {
            for (String option : options) {
                System.out.println((options.indexOf(option) + 1) + ". " + option);
            }
        }

        if (args.length > 1) {

            Scanner text = new Scanner(System.in);
            ArrayList<String> lines = new ArrayList<String>();
            String cipher = args[1].toLowerCase();
            String mode = args[0];
            String result = "";
            String key = "";
            if (args.length > 2) {
                key = args[2];
            }
            while (text.hasNextLine())
                lines.add(text.nextLine());

            switch (cipher) {

            case "atbash":
                result = Ciphers.atbash(lines);
                break;

            case "simple":
                result = Ciphers.simple(lines, mode, key);
                break;

            case "rot13":
                result = Rot13Cipher.rot13(lines);
                break;

            case "baconian":
                result = BaconianCipher.baconian(lines, mode);
                break;

            case "caesar":
                result = Caesar.cipherCaesar(lines, mode);
                break;

            case "homophonic":
                result = Homophonic.cipherHomophonic(lines, mode);
                break;

            default:
                System.out.print("There is no such option!");
            }
            System.out.println(result);
            try {
                PrintWriter writer = new PrintWriter("newtext.txt", "UTF-8");
                writer.print(result);
                writer.close();
            } catch (Exception e) {
                System.exit(0);
            }
            System.out.println("Your encripted/decripted text is saved in newtext.txt");

        }
    }
}
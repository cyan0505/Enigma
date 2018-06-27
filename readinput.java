import java.util.Scanner;

public class readinput {



    public static void read_from_file(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Printing the file passed in:");
        
        while(sc.hasNextLine()) System.out.println(sc.nextLine());
    }
}
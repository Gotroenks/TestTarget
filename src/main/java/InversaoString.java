import java.util.Scanner;

public class InversaoString {
    public static void main(String[] args) {

        String word = new Scanner(System.in).nextLine();
        String newWord = "";

        for(int i = word.length() - 1; i >= 0; i--)
            newWord += word.charAt(i);

        System.out.println("Palavra inicial: " + word + "\nPalavra invertida: " + newWord);
    }
}

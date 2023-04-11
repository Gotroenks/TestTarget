import java.util.Scanner;
public class Fibonacci {

    public static void main(String[] args) {

        //Sequencia Fibonacci
        int entryValue = new Scanner(System.in).nextInt();
        boolean equalsValue = true;
        int firstValue = 0;
        int secondValue = 1;

        for (int i  = 0; i < entryValue; i++) {
            int finalValue = firstValue + secondValue;
            firstValue = secondValue;
            secondValue = finalValue;

            if(finalValue == entryValue) {
                equalsValue = false;
                System.out.println("Pertence a sequencia de Fibonacci");
                break;
            }
        }
        if(equalsValue)
            System.out.println("Não pertence a sequencia de Fibonacci");
    }
}
import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerUtils{
    private static Scanner scanner = new Scanner(System.in);

    /* 1‚©‚çˆø”‚É‚ ‚é®”‚Ü‚Å‚Ì“ü—Í‚ğó‚¯•t‚¯‚é */
    public static int inputInt(int upperNumber){
        System.out.print("“ü—Í‚µ‚Ä‚­‚¾‚³‚¢: ");
        int inputNumber = 0;
        while(!(1 <= inputNumber && inputNumber <= upperNumber)){
            try{
                inputNumber = scanner.nextInt();
            } catch(InputMismatchException e){
                e.printStackTrace();
            }
        }
        return inputNumber;
    }
}
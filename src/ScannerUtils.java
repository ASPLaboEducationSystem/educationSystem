import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerUtils{
    private static Scanner scanner = new Scanner(System.in);

    /* 1から引数にある整数までの入力を受け付ける */
    public static int inputInt(int upperNumber){
        System.out.print("入力してください: ");
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
import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerUtils{
    private static Scanner scanner = new Scanner(System.in);

    /* 1��������ɂ��鐮���܂ł̓��͂��󂯕t���� */
    public static int inputInt(int upperNumber){
        System.out.print("���͂��Ă�������: ");
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
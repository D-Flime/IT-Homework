import java.util.Scanner;

/* 1.20 Дано натуральное число n. Проверить, не является ли палиндромом десятичная запись
цифр этого числа.*/
// Автор: Давлетшин Д. Р.

public class Main {

    public static boolean isPalindrome(int n){
        int length = (int)(Math.log10(n)+1);

        int posL, posR;
        for (int i = 0; i < (int)(length / 2); i++){
            posL = (int)((n % Math.pow(10, length - i)) / Math.pow(10, length - i - 1));
            if (i==0){
                posR =  (int)(n % Math.pow(10, i+1));
            } else {
                posR =  (int)((n % Math.pow(10, i+1)) / Math.pow(10, i));
            }
            if (posL != posR){
                return false;
            }
        }
        return true;
    }

    public static void main( String[] args ) {
        Scanner in = new Scanner(System.in);

        int n;

        System.out.print("n = ");
        n = in.nextInt();
        isPalindrome(n);
        if (isPalindrome(n)){
            System.out.println("Это палиндром");
        } else {
            System.out.println("Это не палиндром");
        }
    }
}

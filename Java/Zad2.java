import java.util.Scanner;

public class Zad1 {

    public static boolean isPalindrom(int n){
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
        isPalindrom(n);
        if (isPalindrom(n)){
            System.out.print("Это палиндром");
        } else {
            System.out.print("Это не палиндром");
        }
    }
}
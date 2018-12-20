import java.util.Scanner;

public class Zad1 {

    //Перевод в другую систему счисления
    public static int numbToNumb(int numb, int m){
        String n = Integer.toString(numb, m);
        return Integer.parseInt(n);
    }

    public static void main( String[] args ) {
        Scanner in = new Scanner(System.in);
        
        int cifra, n, m;
        int max = 0;
        int min = 1000000;
        
        System.out.print("n = ");
        n = in.nextInt();
        System.out.print("m = ");
        m = in.nextInt();
        n = numbToNumb(n, m);
        int ost;
        
        while (n != 0){
            ost = n % 10;
            n = n / 10;
            if (ost > max){
                max = ost;
            }
            if (ost < min){
                min = ost;
            }
        }
        System.out.print("max = "); System.out.println(max);
        System.out.print("min = "); System.out.println(min);
    }
}

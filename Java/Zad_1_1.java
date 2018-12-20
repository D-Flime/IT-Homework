import java.util.Scanner;

/* 1.5 Дано натуральные числа n, m. Найти максимальную и минимальную цифры числа n в
записи этого числа в m-ичной системе счисления*/
// Автор: Давлетшин Д. Р.

public class Main {

    public static void main( String[] args ) {
        Scanner in = new Scanner(System.in);

        int n, m;
        int max = 0;
        int min = 1000000;

        System.out.print("n = ");
        n = in.nextInt();
        System.out.print("m = ");
        m = in.nextInt();

        int ost;

        while (n != 0){
            ost = n % m;
            n = n / m;
            if (ost > max){
                max = ost;
            }
            if (ost < min){
                min = ost;
            }
        }

        switch(min){
            case 10:
                System.out.print("min = ");
                System.out.println('A');
                break;
            case 11:
                System.out.print("min = ");
                System.out.println('B');
                break;
            case 12:
                System.out.print("min = ");
                System.out.println('C');
                break;
            case 13:
                System.out.print("min = ");
                System.out.println('D');
                break;
            case 14:
                System.out.print("min = ");
                System.out.println('E');
                break;
            case 15:
                System.out.print("min = ");
                System.out.println('F');
                break;
            default:
                System.out.print("min = ");
                System.out.println(min); break;
        }
        switch(max) {
            case 10:
                System.out.print("min = ");
                System.out.println('A');
                break;
            case 11:
                System.out.print("min = ");
                System.out.println('B');
                break;
            case 12:
                System.out.print("min = ");
                System.out.println('C');
                break;
            case 13:
                System.out.print("min = ");
                System.out.println('D');
                break;
            case 14:
                System.out.print("min = ");
                System.out.println('E');
                break;
            case 15:
                System.out.print("min = ");
                System.out.println('F');
                break;
            default:
                System.out.print("max = ");
                System.out.println(max); break;
        }
    }
}

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/* 2.20 Дана целочисленная квадратная матрица. Повернуть матрицу относительно центра на
180 градусов.*/
// Автор: Давлетшин Д. Р.

public class MyClass {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        
        int i1, j1;
        i1 = 0; j1 = 0;
        final int n = 3;
        int[][] arr = new int[n][n];
        int[][] arr1 = new int[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                arr[i][j] = ThreadLocalRandom.current().nextInt(0, 9);
                System.out.print(arr[i][j]);
                System.out.print("  ");
            }
            System.out.println();
        }
        System.out.println(); System.out.println();
        for (int i = n-1; i >= 0; i--){
            for (int j = n-1; j >= 0; j--){
                arr1[i1][j1] = arr[i][j];
                System.out.print(arr[i][j]);
                System.out.print("  ");
                j1++;
            }
            i1++;
            j1 = 0;
            System.out.println();
        }
    }
}

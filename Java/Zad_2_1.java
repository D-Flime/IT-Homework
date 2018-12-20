import java.util.Scanner;
import java.util.Random;

/* 2.5 Линейный массив заполняется случайными вещественными числами из диапазона
[-10.0; +10.0); размер массива вводится с клавиатуры. Найти индексы таких двух элементов
массива, сумма элементов между которыми максимальна.*/
// Автор: Давлетшин Д. Р.

public class Main {

    public static void main( String[] args ) {
        Scanner in = new Scanner(System.in);
        Random random = new Random();

        int n;
        int maxi = 0;
        int maxj = 0;
        double k;
        double max = 0;
        System.out.print("Длина массива = "); n = in.nextInt();
        double[] arr = new double[n];
        for (byte i=0; i < n; i++){
            k = -10 + random.nextDouble()*20;
            System.out.println(k);
            arr[i] = k;
        }
        for (int i = 0; i < n; i++){
            for (int j = i+1; j < n; j++){
                if (max < arr[i]+arr[j]){
                    max = arr[i]+arr[j];
                    maxi = i;
                    maxj = j;
                }
            }
        }
        System.out.println("Индексы элементов массива с максимальной суммой:");
        System.out.println(maxi);
        System.out.println(maxj);
    }
}

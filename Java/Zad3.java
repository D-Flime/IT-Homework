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

        int n, k;
        System.out.print("Длина массива = "); n = in.nextInt();
        double[] arr = new double[n];
        for (byte i=0; i < n; i++){
            double min = -10;
            double max = 200;
            double diff = max - min;
            k = random.nextDouble(diff + 1);
            k += min;
            arr[i] = k;
        }
    }
}

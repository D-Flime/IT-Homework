import java.io.*;

/* 3.5 Во входном текстовом файле дана строка символов, содержащая слова. Записать в
выходной файл слова данной строки, чтобы первая буква каждого слова была в верхнем регистре, все остальные буквы слова в нижнем.*/
// Автор: Давлетшин Д. Р.

public class Zad_3 {

    public static String fix(String s)
    {
        String[] bukvy;
        bukvy = s.split("");
        String newStr = "";
        for (int i = 0; i < bukvy.length; i++){
            bukvy[i] = bukvy[i].toLowerCase();
        }
        bukvy[0] = bukvy[0].toUpperCase();
        for (String b : bukvy){
            newStr += b;
        }
        return newStr;
    }

    public static void main(String args[]) {
        String strLine = "";
        String[] words;
        String[] bukvas;
        try{
            FileInputStream fstream = new FileInputStream("Input.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            strLine = br.readLine();
        }catch (IOException e){
            System.out.println("Ошибка");
        }
        words = strLine.split(" ");

        //Вывод
        try {
            FileWriter fw = new FileWriter("Output.txt");
            for (String w : words) {
                fw.write(fix(w));
                fw.write(" ");
            }
            fw.close();
        } catch (IOException e) {
            System.err.println("ошибка файла: " + e);
        }
    }
}

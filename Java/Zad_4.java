import java.io.*;
import java.util.ArrayList;
import java.util.List;


/* 4.5 Книга. Определить класс, описывающий понятие книги. По книге хранится следующая
информация: название, автор, год выпуска, содержание (список названий глав и их
номера страниц). Реализовать клонирование объектов класса, поиск номера страницы
по названию главы.*/
// Автор: Давлетшин Д. Р.

class Chapter {
    Integer page;
    String  name;

    public Chapter(String n, Integer p){
        this.page = p;
        this.name = n;
    }
}

class Book {
    public String name;
    public String author;
    public Integer year;
    public ArrayList<Chapter> chapters = new ArrayList<Chapter>();

    public Book(String name, String author, Integer year){
        this.name = name;
        this.author = author;
        this.year = year;
    }

    public Book(Book bookClone){
        this.name = bookClone.name;
        this.author = bookClone.author;
        this.year = bookClone.year;
        this.chapters = (ArrayList)bookClone.chapters.clone();
    }

    private Book(String name, String author, Integer year, ArrayList<Chapter> chap){
        this.name = name;
        this.author = author;
        this.year = year;
        this.chapters = chap;
    }

    public void addChapter(String name, Integer page){
        chapters.add(new Chapter(name, page));
    }

    public int getPageByChapName(String name){
        for (Chapter ch : this.chapters){
            if (ch.name == name){
                return ch.page;
            }
        }
        return -1;
    }

    public Book clone(){
        return new Book(this.name, this.author, this.year, (ArrayList)this.chapters.clone());
    }
}

public class Zad_4 {
    public static void main(String args[]) {
        Book book1 = new Book("Book_1", "Author", 2018);
        book1.addChapter("Glava_0", 5);
        book1.addChapter("Glava_1", 10);
        book1.addChapter("Glava_2", 24);

        Book book2 = book1.clone();
        System.out.println(book2.chapters);
        book1.addChapter("Glava 4", 55);
        System.out.println(book2.chapters);
        /*System.out.println(book1.getPageByChapName("Glava_1"));
        System.out.println(book1.getPageByChapName("Glava_2"));
        System.out.println(book1.getPageByChapName("Glava_5"));

        Book book2 = book1.clone();

        System.out.println(book2.getPageByChapName("Glava_1"));
        System.out.println(book2.getPageByChapName("Glava_2"));
        System.out.println(book2.getPageByChapName("Glava_5"));*/
    }
}



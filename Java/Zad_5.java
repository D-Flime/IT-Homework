import java.util.ArrayList;


/* 5.5 Библиотека книг. Определите класс, реализующий хранилище информации о книгах
(задача из предыдущей темы, вариант 4.5) на основе одной из коллекций. Хранилище
должно выдавать список книг по запросу (по автору, по названию, по году выпуска;
комбинированные запросы); должны быть реализованы операции добавления списка
книг в хранилище, удаления книг.*/
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
        if (this.getPageByChapName(name) != page){
            chapters.add(new Chapter(name, page));
        }
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

    public boolean equals(Object obj){
        if(obj == this)
            return true;
        if(obj == null)
            return false;
        if(!(getClass() == obj.getClass()))
            return false;
        else
        {
            Book tmp = (Book)obj;
            if(tmp.name == this.name && tmp.author == this.author && tmp.year == this.year){
                if(this.chapters.equals(tmp.chapters)){
                    return true;
                }
            }
            else
                return false;
        }
        return false;
    }

    public String toString(){
        String val = "[";
        val += "Имя:" + this.name + "], [";
        val += "Автор:" + this.author + "], [";
        val += "Год:" + this.year + "]";
        for (Chapter chap : this.chapters){
            val += ", [";
            val += chap.name + ":" + chap.page + "]";
        }
        return val;
    }
}

public class BooksLibrary{
    public ArrayList<Book> booklist = new ArrayList<Book>();
    
    public ArrayList<Book> getBooksByAuthor(String name){
        ArrayList<Book> list = new ArrayList<Book>();
        for (Book book : booklist){
            if (book.author == name){
                list.add(book);
            }
        }
        return list;
    }
    
    public ArrayList<Book> getBooksByName(){
        ArrayList<Book> list = new ArrayList<Book>();
    }
    
    public ArrayList<Book> getBooksByYear(){
        ArrayList<Book> list = new ArrayList<Book>();
    }
    
    
}



public class Zad_5 {
    public static void main(String args[]) {
        System.out.println("  ");
    }
}

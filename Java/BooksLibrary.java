import java.util.ArrayList;

/* 5.5 Библиотека книг. Определите класс, реализующий хранилище информации о книгах
(задача из предыдущей темы, вариант 4.5) на основе одной из коллекций. Хранилище
должно выдавать список книг по запросу (по автору, по названию, по году выпуска;
комбинированные запросы); должны быть реализованы операции добавления списка
книг в хранилище, удаления книг.*/
// Автор: Давлетшин Д. Р.

public class BooksLibrary{
    public ArrayList<Book> booklist = new ArrayList<Book>();

    public ArrayList<Book> getBooksByAuthor(String author){
        ArrayList<Book> list = new ArrayList<Book>();
        for (Book book : booklist){
            if (book.author.equals( author )){
                list.add(book);
            }
        }
        return list;
    }

    public ArrayList<Book> getBooksByName(String name){
        ArrayList<Book> list = new ArrayList<Book>();
        for (Book book : booklist){
            if (book.name.equals( name )){
                list.add(book);
            }
        }
        return list;
    }

    public ArrayList<Book> getBooksByYear(Integer year){
        ArrayList<Book> list = new ArrayList<Book>();
        for (Book book : booklist){
            if (book.year.equals( year )){
                list.add(book);
            }
        }
        return list;
    }

    public ArrayList<Book> getBooksByYearAuthor(Integer year, String author){
        ArrayList<Book> list = new ArrayList<Book>();
        for (Book book : booklist){
            if (book.year.equals(year) && book.author.equals(author)){
                list.add(book);
            }
        }
        return list;
    }

    public ArrayList<Book> getBooksByYearName(Integer year, String name){
        ArrayList<Book> list = new ArrayList<Book>();
        for (Book book : booklist){
            if (book.year.equals(year) && book.name.equals(name)){
                list.add(book);
            }
        }
        return list;
    }

    public Book getBook(Integer year, String author, String name){
        for (Book book : booklist){
            if (book.year.equals(year) && book.name.equals(name) && book.author.equals(author)){
                return book;
            }
        }
        return null;
    }

    public void add(Book newBook){
        this.booklist.add(newBook);
    }

    public void delete(Book deleteBook){
        for (Book book : this.booklist){
            if (book.equals(deleteBook)){
                this.booklist.remove(book);
            }
        }
    }
}

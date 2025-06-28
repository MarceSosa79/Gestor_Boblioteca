package models;

//Representa un libro

public class Book {
    private String title;
    private String author;
    private int year;
//Constructor
    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }
//Getters
    public String getTitle() {
        return title;
    }
//Obtener el autor
    public String getAuthor() {
        return author;
    }
//Obtener el año
    public int getYear() {
        return year;
    }
//Setters
    public String toString() {
        return "\"" + title + "\" de " + author + " (" + year + ")";
    }
}

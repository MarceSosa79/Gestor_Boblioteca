package models;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;  


public class Library {
    //Biblioteca con lista de libros
    private final LinkedList<Book> books = new LinkedList();

    // Agregar libros a la biblioteca
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Libro agregado correctamente: " + book);
    }   

    // Mostrar todos los libros de la biblioteca
    public void showAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No hay libros en la biblioteca.");
            return;
        } 
        // Mostrar los libros
        System.out.println("Listado de libros:");
        for (Book book : books) {
            System.out.println(book);
        }         
    }
        // Eliminar libro por título
    public void removeBook(String title) {
        Iterator<Book> ite = books.iterator(); 

        while(ite.hasNext()) {
            if (ite.next().getTitle().equalsIgnoreCase(title)) {
                ite.remove();
                System.out.println("Libro eliminado correctamente: " + title);
                return; // salir del while una vez se encuentra y se elimina el libro
            }
        }
        System.out.println("No se encontro el libro: " + title);
    }

    //eliminar libros anteriores a un año
    public void removeOldBooks(int yearLimit) {
        Iterator<Book> ite = books.iterator();
        boolean removed = false;

        //recorrer listado de libros
        while (ite.hasNext()) {
            //compara el año del libro con el año limite
            if (ite.next().getYear() < yearLimit) {
                ite.remove(); //elimina el libro
                removed = true;
            }
        }
        System.out.println(removed ? "Libros anteriores a " + yearLimit + " eliminados correctamente." :
                                        "No se encontraron libros anteriores a " + yearLimit);
    }
    //eliminar libros del autor x
    public void searchByAuthor(String authorQuery) {
        boolean found = false;

        //recorer listado de libros
        for (Book book : books) {
            //if para comparar el autor
            if (book.getAuthor().toLowerCase().contains(authorQuery.toLowerCase())) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No se encontraron libros del autor: " + authorQuery);
        }
    }
    
}
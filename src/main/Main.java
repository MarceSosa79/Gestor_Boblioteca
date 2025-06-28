package main;

import models.Book;
import models.Library;  
import enums.MenuOption;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);
        MenuOption option = MenuOption.EXIT;

        //bucle para mostrar menu y opciones hasta seleccionar salir
        do {
                MenuOption.printMenu();
            try{                
                int choice = Integer.parseInt(sc.nextLine().trim());
                option = MenuOption.fromOption(choice);
                //ejecutar la opcion seleccionada
                switch (option) {
                    case ADD_BOOK:
                    System.out.println("Ingrese el titulo: ");
                    String title = sc.nextLine();
                    System.out.println("Ingrese el autor: ");
                    String author = sc.nextLine();
                    System.out.println("Ingrese un año: ");
                    int year = Integer.parseInt(sc.nextLine().trim());
                    library.addBook(new Book(title, author, year));
                    break;
                //usar case para cada opcion del enum    
                case SHOW_ALL:
                    library.showAllBooks();
                    break;
                //eliminar libros por titulo
                case REMOVE_BY_TITLE:
                    System.out.println("Ingrese el titulo del libro a eliminar: ");
                    String remove = sc.nextLine();
                    library.removeBook(remove);
                    break;
                //eliminar libros anteriores a un año x   
                case REMOVE_OLD_TITLES:
                    System.out.print("Eliminar libros anteriores al año: ");
                    int yearLimit = Integer.parseInt(sc.nextLine().trim());
                    library.removeOldBooks(yearLimit);
                    break;
                    
                case SEARCH_BY_AUTHOR:
                    System.out.print("Buscar libros por autor: ");
                    library.searchByAuthor(sc.nextLine());
                    break;
                
                case EXIT:
                    System.out.println("Saliendo..."); 
                    break;    
                }

            }catch (Exception e) {
                System.out.println("Entrada no valida. Por favor, ingrese un numero.");
                option = null;
                continue;
            }
        } while (option != MenuOption.EXIT);
    sc.close();
    }

}

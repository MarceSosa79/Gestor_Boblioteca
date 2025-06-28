package enums;

//Opciones del menú principal
public enum MenuOption {
    
    ADD_BOOK(1, "Agregar libro"),
    SHOW_ALL(2, "Mostrar todos los libros"),
    REMOVE_BY_TITLE(3, "Eliminar libro por título"),
    REMOVE_OLD_TITLES(4, "Eliminar libros anteriores al año"),
    SEARCH_BY_AUTHOR(5, "Buscar libros por autor"),
    EXIT(6, "Salir");

    //opcion del menu
    private final int option;
    private String description;

    //Constructor
    MenuOption(int option, String description) {
        this.option = option;
        this.description = description;
    }

    //Obtener la opción del menu
    public static MenuOption fromOption(int option) {
        //recorre las opciones del menu
        for (MenuOption menuOption : values()) {
            //compara la opción con las opciones del enum
            if (menuOption.option == option) {
                return menuOption;
            }
        }
        return null; // Si el numero no coincide
    }

    //mprint del enum
    public static void printMenu() {
        System.out.println("\n -----Biblioteca-----");
        for (MenuOption menuOption : values()) {
            System.out.printf("%d - %s%n", menuOption.option, menuOption.description);
        }
        System.out.println("Seleccione una opcion: ");
}
}
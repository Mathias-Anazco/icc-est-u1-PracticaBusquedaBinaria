package views;
import models.Persona;
import java.util.Scanner;

public class ShowConsole{
    private Scanner sc = new Scanner(System.in);
    
    public void mostrarMenu() {
        System.out.println("\nMenú:");
        System.out.println("1. Agregar personas");
        System.out.println("2. Ordenar personas");
        System.out.println("3. Buscar persona");
        System.out.println("4. Salir");
    }

    public int cantidadPersonas(){
        System.out.println("Cuantas personas desea ingresar: ");
        int cantidad = sc.nextInt();
        sc.nextLine();
        return cantidad;
    }
    public Persona ingresarPersona() {
        System.out.println("Ingrese el nombre de la persona: ");
        String nombre = sc.nextLine(); 
        System.out.println("Ingrese la edad de la persona: ");
        int edad = Integer.parseInt(sc.nextLine()); 
        return new Persona(nombre, edad);
    }

    public int seleccionarMetodoOrdenamiento() {
        System.out.println("\n╔════════════════════════════════╗");
        System.out.println("║   MÉTODOS DE ORDENAMIENTO      ║");
        System.out.println("╠════════════════════════════════╣");
        System.out.println("║ 1. Burbuja por nombre (A-Z)    ║");
        System.out.println("║ 2. Selección por nombre (A-Z)  ║");
        System.out.println("║ 3. Inserción por nombre (A-Z)  ║");
        System.out.println("║ 4. Inserción por edad          ║");
        System.out.println("╚════════════════════════════════╝");
        System.out.print("Seleccione una opción: ");
        return sc.nextInt();
    }

    
    public int seleccionarMetodoBusqueda() {
        System.out.println("\n╔══════════════════════════════╗");
        System.out.println("║     CRITERIO DE BÚSQUEDA     ║");
        System.out.println("╠══════════════════════════════╣");
        System.out.println("║ 1. Buscar por nombre         ║");
        System.out.println("║ 2. Buscar por edad           ║");
        System.out.println("╚══════════════════════════════╝");
        System.out.print("Seleccione una opción: ");
        return sc.nextInt();
    }

    public void mostrarPersonas (Persona[] personas){
        for(Persona people : personas){
            System.out.println(people);
        }
    }
    public void mostrarResultadoBusqueda(Persona persona){
        if (persona != null){
            System.out.println("Persona encontrada: "+ persona);
        }else{
            System.out.println("No se encontro esta persona");
        }
    }
    public int ingresarEdad() {
        sc.nextLine();
        System.out.print("\nIngrese la edad a buscar: ");
        return sc.nextInt();
    }

    public String ingresarNombre() {
        sc.nextLine(); 
        System.out.print("\nIngrese el nombre a buscar: ");
        return sc.nextLine();
    }
    public int leerOpcion() {
        System.out.print("Seleccione una opción: ");
        return sc.nextInt();
    }
}
import models.Persona;
import views.ShowConsole;

import java.util.Scanner;

import Controllers.MetodoBusqueda;
import Controllers.MetodoOrdenamiento;

public class App {
    private Scanner sc = new Scanner(System.in);
    private ShowConsole vista = new ShowConsole();
    private Persona[] personas;
    private MetodoOrdenamiento metodosOrdenamiento = new MetodoOrdenamiento();
    private MetodoBusqueda metodosBusqueda = new MetodoBusqueda();

    public void iniciar() {
        boolean activo = true;
        while (activo) {
            vista.mostrarMenu();
            int opcion = vista.leerOpcion();
            switch (opcion) {
                case 1 -> agregarPersonas();
                case 2 -> ordenarPersonas();
                case 3 -> buscarPersona();
                case 4 -> activo = false;
                default -> System.out.println("Opción inválida. Por favor, intente nuevamente.");
            }
        }
        System.out.println("Gracias por utilizar el sistema");
    }

    private void agregarPersonas() {
        int cantidad = vista.cantidadPersonas();
        personas = new Persona[cantidad];
        for (int i = 0; i < cantidad; i++) {
            System.out.println("Persona #" + (i + 1));
            personas[i] = vista.ingresarPersona();
        }
    }

    private void ordenarPersonas() {
        if (personas == null || personas.length == 0) {
            System.out.println("Primero debe agregar personas.");
            return;
        }
        int metodo = vista.seleccionarMetodoOrdenamiento();
        switch (metodo) {
            case 1 -> metodosOrdenamiento.ordenamientoNombreBurbuja(personas);
            case 2 -> metodosOrdenamiento.ordenamientoNombreSeleccionDes(personas);
            case 3 -> metodosOrdenamiento.ordenamientoNombreInsercion(personas);
            case 4 -> metodosOrdenamiento.ordenamientoEdadInsercion(personas);
            default -> System.out.println("Método de ordenamiento inválido.");
        }
        vista.mostrarPersonas(personas);
    }

    private void buscarPersona() {
        if (personas == null || personas.length == 0) {
            System.out.println("Primero debe agregar personas.");
            return;
        }
        int criterio = vista.seleccionarMetodoBusqueda();
        Persona resultado = null;
        
        if (criterio == 1) { 
            if (metodosBusqueda.estaOrdenadoPorNombre(personas)) {
                sc.nextLine(); 
                resultado = metodosBusqueda.busquedaBinariaPorNombre(personas, vista.ingresarNombre());
            } else {
                System.out.println("La lista debe estar ordenada por nombre para esta búsqueda.");
            }
        } else if (criterio == 2) {
            if (metodosBusqueda.estaOrdenadoPorEdad(personas)) {
                resultado = metodosBusqueda.busquedaBinariaPorEdad(personas, vista.ingresarEdad());
            } else {
                System.out.println("La lista debe estar ordenada por edad para esta búsqueda.");
            }
        }
        
        vista.mostrarResultadoBusqueda(resultado);
    }

    public static void main(String[] args) {
        new App().iniciar();
    }
}


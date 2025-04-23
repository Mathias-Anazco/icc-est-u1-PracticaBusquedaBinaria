package Controllers;

import models.Persona;

public class MetodoBusqueda {


    public boolean estaOrdenadoPorEdad(Persona[] personas) {
        for (int i = 1; i < personas.length; i++) {
            if (personas[i - 1].getEdad() > personas[i].getEdad()) return false;
        }
        return true;
    }

    public boolean estaOrdenadoPorNombre(Persona[] personas) {
        for (int i = 1; i < personas.length; i++) {
            if (personas[i - 1].getNombre().compareTo(personas[i].getNombre()) > 0) return false;
        }
        return true;
    }

    public Persona busquedaBinariaPorEdad(Persona[] personas, int edad) {
        int izquierda = 0, derecha = personas.length - 1;
        while (izquierda <= derecha) {
            int medio = (izquierda + derecha) / 2;
            if (personas[medio].getEdad() == edad) return personas[medio];
            else if (personas[medio].getEdad() < edad) izquierda = medio + 1;
            else derecha = medio - 1;
        }
        return null;
    }

    public Persona busquedaBinariaPorNombre(Persona[] personas, String nombre) {
        int izquierda = 0, derecha = personas.length - 1;
        while (izquierda <= derecha) {
            int medio = (izquierda + derecha) / 2;
            int comparacion = personas[medio].getNombre().compareTo(nombre);
            if (comparacion == 0) return personas[medio];
            else if (comparacion < 0) izquierda = medio + 1;
            else derecha = medio - 1;
        }
        return null;
    }

}

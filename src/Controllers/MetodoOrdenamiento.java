package Controllers;
import models.Persona;

public class MetodoOrdenamiento {

    public void ordenamientoEdadBurbuja (Persona[] personas){
        for(int i = 0; i < personas.length - 1; i++){
            for(int j = 0; j < personas.length - i - 1; j++){
                if(personas[j].getEdad() > personas[j+1].getEdad()){
                    Persona temp = personas[j];
                    personas[j] = personas[j+1];
                    personas[j+1] = temp;
                }
            }
        }
    }
    public void ordenamientoEdadSeleccionDes (Persona[] personas){
        for(int i = 0; i < personas.length - 1; i++){
            int min = i;
            for(int j = i + 1; j < personas.length; j++){
                if(personas[j].getEdad() < personas[min].getEdad()){
                    min = j;
                }
            }
            Persona temp = personas[i];
            personas[i] = personas[min];
            personas[min] = temp;
        }
    }
    public void ordenamientoEdadInsercion (Persona[] personas){
        for(int i = 1; i < personas.length; i++){
            Persona clave = personas[i];
            int j = i -1;
            while (j >= 0 && personas[j].getEdad() > clave.getEdad()) {
                personas[j+1] = personas[j];
                j--;
            }
            personas[j+1] = clave;
        }
    }
    public void ordenamientoNombreInsercion (Persona[] personas){
        for(int i = 1; i < personas.length; i++){
            Persona clave = personas[i];
            int j = i -1;
            while (j >= 0 && personas[j].getNombre().compareToIgnoreCase(clave.getNombre()) > 0) {
                personas[j+1] = personas[j];
                j--;
            }
            personas[j+1] = clave;
        }
    }
}
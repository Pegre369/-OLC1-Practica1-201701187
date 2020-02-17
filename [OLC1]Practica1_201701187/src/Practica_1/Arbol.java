package Practica_1;

import java.io.IOException;
import java.util.ArrayList;

public class Arbol {

    //Clase del nodo
    class Nodo {

        public String etiquetas;
        public Nodo derecha;
        public Nodo izquierda;
        public String descripcion;

        public Nodo(String nombre, String descrip) {

            this.etiquetas = nombre;
            this.descripcion = descrip;
            this.derecha = null;
            this.izquierda = null;
        }

    }

    // Clase del arbol
    public Nodo raiz = null;
    public static ArrayList<Lista_ER> cara;
    public static int punterodelista;

    public Arbol(ArrayList<Lista_ER> Caracteres) throws IOException, InterruptedException {

        this.cara = Caracteres;
        raiz = Agregar();

        raiz = null;

    }

    Nodo Agregar() {

        switch (cara.get(punterodelista).getDescripcion()) {

            //Si es una Concatenacion
            case "Concatenacion":

                Nodo concatenacion = new Nodo(cara.get(punterodelista).getEtiqueta(), cara.get(punterodelista).getDescripcion());
                punterodelista++;
                Nodo conca_izquierda = Agregar();
                Nodo conca_derecha = Agregar();
                concatenacion.izquierda = conca_izquierda;
                concatenacion.derecha = conca_derecha;
                return concatenacion;

            //Si es un Or    
            case "Or":

                Nodo or = new Nodo(cara.get(punterodelista).getEtiqueta(), cara.get(punterodelista).getDescripcion());
                punterodelista++;
                Nodo or_izquierda = Agregar();
                Nodo or_derecha = Agregar();
                or.izquierda = or_izquierda;
                or.derecha = or_derecha;
                return or;

            //Si es una cerradura de Kleen    
            case "kleen":

                Nodo kleen = new Nodo(cara.get(punterodelista).getEtiqueta(), cara.get(punterodelista).getDescripcion());
                punterodelista++;
                Nodo kleen_derecha = Agregar();
                kleen.derecha = kleen_derecha;
                return kleen;

            //Si es una cerradura Positiva
            case "positiva":

                Nodo positiva = new Nodo(cara.get(punterodelista).getEtiqueta(), cara.get(punterodelista).getDescripcion());
                punterodelista++;
                Nodo positiva_derecha = Agregar();
                positiva.derecha = positiva_derecha;
                return positiva;

            //Si es una cerradura de Aparicion
            case "aparicion":

                Nodo aparicion = new Nodo(cara.get(punterodelista).getEtiqueta(), cara.get(punterodelista).getDescripcion());
                punterodelista++;
                Nodo aparicion_derecha = Agregar();
                aparicion.derecha = aparicion_derecha;
                return aparicion;

            //Si es una Cadena se trata como Hoja    
            case "cadena":

                Nodo cadena = new Nodo(cara.get(punterodelista).getEtiqueta(), cara.get(punterodelista).getDescripcion());
                punterodelista++;
                return cadena;

            //Si es un Id se trata como Hoja    
            case "identificador":
                Nodo id = new Nodo(cara.get(punterodelista).getEtiqueta(), cara.get(punterodelista).getDescripcion());
                punterodelista++;
                return id;

            default:
                return null;

        }
    }
    
    
    
    

}

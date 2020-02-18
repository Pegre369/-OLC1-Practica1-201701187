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

        public String getEtiquetas() {
            return etiquetas;
        }

        public String getDescripcion() {
            return descripcion;
        }

    }

    // Clase del arbol
    public Nodo raiz = null;
    public static ArrayList<Lista_ER> cara;
    public static int punterodelista;
    public static String Texto_Graphiz;
    public int index;

    public Arbol(ArrayList<Lista_ER> Caracteres, int inde) throws IOException, InterruptedException {

        this.cara = Caracteres;
        this.index = inde;
        raiz = Agregar();
        ArbolER();

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
                Nodo kleen_izquierda = Agregar();
                kleen.izquierda = kleen_izquierda;
                return kleen;

            //Si es una cerradura Positiva
            case "positiva":

                Nodo positiva = new Nodo(cara.get(punterodelista).getEtiqueta(), cara.get(punterodelista).getDescripcion());
                punterodelista++;
                Nodo positiva_izquierda = Agregar();
                positiva.izquierda = positiva_izquierda;
                return positiva;

            //Si es una cerradura de Aparicion
            case "aparicion":

                Nodo aparicion = new Nodo(cara.get(punterodelista).getEtiqueta(), cara.get(punterodelista).getDescripcion());
                punterodelista++;
                Nodo aparicion_izquierda = Agregar();
                aparicion.izquierda = aparicion_izquierda;
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

    public void ArbolER() throws IOException, InterruptedException {

        Texto_Graphiz = "digraph g{\n";
        Texto_Graphiz = Texto_Graphiz + "node [shape = record, heigth=.1];\n";
        Recorrer_Arbol(raiz);
        Texto_Graphiz = Texto_Graphiz + "}";
        Generar_Arbol_ER generar = new Generar_Arbol_ER();
        generar.Crear("Arbol" + index, Texto_Graphiz);
        index++;

    }

    public void Recorrer_Arbol(Nodo temporal) {

        if (temporal != null) {

            Recorrer_Arbol(temporal.izquierda);
            Texto_Graphiz = Texto_Graphiz + "\"" + temporal.toString() + "\"" + "[label = \"Primeros: |{" + temporal.etiquetas + "|}|\"];\n";

            if (temporal.derecha != null) {
            Texto_Graphiz = Texto_Graphiz + "\""+temporal.toString()+"\""+"->"+"\""+temporal.derecha.toString()+"\";\n";    
           }

            if (temporal.izquierda != null) {
                Texto_Graphiz = Texto_Graphiz + "\""+temporal.toString()+"\""+"->"+"\""+temporal.izquierda.toString()+"\";\n";
          }

            Recorrer_Arbol(temporal.derecha);
        }

    }

}

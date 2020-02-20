package Practica_1;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;

public class Arbol {

    //Clase del nodo
    class Nodo {

        public String etiquetas;
        public Nodo derecha;
        public Nodo izquierda;
        public String descripcion;
        public String Anulabre;
        public String Primeros;
        public String Ultimos;

        public Nodo(String nombre, String descrip, String anulable, String P, String U) {

            this.etiquetas = nombre;
            this.descripcion = descrip;
            this.Anulabre = anulable;
            this.Primeros = P;
            this.Ultimos = U;
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
    public static ArrayList<Lista_Follow> Siguientes = new ArrayList<>();
    public static int punterodelista;
    public static String Texto_Graphiz;
    public int index, primero = 1, ultimo = 1;

    public Arbol(ArrayList<Lista_ER> Caracteres, int inde) throws IOException, InterruptedException {

        this.cara = Caracteres;
        this.index = inde;
        raiz = Agregar();
        ArbolER();
        Follow(raiz);
        Ordenar();
        for (int i = 0; i < Siguientes.size(); i++) {

            System.out.println(Siguientes.get(i).getHoja() + "->" + Siguientes.get(i).getNumero() + "->" + Siguientes.get(i).getFollow());

        }

        punterodelista = 0;
    }

    Nodo Agregar() {

        switch (cara.get(punterodelista).getDescripcion()) {

            //Si es una Concatenacion
            case "Concatenacion":

                Nodo concatenacion = new Nodo(cara.get(punterodelista).getEtiqueta(), cara.get(punterodelista).getDescripcion(), "No Anulable", "0", "0");
                punterodelista++;
                Nodo conca_izquierda = Agregar();
                Nodo conca_derecha = Agregar();
                concatenacion.izquierda = conca_izquierda;
                concatenacion.derecha = conca_derecha;

                //Anulables
                if (conca_izquierda.Anulabre == "Anulable" && conca_derecha.Anulabre == "Anulable") {
                    concatenacion.Anulabre = "Anulable";
                } else if (conca_izquierda.Anulabre == "Anulable" && conca_derecha.Anulabre == "No Anulable") {
                    concatenacion.Anulabre = "No Anulable";
                } else if (conca_izquierda.Anulabre == "No Anulable" && conca_derecha.Anulabre == "Anulable") {
                    concatenacion.Anulabre = "No Anulable";
                } else if (conca_izquierda.Anulabre == "No Anulable" && conca_derecha.Anulabre == "No Anulable") {
                    concatenacion.Anulabre = "No Anulable";
                }

                //Primeros de concatenacion
                if (conca_izquierda.Anulabre == "Anulable") {
                    concatenacion.Primeros = conca_izquierda.Primeros + "," + conca_derecha.Primeros;
                } else {
                    concatenacion.Primeros = conca_izquierda.Primeros;
                }

                //Ultimos de concatenacion
                if (conca_derecha.Anulabre == "Anulable") {
                    concatenacion.Ultimos = conca_izquierda.Ultimos + "," + conca_derecha.Ultimos;
                } else {
                    concatenacion.Ultimos = conca_derecha.Ultimos;
                }

                return concatenacion;

            //Si es un Or    
            case "Or":

                Nodo or = new Nodo(cara.get(punterodelista).getEtiqueta(), cara.get(punterodelista).getDescripcion(), "No Anulable", "0", "0");
                punterodelista++;
                Nodo or_izquierda = Agregar();
                Nodo or_derecha = Agregar();
                or.izquierda = or_izquierda;
                or.derecha = or_derecha;

                //Anulables
                if (or_izquierda.Anulabre == "No Anulable" && or_derecha.Anulabre == "No Anulable") {
                    or.Anulabre = "No Anulable";
                } else if (or_izquierda.Anulabre == "Anulable" && or_derecha.Anulabre == "No Anulable") {
                    or.Anulabre = "Anulable";
                } else if (or_izquierda.Anulabre == "No Anulable" && or_derecha.Anulabre == "Anulable") {
                    or.Anulabre = "Anulable";
                } else if (or_izquierda.Anulabre == "Anulable" && or_derecha.Anulabre == "Anulable") {
                    or.Anulabre = "Anulable";
                }

                //Primeros
                or.Primeros = or_izquierda.Primeros + "," + or_derecha.Primeros;

                //Ultimos
                or.Ultimos = or_izquierda.Ultimos + "," + or_derecha.Ultimos;

                return or;

            //Si es una cerradura de Kleen    
            case "kleen":

                Nodo kleen = new Nodo(cara.get(punterodelista).getEtiqueta(), cara.get(punterodelista).getDescripcion(), "No Anulable", "0", "0");
                punterodelista++;
                Nodo kleen_izquierda = Agregar();
                kleen.izquierda = kleen_izquierda;
                if (kleen_izquierda.Anulabre == "No Anulable") {
                    kleen.Anulabre = "Anulable";
                } else if (kleen_izquierda.Anulabre == "Anulable") {
                    kleen.Anulabre = "Anulable";
                }
                //Primeros
                kleen.Primeros = kleen_izquierda.Primeros;
                //Ultimos
                kleen.Ultimos = kleen_izquierda.Ultimos;

                return kleen;

            //Si es una cerradura Positiva
            case "positiva":

                Nodo positiva = new Nodo(cara.get(punterodelista).getEtiqueta(), cara.get(punterodelista).getDescripcion(), "No Anulable", "0", "0");
                punterodelista++;
                Nodo positiva_izquierda = Agregar();
                positiva.izquierda = positiva_izquierda;
                if (positiva_izquierda.Anulabre == "Anulable") {
                    positiva.Anulabre = "No Anulable";
                } else if (positiva_izquierda.Anulabre == "No Anulable") {
                    positiva.Anulabre = "No Anulable";
                }
                //Primeros
                positiva.Primeros = positiva_izquierda.Primeros;
                //Ultimos
                positiva.Ultimos = positiva_izquierda.Ultimos;

                return positiva;

            //Si es una cerradura de Aparicion
            case "aparicion":

                Nodo aparicion = new Nodo(cara.get(punterodelista).getEtiqueta(), cara.get(punterodelista).getDescripcion(), "No Anulable", "0", "0");
                punterodelista++;
                Nodo aparicion_izquierda = Agregar();
                aparicion.izquierda = aparicion_izquierda;
                if (aparicion_izquierda.Anulabre == "No Anulable") {
                    aparicion.Anulabre = "Anulable";
                } else if (aparicion_izquierda.Anulabre == "Anulable") {
                    aparicion.Anulabre = "Anulable";
                }
                //Primeros
                aparicion.Primeros = aparicion_izquierda.Primeros;
                //Ultimos
                aparicion.Ultimos = aparicion_izquierda.Ultimos;
                return aparicion;

            //Si es una Cadena se trata como Hoja    
            case "cadena":

                Nodo cadena = new Nodo(cara.get(punterodelista).getEtiqueta(), cara.get(punterodelista).getDescripcion(), "No Anulable", String.valueOf(primero), String.valueOf(ultimo));
                agregar_follow(cara.get(punterodelista).getEtiqueta(), primero, "");
                punterodelista++;
                primero++;
                ultimo++;
                return cadena;

            //Si es un Id se trata como Hoja    
            case "identificador":
                Nodo id = new Nodo(cara.get(punterodelista).getEtiqueta(), cara.get(punterodelista).getDescripcion(), "No Anulable", String.valueOf(primero), String.valueOf(ultimo));
                agregar_follow(cara.get(punterodelista).getEtiqueta(), primero, "");
                punterodelista++;
                primero++;
                ultimo++;
                return id;

            //Si es un Id se trata como Hoja    
            case "Aceptacion":
                Nodo aceptar = new Nodo(cara.get(punterodelista).getEtiqueta(), cara.get(punterodelista).getDescripcion(), "No Anulable", String.valueOf(primero), String.valueOf(ultimo));
                agregar_follow(cara.get(punterodelista).getEtiqueta(), primero, "");
                punterodelista++;
                primero++;
                ultimo++;
                return aceptar;

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

            if (temporal.etiquetas.equals("|") || temporal.etiquetas.equals(">") || temporal.etiquetas.equals("{") || temporal.etiquetas.equals("}")) {

                Texto_Graphiz = Texto_Graphiz + "\"" + temporal.toString() + "\"" + "[label = \"P: " + temporal.Primeros + "|{" + temporal.Anulabre + " |\\" + temporal.etiquetas + "}|U:" + temporal.Ultimos + " \"];\n";

            } else {

                Texto_Graphiz = Texto_Graphiz + "\"" + temporal.toString() + "\"" + "[label = \"P: " + temporal.Primeros + " |{" + temporal.Anulabre + " |" + temporal.etiquetas + "}|U:" + temporal.Ultimos + " \"];\n";

            }
            if (temporal.derecha != null) {
                Texto_Graphiz = Texto_Graphiz + "\"" + temporal.toString() + "\"" + "->" + "\"" + temporal.derecha.toString() + "\";\n";
            }

            if (temporal.izquierda != null) {
                Texto_Graphiz = Texto_Graphiz + "\"" + temporal.toString() + "\"" + "->" + "\"" + temporal.izquierda.toString() + "\";\n";
            }

            Recorrer_Arbol(temporal.derecha);
        }

    }

    //Tabla Follows
    public static LinkedList<String> f = new LinkedList();

    public void Follow(Nodo raiz) {

        if (raiz != null) {

            Follow(raiz.izquierda);

            switch (raiz.etiquetas) {

                case "+":
                  //  System.out.println("positiva");
                    String primero_positivo = raiz.Primeros;
                    String ultimo_positivo = raiz.Ultimos;
                    recorer(primero_positivo, ultimo_positivo);
                    
                    break;

                case "*":
                   // System.out.println("kleen");
                    String primero_kleen = raiz.Primeros;
                    String ultimo_kleen = raiz.Ultimos;
                    recorer(primero_kleen, ultimo_kleen);
                    break;

                case ".":
                   // System.out.println("concatenacion");
                    //System.out.println("");
                    /* System.out.println(raiz.izquierda.Ultimos);
                    System.out.println(raiz.derecha.Primeros);
                    System.out.println("");*/
                    String ultimo_conca = raiz.izquierda.Ultimos;
                    String primero_conca = raiz.derecha.Primeros;
                    recorer(ultimo_conca, primero_conca);
                    break;


            }

            Follow(raiz.derecha);
        }

    }

    public void recorer(String primer, String ult) {

        String pseparar = primer;
        char caracter = ' ';

        for (int i = 0; i < pseparar.length(); i++) {

            caracter = pseparar.charAt(i);

            if (Character.isDigit(caracter)) {
                f.add(Character.toString(caracter));
            }

        }

        String a;

        for (int vector = 0; vector < f.size(); vector++) {

            for (int i = 0; i < Siguientes.size(); i++) {

                if (Siguientes.get(i).getNumero() == Integer.parseInt(f.get(vector))) {

                    a = ult + "," + Siguientes.get(i).getFollow();
                    Siguientes.get(i).setFollow(a);
                    a=" ";
                    
                    break;
                }

            }

        }
        f.clear();

    }

    
    public void Ordenar(){
        
    }
    
    
    public void agregar_follow(String hoja, int Numero, String sus_siguientes) {

        Lista_Follow add = new Lista_Follow(hoja, Numero, sus_siguientes);
        Siguientes.add(add);

    }
}

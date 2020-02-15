package Practica_1;

import java.util.ArrayList;

public class Arbol {

    //Clase del nodo
    class Nodo {

        public String etiquetas;
        public Nodo derecha;
        public Nodo izquierda;
        public String descripcion;

        public Nodo(String etiqueta, String des) {

            this.etiquetas = etiqueta;
            this.descripcion = des;
            this.derecha = null;
            this.izquierda = null;

        }

    }

    // Clase del arbol
    Nodo raiz;
    public static ArrayList<Lista_ER> cara;

    public Arbol() {

        raiz = null;

    }

    public void Asignacion(ArrayList<Lista_ER> Caracteres) {

        cara = Caracteres;

        for (int i = 0; i < cara.size(); i++) {

            //System.out.println(cara.get(i).getEtiqueta() + " -> " + cara.get(i).getDescripcion());
            agregar(cara.get(i).getEtiqueta(), cara.get(i).getDescripcion());

        }

        recoridopreorder(raiz);

    }

    public Nodo agregarnodo(Nodo raiz, String etiqueta, String desc) {

        if (raiz == null) {

            return new Nodo(etiqueta, desc);

        }

        //Nodos de doble ramas
        if (desc == "Concatenacion" || desc == "Or") {

            if (raiz.izquierda == null && raiz.derecha == null) {

                raiz.izquierda = agregarnodo(raiz.izquierda, etiqueta, desc);

            } else if (raiz.izquierda.descripcion == "kleen" || raiz.izquierda.descripcion == "positiva" || raiz.izquierda.descripcion == "aparicion") {

                raiz.izquierda = agregarnodo(raiz.izquierda, etiqueta, desc);

            } else if (raiz.izquierda != null && raiz.derecha == null) {

                raiz.derecha = agregarnodo(raiz.derecha, etiqueta, desc);

            } else if (raiz.derecha.descripcion == "kleen" || raiz.derecha.descripcion == "positiva" || raiz.derecha.descripcion == "aparicion") {

                raiz.derecha = agregarnodo(raiz.derecha, etiqueta, desc);

            } else {
                return raiz;
            }

            //Nodos de Una rama    
        } else if (desc == "kleen" || desc == "positiva" || desc == "aparicion") {

            if (raiz.izquierda != null && raiz.derecha == null) {

                raiz.derecha = agregarnodo(raiz.derecha, etiqueta, desc);

            } else {

                raiz.izquierda = agregarnodo(raiz.izquierda, etiqueta, desc);

            }

            //Nodos Hojas
        } else if (desc == "identificador" || desc == "cadena") {

            if (raiz.izquierda == null && raiz.derecha == null) {

                raiz.izquierda = agregarnodo(raiz.izquierda, etiqueta, desc);

            } else if (raiz.izquierda.descripcion == "kleen" || raiz.izquierda.descripcion == "positiva" || raiz.izquierda.descripcion == "aparicion") {

                raiz.izquierda = agregarnodo(raiz.izquierda, etiqueta, desc);

            } else if (raiz.izquierda.descripcion == "Concatenacion" || raiz.izquierda.descripcion == "Or") {

                raiz.izquierda = agregarnodo(raiz.izquierda, etiqueta, desc);

            } else if (raiz.izquierda != null && raiz.derecha == null) {

                raiz.derecha = agregarnodo(raiz.derecha, etiqueta, desc);

            } else if (raiz.derecha.descripcion == "kleen" || raiz.derecha.descripcion == "positiva" || raiz.derecha.descripcion == "aparicion") {

                raiz.derecha = agregarnodo(raiz.derecha, etiqueta, desc);

            } else if (raiz.derecha.descripcion == "Concatenacion" || raiz.derecha.descripcion == "Or") {

                raiz.derecha = agregarnodo(raiz.derecha, etiqueta, desc);

            } else {
                return raiz;
            }
        }
//FINAL DEL METODO
        return raiz;
    }

    public void agregar(String etiqueta, String desc) {
        raiz = agregarnodo(raiz, etiqueta, desc);
    }

    public void recoridopreorder(Nodo nodo) {
        if (nodo != null) {
            recoridopreorder(nodo.izquierda);
            recoridopreorder(nodo.derecha);
            System.out.print(" " + nodo.etiquetas);
        }
    }

}

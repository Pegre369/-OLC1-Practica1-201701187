package Practica_1;

import java.util.ArrayList;

public class Arbol {

    //Clase del nodo
    class Nodo {

        public String etiquetas;
        public Nodo derecha;
        public Nodo izquierda;
        public String descripcion;
        public boolean lleno;

        public Nodo(String etiqueta, String des, boolean llen) {

            this.etiquetas = etiqueta;
            this.descripcion = des;
            this.derecha = null;
            this.izquierda = null;
            this.lleno = llen;

        }

    }

    // Clase del arbol
    Nodo raiz;
    public static ArrayList<Lista_ER> cara;
    public static int i;
    public static boolean lleno = false;

    public Arbol() {

        raiz = null;

    }

    public void Asignacion(ArrayList<Lista_ER> Caracteres) {

        cara = Caracteres;

        for (i = 0; i < cara.size(); i++) {

            //System.out.println(cara.get(i).getEtiqueta() + " -> " + cara.get(i).getDescripcion());
            agregar(cara.get(i).getEtiqueta(), cara.get(i).getDescripcion(), lleno);

        }

        recoridopreorder(raiz);

    }

    public Nodo agregarnodo(Nodo raiz, String etiqueta, String desc, boolean lleno) {

        if (raiz == null) {

            return new Nodo(etiqueta, desc, lleno);

        }

        //Nodos de doble ramas
        if (desc == "Concatenacion" || desc == "Or") {

            if (raiz.izquierda == null) {

                if (desc == "identificador" || desc == "cadena") {

                    lleno = true;
                    raiz.izquierda = agregarnodo(raiz.izquierda, etiqueta, desc, lleno);

                } else {
                    lleno = false;
                    raiz.izquierda = agregarnodo(raiz.izquierda, etiqueta, desc, lleno);
                }

            } else if ((raiz.izquierda.descripcion == "Concatenacion" && raiz.izquierda.lleno == false) || (raiz.izquierda.descripcion == "Or" && raiz.izquierda.lleno == false)) {

                raiz.izquierda = agregarnodo(raiz.izquierda, etiqueta, desc, lleno);

            } else if ((raiz.izquierda.descripcion == "Concatenacion" && raiz.izquierda.lleno == true) || (raiz.izquierda.descripcion == "Or" && raiz.izquierda.lleno == true)) {

                /*DERECHA*/
                if (raiz.derecha == null) {
                    if (desc == "identificador" || desc == "cadena") {

                        lleno = true;
                        raiz.derecha = agregarnodo(raiz.derecha, etiqueta, desc, lleno);

                    } else {
                        lleno = false;
                        raiz.derecha = agregarnodo(raiz.derecha, etiqueta, desc, lleno);
                    }
                } else if (raiz.descripcion == "Concatenacion" || raiz.descripcion == "Or") {

                    if (raiz.izquierda.descripcion == "identificador" && raiz.derecha.descripcion == "identificador") {
                        raiz.lleno = true;
                        i--;
                    } else if (raiz.izquierda.descripcion == "identificador" && raiz.derecha.descripcion == "cadena") {
                        raiz.lleno = true;
                        i--;
                    } else if (raiz.izquierda.descripcion == "cadena" && raiz.derecha.descripcion == "cadena") {
                        raiz.lleno = true;
                        i--;
                    } else if (raiz.izquierda.descripcion == "cadena" && raiz.derecha.descripcion == "identificador") {
                        raiz.lleno = true;
                        i--;
                    } else {
                        raiz.lleno = true;
                        i--;
                    }
                }

            } else if ((raiz.izquierda.descripcion == "kleen" && raiz.izquierda.lleno == false) || (raiz.izquierda.descripcion == "positiva" && raiz.izquierda.lleno == false) || (raiz.izquierda.descripcion == "aparicion" && raiz.izquierda.lleno == false)) {

                raiz.izquierda = agregarnodo(raiz.izquierda, etiqueta, desc, lleno);

            } else if ((raiz.izquierda.descripcion == "kleen" && raiz.izquierda.lleno == true) || (raiz.izquierda.descripcion == "positiva" && raiz.izquierda.lleno == true) || (raiz.izquierda.descripcion == "aparicion" && raiz.izquierda.lleno == true)) {

                /*DERECHA*/
                if (raiz.derecha == null) {
                    if (desc == "identificador" || desc == "cadena") {

                        lleno = true;
                        raiz.derecha = agregarnodo(raiz.derecha, etiqueta, desc, lleno);

                    } else {
                        lleno = false;
                        raiz.derecha = agregarnodo(raiz.derecha, etiqueta, desc, lleno);
                    }
                }

            } else if (raiz.descripcion == "kleen" || raiz.descripcion == "positiva" || raiz.descripcion == "aparicion") {
                raiz.lleno = true;
                i--;
            }

            //Nodos de Una rama    
        } else if (desc == "kleen" || desc == "positiva" || desc == "aparicion") {

            if (raiz.izquierda == null) {

                if (desc == "identificador" || desc == "cadena") {

                    lleno = true;
                    raiz.izquierda = agregarnodo(raiz.izquierda, etiqueta, desc, lleno);

                } else {
                    lleno = false;
                    raiz.izquierda = agregarnodo(raiz.izquierda, etiqueta, desc, lleno);
                }
            } else if ((raiz.izquierda.descripcion == "Concatenacion" && raiz.izquierda.lleno == false) || (raiz.izquierda.descripcion == "Or" && raiz.izquierda.lleno == false)) {

                raiz.izquierda = agregarnodo(raiz.izquierda, etiqueta, desc, lleno);

            } else if ((raiz.izquierda.descripcion == "Concatenacion" && raiz.izquierda.lleno == true) || (raiz.izquierda.descripcion == "Or" && raiz.izquierda.lleno == true)) {
                /*DERECH*/
                if (raiz.descripcion == "kleen" || raiz.descripcion == "positiva" || raiz.descripcion == "aparicion") {
                    raiz.lleno = true;
                    i--;
                } else {
                    if (raiz.derecha == null) {
                        if (desc == "identificador" || desc == "cadena") {

                            lleno = true;
                            raiz.derecha = agregarnodo(raiz.derecha, etiqueta, desc, lleno);

                        } else {
                            lleno = false;
                            raiz.derecha = agregarnodo(raiz.derecha, etiqueta, desc, lleno);
                        }
                    } else if ((raiz.derecha.descripcion == "kleen" && raiz.derecha.lleno == false) || (raiz.derecha.descripcion == "positiva" && raiz.derecha.lleno == false) || (raiz.derecha.descripcion == "aparicion" && raiz.derecha.lleno == false)) {

                        raiz.derecha = agregarnodo(raiz.derecha, etiqueta, desc, lleno);

                    } else if ((raiz.derecha.descripcion == "kleen" && raiz.izquierda.lleno == true) || (raiz.derecha.descripcion == "positiva" && raiz.derecha.lleno == true) || (raiz.derecha.descripcion == "aparicion" && raiz.derecha.lleno == true)) {

                        raiz.lleno = true;
                        i--;

                    } else if (raiz.descripcion == "Concatenacion" || raiz.descripcion == "Or") {

                        if (raiz.izquierda.descripcion == "identificador" && raiz.derecha.descripcion == "identificador") {
                            raiz.lleno = true;
                            i--;
                        } else if (raiz.izquierda.descripcion == "identificador" && raiz.derecha.descripcion == "cadena") {
                            raiz.lleno = true;
                            i--;
                        } else if (raiz.izquierda.descripcion == "cadena" && raiz.derecha.descripcion == "cadena") {
                            raiz.lleno = true;
                            i--;
                        } else if (raiz.izquierda.descripcion == "cadena" && raiz.derecha.descripcion == "identificador") {
                            raiz.lleno = true;
                            i--;
                        } else {
                            raiz.lleno = true;
                            i--;
                        }
                    }
                }
            } else if ((raiz.izquierda.descripcion == "kleen" && raiz.izquierda.lleno == false) || (raiz.izquierda.descripcion == "positiva" && raiz.izquierda.lleno == false) || (raiz.izquierda.descripcion == "aparicion" && raiz.izquierda.lleno == false)) {

                raiz.izquierda = agregarnodo(raiz.izquierda, etiqueta, desc, lleno);

            } else if ((raiz.izquierda.descripcion == "kleen" && raiz.izquierda.lleno == true) || (raiz.izquierda.descripcion == "positiva" && raiz.izquierda.lleno == true) || (raiz.izquierda.descripcion == "aparicion" && raiz.izquierda.lleno == true)) {

                /* Verifico DERECHA*/
                if (raiz.derecha == null) {
                    if (desc == "identificador" || desc == "cadena") {

                        lleno = true;
                        raiz.derecha = agregarnodo(raiz.derecha, etiqueta, desc, lleno);

                    } else {
                        lleno = false;
                        raiz.derecha = agregarnodo(raiz.derecha, etiqueta, desc, lleno);
                    }
                } else if ((raiz.derecha.descripcion == "kleen" && raiz.derecha.lleno == false) || (raiz.derecha.descripcion == "positiva" && raiz.derecha.lleno == false) || (raiz.derecha.descripcion == "aparicion" && raiz.derecha.lleno == false)) {

                    raiz.derecha = agregarnodo(raiz.derecha, etiqueta, desc, lleno);

                } else if ((raiz.derecha.descripcion == "kleen" && raiz.derecha.lleno == true) || (raiz.derecha.descripcion == "positiva" && raiz.derecha.lleno == true) || (raiz.derecha.descripcion == "aparicion" && raiz.derecha.lleno == true)) {

                    raiz.lleno = true;
                    i--;

                }

            } else if (raiz.descripcion == "Concatenacion" || raiz.descripcion == "Or") {

                if (raiz.izquierda.descripcion == "identificador" && raiz.derecha.descripcion == "identificador") {
                    raiz.lleno = true;
                    i--;
                } else if (raiz.izquierda.descripcion == "identificador" && raiz.derecha.descripcion == "cadena") {
                    raiz.lleno = true;
                    i--;
                } else if (raiz.izquierda.descripcion == "cadena" && raiz.derecha.descripcion == "cadena") {
                    raiz.lleno = true;
                    i--;
                } else if (raiz.izquierda.descripcion == "cadena" && raiz.derecha.descripcion == "identificador") {
                    raiz.lleno = true;
                    i--;
                }
            } else if (raiz.descripcion == "kleen" || raiz.descripcion == "positiva" || raiz.descripcion == "aparicion") {

                raiz.lleno = true;
                i--;
            }

            //Nodos Hojas
        } else if (desc == "identificador" || desc == "cadena") {

            if (raiz.izquierda == null) {

                if (desc == "identificador" || desc == "cadena") {

                    lleno = true;
                    raiz.izquierda = agregarnodo(raiz.izquierda, etiqueta, desc, lleno);
                    lleno = false;

                } else {
                    lleno = false;
                    raiz.izquierda = agregarnodo(raiz.izquierda, etiqueta, desc, lleno);
                }

            } else if ((raiz.izquierda.descripcion == "kleen" && raiz.izquierda.lleno == false) || (raiz.izquierda.descripcion == "positiva" && raiz.izquierda.lleno == false) || (raiz.izquierda.descripcion == "aparicion" && raiz.izquierda.lleno == false)) {

                raiz.izquierda = agregarnodo(raiz.izquierda, etiqueta, desc, lleno);

            } else if ((raiz.izquierda.descripcion == "kleen" && raiz.izquierda.lleno == true) || (raiz.izquierda.descripcion == "positiva" && raiz.izquierda.lleno == true) || (raiz.izquierda.descripcion == "aparicion" && raiz.izquierda.lleno == true)) {

                /*Derecha*/
                if (raiz.derecha == null) {
                    if (desc == "identificador" || desc == "cadena") {

                        lleno = true;
                        raiz.derecha = agregarnodo(raiz.derecha, etiqueta, desc, lleno);

                    } else {
                        lleno = false;
                        raiz.derecha = agregarnodo(raiz.derecha, etiqueta, desc, lleno);
                    }
                } else if ((raiz.derecha.descripcion == "kleen" && raiz.derecha.lleno == false) || (raiz.derecha.descripcion == "positiva" && raiz.derecha.lleno == false) || (raiz.derecha.descripcion == "aparicion" && raiz.derecha.lleno == false)) {

                    raiz.derecha = agregarnodo(raiz.derecha, etiqueta, desc, lleno);

                } else if ((raiz.derecha.descripcion == "kleen" && raiz.izquierda.lleno == true) || (raiz.derecha.descripcion == "positiva" && raiz.derecha.lleno == true) || (raiz.derecha.descripcion == "aparicion" && raiz.derecha.lleno == true)) {

                    raiz.lleno = true;
                    i--;
                } else if ((raiz.izquierda.descripcion == "Concatenacion" && raiz.izquierda.lleno == false) || (raiz.izquierda.descripcion == "Or" && raiz.izquierda.lleno == false)) {

                    raiz.izquierda = agregarnodo(raiz.izquierda, etiqueta, desc, lleno);

                }

            } else if ((raiz.izquierda.descripcion == "Concatenacion" && raiz.izquierda.lleno == false) || (raiz.izquierda.descripcion == "Or" && raiz.izquierda.lleno == false)) {

                raiz.izquierda = agregarnodo(raiz.izquierda, etiqueta, desc, lleno);

            } else if ((raiz.izquierda.descripcion == "Concatenacion" && raiz.izquierda.lleno == true) || (raiz.izquierda.descripcion == "Or" && raiz.izquierda.lleno == true)) {

                /*DERECHA*/
                if (raiz.derecha == null) {
                    if (desc == "identificador" || desc == "cadena") {

                        lleno = true;
                        raiz.derecha = agregarnodo(raiz.derecha, etiqueta, desc, lleno);
                        lleno = false;
                    } else {
                        lleno = false;
                        raiz.derecha = agregarnodo(raiz.derecha, etiqueta, desc, lleno);
                    }
                } else if ((raiz.derecha.descripcion == "kleen" && raiz.derecha.lleno == false) || (raiz.derecha.descripcion == "positiva" && raiz.derecha.lleno == false) || (raiz.derecha.descripcion == "aparicion" && raiz.derecha.lleno == false)) {

                    raiz.derecha = agregarnodo(raiz.derecha, etiqueta, desc, lleno);

                } else if ((raiz.derecha.descripcion == "kleen" && raiz.derecha.lleno == true) || (raiz.derecha.descripcion == "positiva" && raiz.derecha.lleno == true) || (raiz.derecha.descripcion == "aparicion" && raiz.derecha.lleno == true)) {

                    raiz.lleno = true;
                    i--;

                } else if ((raiz.derecha.descripcion == "Concatenacion" && raiz.derecha.lleno == false) || (raiz.derecha.descripcion == "Or" && raiz.derecha.lleno == false)) {

                    raiz.derecha = agregarnodo(raiz.derecha, etiqueta, desc, lleno);

                } else if ((raiz.derecha.descripcion == "Concatenacion" && raiz.derecha.lleno == true) || (raiz.derecha.descripcion == "Or" && raiz.derecha.lleno == true)) {

                    raiz.lleno = true;
                    i--;

                }

                //////////////////////////////////////////////////////////////////////////////////////////////    
            } else if (raiz.derecha == null) {
                if (raiz.descripcion == "kleen" || raiz.descripcion == "positiva" || raiz.descripcion == "aparicion") {
                    raiz.lleno = true;
                    i--;
                } else if (desc == "identificador" || desc == "cadena") {

                    lleno = true;
                    raiz.derecha = agregarnodo(raiz.derecha, etiqueta, desc, lleno);
                    lleno = false;

                } else {
                    lleno = false;
                    raiz.izquierda = agregarnodo(raiz.izquierda, etiqueta, desc, lleno);
                }

            } else if (raiz.descripcion == "kleen" || raiz.descripcion == "positiva" || raiz.descripcion == "aparicion") {

                raiz.lleno = true;
                i--;

            } else if (raiz.descripcion == "Concatenacion" || raiz.descripcion == "Or") {

                if (raiz.izquierda.descripcion == "identificador" && raiz.derecha.descripcion == "identificador") {
                    raiz.lleno = true;
                    i--;
                } else if (raiz.izquierda.descripcion == "identificador" && raiz.derecha.descripcion == "cadena") {
                    raiz.lleno = true;
                    i--;
                } else if (raiz.izquierda.descripcion == "cadena" && raiz.derecha.descripcion == "cadena") {
                    raiz.lleno = true;
                    i--;
                } else if (raiz.izquierda.descripcion == "cadena" && raiz.derecha.descripcion == "identificador") {
                    raiz.lleno = true;
                    i--;
                }
            }
        }
//FINAL DEL METODO
        return raiz;
    }

    public void agregar(String etiqueta, String desc, boolean lleno) {
        raiz = agregarnodo(raiz, etiqueta, desc, lleno);
    }

    public void recoridopreorder(Nodo nodo) {
        if (nodo != null) {
            recoridopreorder(nodo.izquierda);
            recoridopreorder(nodo.derecha);
            System.out.println(" " + nodo.etiquetas);
        }
    }

}

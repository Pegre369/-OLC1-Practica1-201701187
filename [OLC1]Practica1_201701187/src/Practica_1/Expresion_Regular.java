package Practica_1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class Expresion_Regular {

    public static ArrayList<Tokens> ListaTokens;
    public static String cadena;
    public static LinkedList<String> ER = new LinkedList();
    public static ArrayList<Lista_ER> Caracteres = new ArrayList<Lista_ER>();

    public void ER(ArrayList<Tokens> Aceptacion) throws IOException, InterruptedException {

        ListaTokens = Aceptacion;

        //Recorrido para sacar la ER de la tabla tokens
        for (int i = 0; i < ListaTokens.size(); i++) {

            //Verificar si es este Simbolo >
            if (ListaTokens.get(i).getId() == 36) {

                //System.out.println("Si");
                //Ciclo para validar todo lo que esta despues del > y antes del punto y coma
                while (ListaTokens.get(i).getId() != 31) {

                    //Verificar si es el punto de concatenacion
                    if (ListaTokens.get(i).getId() == 17) {

                        if (cadena == null) {
                            cadena = ListaTokens.get(i).getLexema();
                            i++;
                            //Valido todo lo que esta antes del punto y coma
                            while (ListaTokens.get(i).getId() != 31) {
                                cadena = cadena + ListaTokens.get(i).getLexema();
                                i++;
                            }
                            ER.add(cadena);
                            cadena = null;
                        }

                    } else {
                        i++;
                    }

                }

            }

        }

        //Verificar si mi Linkedlist esta llena
        /* for (int i = 0; i < ER.size(); i++) {
            if(ER.get(i)!=null){
              System.out.println(ER.get(i));
            }
        }    */
        Separacion();

    }

    public void agregar(String etiqueta, String descripcion) {

        Lista_ER nuevo = new Lista_ER(etiqueta, descripcion);
        Caracteres.add(nuevo);

    }

    public void Separacion() throws IOException, InterruptedException {

        String cc = "";
        String er = "";
        char caracter = ' ';
        int estado = 0;

        //Aqui recorro la linkedlist que contiene la ER 
        for (int i = 0; i < ER.size(); i++) {

            er = ER.get(i);

            //Aqui separo la ER de caracter por caracter y lo guardo en una linkedlist de caracteres
            for (int j = 0; j < er.length(); j++) {

                caracter = er.charAt(j);

                switch (estado) {

                    case 0:

                        if (caracter == (char) 46) {
                            agregar(Character.toString(caracter), "Concatenacion");
                            estado = 0;
                        } else if (caracter == (char) 124) {
                            agregar(Character.toString(caracter), "Or");
                            estado = 0;
                        } else if (caracter == (char) 63) {
                            agregar(Character.toString(caracter), "aparicion");
                            estado = 0;
                        } else if (caracter == (char) 42) {
                            agregar(Character.toString(caracter), "kleen");
                            estado = 0;
                        } else if (caracter == (char) 43) {
                            agregar(Character.toString(caracter), "positiva");
                            estado = 0;
                        } else if (caracter == (char) 34) {
                            estado = 1;
                        } else if (caracter == (char) 123) {
                            estado = 2;
                        } else if (caracter == (char) 59) {

                        }

                        break;

                    case 1:

                        if (caracter != (char) 34) {
                            cc += caracter;
                        } else {
                            
                            agregar(cc, "cadena");
                            cc = "";
                            estado = 0;
                        }

                        break;

                    case 2:

                        if (caracter != (char) 125) {
                            cc += caracter;
                        } else {
                            
                            agregar(cc, "identificador");
                            cc = "";
                            estado = 0;
                        }

                        break;

                }

            }

            //Verificacion si separa la Expresion Regular  es correcta 
          /*  for (int j = 0; j < Caracteres.size(); j++) {

                if (Caracteres.get(j) != null) {

                    System.out.println(Caracteres.get(j).getEtiqueta() + " -> " + Caracteres.get(j).getDescripcion());

                }
            }

            break;*/

        }
        
        Arbol Ab = new Arbol(Caracteres);

    }

}

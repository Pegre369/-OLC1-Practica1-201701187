package Practica_1;

import java.util.ArrayList;

public class Arbol {

    public static ArrayList<Tokens> ListaTokens;
    public static int contador = 0;
    public static String cadena;
    public static String[] ER = new String[1000];

    public void ER(ArrayList<Tokens> Aceptacion) {

        ListaTokens = Aceptacion;

        for (int i = 0; i < ListaTokens.size(); i++) {

            if (ListaTokens.get(i).getId() == 36) {

                System.out.println("Si");

                while (ListaTokens.get(i).getId() != 31) {

                    if (ListaTokens.get(i).getId() == 17) {

                        if (cadena == null) {
                            cadena = ListaTokens.get(i).getLexema();
                            i++;
                            while(ListaTokens.get(i).getId() != 31){
                                cadena = cadena + ListaTokens.get(i).getLexema();
                                i++;
                            }
                            ER[contador]= cadena;
                            cadena=null;
                            contador++;
                        }
                        
                    }else{
                        i++;
                    }
                    
                 
                }

            }

        }
        
        
        for (int i = 0; i < ER.length; i++) {
            if(ER[i]!=null){
              System.out.println(ER[i]);
            }
        }
        
    }

}

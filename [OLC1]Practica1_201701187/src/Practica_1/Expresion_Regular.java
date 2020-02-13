package Practica_1;

import java.util.ArrayList;
import java.util.LinkedList;

public class Expresion_Regular {

    public static ArrayList<Tokens> ListaTokens;
    public static String cadena;
    public static LinkedList<String> ER = new LinkedList();
    public static LinkedList<String> Caracteres = new LinkedList();
    
    public void ER(ArrayList<Tokens> Aceptacion) {

        ListaTokens = Aceptacion;

        for (int i = 0; i < ListaTokens.size(); i++) {

            if (ListaTokens.get(i).getId() == 36) {

                //System.out.println("Si");

                while (ListaTokens.get(i).getId() != 31) {

                    if (ListaTokens.get(i).getId() == 17) {

                        if (cadena == null) {
                            cadena = ListaTokens.get(i).getLexema();
                            i++;
                            while(ListaTokens.get(i).getId() != 31){
                                cadena = cadena + ListaTokens.get(i).getLexema();
                                i++;
                            }
                            ER.add(cadena);
                            cadena=null;
                        }
                        
                    }else{
                        i++;
                    }
                    
                 
                }

            }

        }
        
        
       /* for (int i = 0; i < ER.size(); i++) {
            if(ER.get(i)!=null){
              System.out.println(ER.get(i));
            }
        }    */    
        
        Separacion();
        
    }
    
    public void Separacion(){
        
            String cc = "";
            String er ="";
            char caracter =' ';
            int estado = 0;
            
            for (int i = 0; i < ER.size(); i++) {
            
                er = ER.get(i);
                
                for (int j = 0; j < er.length(); j++) {
                    
                    
                    caracter = er.charAt(i);
                    
                    switch(estado){
                    
                        case 0:
                        
                                if(caracter == (char)46){
                                    Caracteres.add(Character.toString(caracter));
                                    estado = 0;
                                }else if(caracter == (char)124){
                                    Caracteres.add(Character.toString(caracter));
                                    estado = 0;
                                }else if(caracter==(char)63){
                                    Caracteres.add(Character.toString(caracter));
                                    estado = 0;
                                }else if(caracter==(char)42){
                                    Caracteres.add(Character.toString(caracter));
                                    estado = 0;
                                }else if(caracter==(char)43){
                                    Caracteres.add(Character.toString(caracter));
                                    estado = 0;
                                }else if(caracter==(char)47){
                                    estado = 1;
                                }else if(caracter==(char)123){
                                    estado = 2;
                                }else if(caracter==(char)59){
                                   
                                }
                            
                            
                        break;
                    
                        
                        case 1:
                            
                                if(caracter!=(char)47){
                                    cc += caracter;
                                }else{
                                    Caracteres.add(cc);
                                    cc="";
                                    estado =0;
                                }
                        
                        break;
                        
                        case 2:
                            
                                if(caracter!=(char)125){
                                    cc += caracter;
                                }else{
                                    Caracteres.add(cc);
                                    cc="";
                                    estado =0;
                                }
                            
                        break;
                        
                    
                    }
                        
                    
                    
                    
                    
                }
                
                
                for (int j = 0; j < Caracteres.size(); j++) {
                    
                    if(Caracteres.get(j)!= null){
                        
                    System.out.println(Caracteres.get(j));
                
                    }
                }
                
                break;
                
        }
            
            
            
        
    }
    
    
}

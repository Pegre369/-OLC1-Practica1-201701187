package Practica_1;

import java.util.ArrayList;


public class Arbol {
    
    //Clase del nodo
     class Nodo {
        
        public String etiquetas;
        public Nodo derecha;
        public Nodo izquierda;
        public String descripcion;
       
        public Nodo(String etiqueta, String des){
            
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
     
     public void Asignacion(ArrayList<Lista_ER> Caracteres){
        
        cara = Caracteres;
        
   //     raiz.izquierda = new Nodo(".","concatenacion");        
   //     raiz.derecha = new Nodo("#","Cerradura");        
   //     raiz.izquierda = new Nodo(".","concatenacion");        
        
        for(int i = 0; i<cara.size();i++){
            
           // System.out.println(cara.get(i).getEtiqueta()+ " -> "+cara.get(i).getDescripcion());
            
        }
         
        
     }
   
     public void agregarnodo(String etiqueta, String desc){
         
         
         
         
     }
     
}

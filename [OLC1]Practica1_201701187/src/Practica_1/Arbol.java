package Practica_1;


public class Arbol {
    
    //Clase del nodo
     class Nodo {
        
        public String etiquetas;
        public Nodo derecha;
        public Nodo izquierda;
       
        public Nodo(String etiqueta){
            
            etiquetas = etiqueta;
            derecha = null;
            izquierda = null;
            
        }
        
       }
     
     
    // Clase del arbol
     
     Nodo raiz;
     
    public Arbol() {
        
        raiz = null;
        
    }
     
    
    public void incertar(Object etiqueta){
        
    }
    
    
    
    
    
    
    
}

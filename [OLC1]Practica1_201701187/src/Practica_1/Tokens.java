
package Practica_1;


public class Tokens {
    
     private String lexema;
        private int id;
        private String descripcion;
        private int fila;
        private int columna;

    public Tokens(String lexema, int id, String descripcion, int fila, int columna) {
        this.lexema = lexema;
        this.id = id;
        this.descripcion = descripcion;
        this.fila = fila;
        this.columna = columna;
    }

    Tokens(String descripcion, String lexema, int fila, int columna, int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getLexema() {
        return lexema;
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }
       
}

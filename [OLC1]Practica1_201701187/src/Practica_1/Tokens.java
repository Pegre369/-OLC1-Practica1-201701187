
package Practica_1;


public class Tokens {
    
     private String lexema;
        private int id;
        private String descripcion;
        private int fila;
        private int columna;

    public Tokens( String descripcion, String lexema, int fila, int columna,int id) {
        this.lexema = lexema;
        this.id = id;
        this.descripcion = descripcion;
        this.fila = fila;
        this.columna = columna;
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

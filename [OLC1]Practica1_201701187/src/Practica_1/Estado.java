package Practica_1;

public class Estado {

    private String estado;
    private String lista;
    private String simbolo;

    public Estado(String estado, String lista, String simbolo) {
        this.estado = estado;
        this.lista = lista;
        this.simbolo = simbolo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getLista() {
        return lista;
    }

    public void setLista(String lista) {
        this.lista = lista;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }
    

}

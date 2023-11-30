package Model;

public class Player {
    private int numero;
    private String nombre;
    private String posicion;

    public Player(int numero, String nombre, String posicion) {
        this.numero = numero;
        this.nombre = nombre;
        this.posicion = posicion;
    }

    public int getNumero() {
        return numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }
}

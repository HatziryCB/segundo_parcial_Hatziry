/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaClass;

/**
 *
 * @author Hatziry Chacón
 */
public class Libro {

    private int codigo;
    private String nombre;
    private String tapa;
    private int autor;
    private String editorial;
    private String año;

    public Libro(int codigo, String nombre, String tapa, int autor, String editorial, String año) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tapa = tapa;
        this.autor = autor;
        this.editorial = editorial;
        this.año = año;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTapa() {
        return tapa;
    }

    public void setTapa(String tapa) {
        this.tapa = tapa;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public int getAutor() {
        return autor;
    }

    public void setAutor(int autor) {
        this.autor = autor;
    }

    

}

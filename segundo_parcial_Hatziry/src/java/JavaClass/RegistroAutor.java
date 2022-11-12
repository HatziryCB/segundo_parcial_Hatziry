/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaClass;

import ConexionBaseDeDatos.ConexionBaseDeDatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Hatziry Chacón
 */
public class RegistroAutor {
    Autor[] vectorAutor;
    int indice;
    private ConexionBaseDeDatos conectorBD;
    private Connection conexion;
    private PreparedStatement statement = null;
    private ResultSet result = null;

    public RegistroAutor() {
        this.vectorAutor = new Autor[100];
        this.indice = 0;
    }
    
    public void almacenar(Autor autor){
        this.vectorAutor[indice]=autor;
        this.indice=indice+1;
    }
    
    public Autor[] mostrar(){
        return this.vectorAutor;
    }
    public void iniciarConexion() {
        conectorBD = new ConexionBaseDeDatos();
        conexion = conectorBD.conectar();
    }

    public String guardarLibroBD(Autor autor) {
        String sql = "INSERT INTO biblioteca.autor(codigo, nombre, genero, origen, fecha)";
        sql += "VALUES (?,?,?,?,?)";

        try {
            iniciarConexion();
            statement = conexion.prepareStatement(sql);
            statement.setInt(1, autor.getCodigo());
            statement.setString(2, autor.getNombre());
            statement.setString(3, autor.getGenero());
            statement.setString(4, autor.getOrigen());
            statement.setString(5, autor.getFecha());
            int resultado = statement.executeUpdate();
            // podemos colocar en vez de resultado el llamado de la función 
            // prstmt.executeUpdate() => if(prstmt.executeUpdate() > 0)
            if (resultado > 0) {
                return String.valueOf(resultado);
            } else {
                return String.valueOf(resultado);
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }

    public void getClientes2(StringBuffer respuesta) {
        String sql = "select * from biblioteca.autor";
        try {
            iniciarConexion();
            respuesta.setLength(0);
            statement = conexion.prepareStatement(sql);
            result = statement.executeQuery();
            if (result != null) {
                while (result.next()) {
                    respuesta.append("<tr>");
                    //nombre de los encabezados en las columnas del query en mySQL Workbench, deben estar todos en el mismo orden
                    respuesta.append("<td >").append(result.getString("codigo")).append("</td>");
                    respuesta.append("<td >").append(result.getString("nombre")).append("</td>");
                    respuesta.append("<td >").append(result.getString("genero")).append("</td>");
                    respuesta.append("<td >").append(result.getString("origen")).append("</td>");
                    respuesta.append("<td >").append(result.getString("fecha")).append("</td>");
                    respuesta.append("<td id=\"").append(result.getString("codigo"))
                            .append("\"  onclick=\"eliminar(this.id);\">")
                            .append(" <a class=\"btn-group btn-group-md btn-warning\"'><i class=\"bi bi-vector-pen\"></i>  </a>"
                                    + " <a class=\"btn-group btn-group-md btn-danger\"'> <i class=\"bi bi-trash3\"></i> </a>"
                                    + " <td></tr>");
                }
            } else {
                respuesta.append("error al consultar");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public String eliminarLibro(int cdAutor) {
        String sql = "DELETE FROM autor WHERE codigo=" + cdAutor;
        try {
            iniciarConexion();
            statement = conexion.prepareStatement(sql);
            int resultado = statement.executeUpdate();
            if (resultado > 0) {
                return String.valueOf(resultado);
            } else {
                return String.valueOf(resultado);
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
}

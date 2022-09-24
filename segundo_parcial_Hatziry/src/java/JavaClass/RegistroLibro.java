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
public class RegistroLibro {
    Libros[] vectorLibros;
    int indice;
    private ConexionBaseDeDatos conectorBD;
    private Connection conexion;
    private PreparedStatement statement = null;
    private ResultSet result = null;

    public RegistroLibro() {
        this.vectorLibros = new Libros[100];
        this.indice = 0;
    }
    
    public void almacenar(Libros libro){
        this.vectorLibros[indice]=libro;
        this.indice=indice+1;
    }
    
    public Libros[] mostrar(){
        return this.vectorLibros;
    }
    public void iniciarConexion() {
        conectorBD = new ConexionBaseDeDatos();
        conexion = conectorBD.conectar();
    }

    public String guardarLibroBD(Libros libros) {
        String sql = "INSERT INTO biblioteca.libro(codigo, nombre_libro, tipo_de_pasta, editorial, anio_publicacion)";
        sql += "VALUES (?,?,?,?,?)";

        try {
            iniciarConexion();
            statement = conexion.prepareStatement(sql);
            statement.setInt(1, libros.getCodigo());
            statement.setString(2, libros.getNombre());
            statement.setString(3, libros.getTapa());
            statement.setString(4, libros.getEditorial());
            statement.setString(5, libros.getAño());
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
        String sql = "select * from universidad.cliente";
        try {
            iniciarConexion();
            respuesta.setLength(0);
            statement = conexion.prepareStatement(sql);
            result = statement.executeQuery();
            if (result != null) {
                while (result.next()) {
                    respuesta.append("<tr>");
                    //nombre de los encabezados en las columnas del query en mySQL Workbench, deben estar todos en el mismo orden
                    respuesta.append("<td >").append(result.getString("nombre")).append("</td>");
                    respuesta.append("<td >").append(result.getString("apellido")).append("</td>");
                    respuesta.append("<td >").append(result.getString("codigo")).append("</td>");
                    respuesta.append("<td >").append(result.getString("telefono")).append("</td>");
                    respuesta.append("<td >").append(result.getString("correo")).append("</td>");
                    respuesta.append("<td >").append(result.getString("ciudad")).append("</td>");
                    respuesta.append("<td id=\"").append(result.getString("codigo"))
                            .append("\"  onclick=\"eliminar3(this.id);\">")
                            .append(" <a class=\"btn btn-warning\"'><i class=\"bi bi-vector-pen\"></i>  </a>"
                                    + " <a class=\"btn btn-danger\"'> <i class=\"bi bi-trash3\"></i> </a>"
                                    + " <td></tr>");
                }
            } else {
                respuesta.append("error al consultar");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public String eliminarCliente(int carne) {
        String sql = "DELETE FROM cliente WHERE codigo=" + carne;
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

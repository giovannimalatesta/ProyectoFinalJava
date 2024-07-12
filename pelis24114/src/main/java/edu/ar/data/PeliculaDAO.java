package edu.ar.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.ar.model.Pelicula;
import static edu.ar.data.Conexion.getConexion;
import static edu.ar.data.Conexion.close;


public class PeliculaDAO {

    private static final String SQL_SELECT = "SELECT * from movie";
    private static final String SQL_INSERT = 
    "INSERT INTO movie (titulo, descripcion, genero, calificacion, anio, estrellas, director) values(?,?,?,?,?,?,?);";
    private static final String SQL_SELECT_BY_ID = "SELECT * from movie where id = ?";


    public static List<Pelicula> obtener(){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Pelicula pelicula = null;
        List<Pelicula> peliculas = new ArrayList<>();

        try {
            conn = getConexion();
            ps = conn.prepareStatement(SQL_SELECT);
            rs = ps.executeQuery();

            //itero resultados del result set
            while(rs.next()){
                int id = rs.getInt("id");
                String titulo = rs.getString("titulo");
                String descripcion = rs.getString("descripcion");
                String genero = rs.getString("genero");
                int calificacion = rs.getInt("calificacion");
                int anio = rs.getInt("anio");
                byte estrellas = rs.getByte("estrellas");
                String director = rs.getString("director");

                pelicula = new Pelicula(id, titulo, descripcion, genero, calificacion, anio, estrellas, director);
                
                //agregamos peli al listado
                peliculas.add(pelicula);
            }   


        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(ps);
                close(conn);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
        return peliculas;

    }


    //metodo insercion
    public static int insertar(Pelicula peli){
        Connection conn = null;
        PreparedStatement ps = null;
        int registros = 0;

        try {
            conn = getConexion();
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setString(1, peli.getTitulo());
            ps.setString(2, peli.getDescripcion());
            ps.setString(3, peli.getGenero());
            ps.setInt(4, peli.getCalificacion());
            ps.setInt(5, peli.getAnio());
            ps.setByte(6, peli.getEstrellas());
            ps.setString(7, peli.getDirector());
            registros = ps.executeUpdate();


        } catch (Exception e) {
            e.printStackTrace(System.out);
        }finally{
            try {
                close(ps);
                close(conn);
            } catch (Exception ex) {
               
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }


         //Seleccionar pelicula usando ID
    public static Pelicula seleccionarPorId(int id){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Pelicula pelicula = null;

        try {
            conn = getConexion();
            ps = conn.prepareStatement(SQL_SELECT_BY_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while(rs.next()){
                int idPeli = rs.getInt("id");
                String titulo = rs.getString("titulo");
                String descripcion = rs.getString("descripcion");
                String genero = rs.getString("genero");
                int calificacion = rs.getInt("calificacion");
                int anio = rs.getInt("anio");
                byte estrellas = rs.getByte("estrellas");
                String director = rs.getString("director");

                pelicula = new Pelicula(idPeli, titulo, descripcion, genero, calificacion, anio, estrellas, director);


            }

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }finally{
            try {
                close(rs);
                close(ps);
                close(conn);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
        return pelicula;


    }
}

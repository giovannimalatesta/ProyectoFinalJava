package edu.ar.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

//clase que se encarga de conectarse con DB

public class Conexion {
    
    private final static String JDBC_URL = "jdbc:mysql://localhost:3306/peliculas?useSSL=false&useTimeZone=true&serverTimeZone=UTC&allowPublicKeyRetrieval=true";
    private final static String JDBC_USER = "root";
    private final static String JDBC_PASS = "";

    public static DataSource getDataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl(JDBC_URL);
        ds.setUsername(JDBC_USER);
        ds.setPassword(JDBC_PASS);
        ds.setInitialSize(100);
        return ds;
    }

    public static Connection getConexion() throws SQLException{

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException ex){
            ex.printStackTrace(System.out);
        }
        return getDataSource().getConnection();
    }

    public static void close (ResultSet rs) throws SQLException{
        rs.close();
    }
    public static void close (Statement st) throws SQLException{
        st.close();
    } 
    public static void close (Connection cn) throws SQLException{
        cn.close();
    }


}

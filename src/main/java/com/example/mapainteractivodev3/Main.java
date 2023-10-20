package com.example.mapainteractivodev3;
import java.sql.*;
public class Main {
    public static void main(String[] args)  {

        Connection BaseDatos = null;
        Statement st = null;

        //Donde se localiza la base de datos
        String url="jdbc:postgresql://localhost:5432/postgres";

        //Credenciales de la base de datos
        String usuario="postgres";
        String contrasena="1234";

        try {
            //Conexion con la base de datos
            BaseDatos = DriverManager.getConnection(url, usuario, contrasena);

            // Se hara una consulta  de la tabla CDS y Cantante, y se mandara a imprimir.
            st = BaseDatos.createStatement();
            ResultSet rs = st.executeQuery( "SELECT \"Id_evento\", \"nombre_evento\", \"id_local\" "
                    + "FROM \"eventos\" ");

            while    ( rs.next() ) {

                int id = rs.getInt("Id_evento");
                String evento= rs.getString("nombre_evento");
                String local= rs.getString("id_local");

                System.out.println( "[ FILA #" + id+" ]" );
                System.out.println( "Nombre del evento: " + evento );
                System.out.println( "Id del local: " + local );
                System.out.println();
            }

            rs.close();
            st.close();
            BaseDatos.close();
        } catch (Exception e) {
            System.err.println( e.getMessage() );
        }
    }

}
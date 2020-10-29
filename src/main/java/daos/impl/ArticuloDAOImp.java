package daos.impl;

import daos.ArticuloDAO;
import exception.DAOException;
import model.Articulo;

import java.sql.*;

public class ArticuloDAOImp implements ArticuloDAO {


    private Connection getConnection() throws DAOException {

        Connection connection = null;

        try {
            String url = "jdbc:mysql://localhost:3306/Facturacion";
            String usuario = "root";
            String clave = "";
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, usuario, clave);
            return connection;

        } catch (Exception ex) {

            throw new DAOException("Error al cerrar la conexion " + ex.getCause());
        }
    }
    /**
     *
     * @param conn
     */

    private void closeConnection(Connection conn){

        try {
            conn.close();
        }catch (Exception ex){

            ex.printStackTrace();
        }
    }

    /**
     *
     * @param articulo
     */

    public void insert(Articulo articulo) throws DAOException {


        Connection conn = this.getConnection();


        try{

            String consulta="insert into Articulo (descripcion, precio) values(" +
                                                                    articulo.getDescripcion() + ","  +
                                                                    articulo.getPrecio() + ")";

            Statement sentencia = conn.createStatement();
            sentencia.execute(consulta);

        }catch (Exception ex){

            ex.printStackTrace();
        }finally {

            closeConnection(conn);
        }


    }

    /**
     *
     * @param articulo
     */

    public void update(Articulo articulo) throws DAOException {

        Connection conn = this.getConnection();

        try{

            String consulta=  "update  Articulo set descripcion = " + articulo.getDescripcion() +
                                              "set precio =  " + articulo.getPrecio() +
                                              " where id = " + articulo.getIdArticulo() ;

            Statement sentencia = conn.createStatement();
            sentencia.execute(consulta);

        }catch (Exception ex){

            ex.printStackTrace();
        }finally {

            closeConnection(conn);
        }


    }

    public void delete(Integer id) {

    }

    /**
     *
     * @param id
     * @return Articulo
     */

    public Articulo queyId(Integer id) throws DAOException {

        Connection conn = this.getConnection();
        Articulo articulo = null;

        try{

            String consulta=  "select *  from Articulo  where id = " + id ;

            Statement sentencia = conn.createStatement();
            sentencia.execute(consulta);

            ResultSet rs = sentencia.getResultSet();

            if(rs.next()){

                articulo.setIdArticulo(rs.getInt("id"));
                articulo.setDescripcion(rs.getString("descripcion"));
                articulo.setPrecio(rs.getFloat("precio"));
            }


        }catch (Exception ex){

            ex.printStackTrace();
        }finally {

            closeConnection(conn);

            return articulo;
        }

    }
}

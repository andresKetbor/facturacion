import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import java.sql.Connection;

public class Main {


    public static void main(String args[])  {

      //LocalDate date= LocalDate.now();
      Connection conexion;
      String url="jdbc:mysql://localhost:3306/Facturacion";
      String usuario="root";
      String clave="";
      String consulta="select * from Cliente where id=4";

      String consulta2 ="select * from Articulo";


      try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conexion = DriverManager.getConnection(url, usuario, clave);
        Statement sentencia = conexion.createStatement();
        ResultSet rs = sentencia.executeQuery(consulta);

        while (rs.next()) {
          Cliente cli = new Cliente(rs.getString("Nombre"), rs.getString("Apellido"));
        }
        rs= null;

        rs = sentencia.executeQuery(consulta2);

        Factura factura = new Factura();


        while(rs.next()){

          Articulo articulo = new Articulo();

          articulo.setDescripcion(rs.getString("descripcion"));
          articulo.setIdArticulo(rs.getInt("id"));
          articulo.setPrecio(rs.getFloat("precio"));

          FacturaItem item = new FacturaItem();

          item.setArticulo(articulo);
          item.setCantidad((short)3);

          factura.addItem(item);


        }

        conexion.close();


        factura.calcularFactura();



      }catch (Exception ex){

        ex.printStackTrace();
      }












    }
}

import java.sql.DriverManager;
import java.sql.Statement;
import java.util.*;
import java.sql.Connection;

public class Main {


    public static void main(String args[])  {

      Connection conexion;
      String url="jdbc:mysql://localhost:3306/Facturacion";
      String usuario="root";
      String clave="";
      String consulta="insert into Factura (Fecha) values (" + new Date() +  ")";


      try {

        Class.forName("com.mysql.jdbc.Driver");
        conexion = DriverManager.getConnection(url, usuario, clave);
        Statement sentencia = conexion.createStatement();
        sentencia.execute(consulta);
      }catch (Exception ex){

          ex.printStackTrace();
      }

      Cliente cli = new Cliente("juan","perez");

      Articulo papa = new Articulo();

      papa.setDescripcion("papas");
      papa.setIdArticulo(1);
      papa.setPrecio(35.8F);

      Articulo zanahoria = new Articulo();

      zanahoria.setIdArticulo(2);
      zanahoria.setDescripcion("zanahoraia");
      zanahoria.setPrecio(53.8F);

      FacturaItem item = new FacturaItem();
      FacturaItem item2 = new FacturaItem();


      item.setArticulo(papa);
      item.setCantidad((short) 2);
      item.setIdItem(3);

      Factura factura = new Factura();

      factura.addItem(item);

      item.setCantidad((short) 4);

      item2.setArticulo(zanahoria);
      item2.setCantidad((short) 3);
      item2.setIdItem(4);


      factura.addItem(item2);

      factura.calcularFactura();






    }
}

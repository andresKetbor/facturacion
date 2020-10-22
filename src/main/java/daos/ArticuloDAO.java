package daos;

import model.*;

public interface ArticuloDAO {

   public void insert(Articulo articulo);
   public void update(Articulo articulo);
   public void delete(Integer id);
   public Articulo queyId(Integer id);
}

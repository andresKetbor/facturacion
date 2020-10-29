package daos;

import exception.DAOException;
import model.*;

public interface ArticuloDAO {

   public void insert(Articulo articulo) throws DAOException;
   public void update(Articulo articulo) throws DAOException;
   public void delete(Integer id);
   public Articulo queyId(Integer id) throws DAOException;
}

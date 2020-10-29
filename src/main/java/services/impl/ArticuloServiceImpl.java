package services.impl;

import daos.ArticuloDAO;
import daos.impl.ArticuloDAOImp;
import dtos.ArticuloDTO;
import exception.DAOException;
import exception.ServiceException;
import model.Articulo;
import services.ArticuloService;

public class ArticuloServiceImpl implements ArticuloService {

    private ArticuloDAO articuloDAO = new ArticuloDAOImp();

    public void ingresarArticulo(ArticuloDTO articuloDTO) throws ServiceException {

      Articulo articulo = new Articulo();

        try {
            articuloDAO.insert(articulo);
        } catch (DAOException e) {
            e.printStackTrace();
            throw new ServiceException("Error al ingresar Artículo " + e.getStackTrace());
        }


    }

    public void consultarArticulo(Integer idArticulo) {

    }


}

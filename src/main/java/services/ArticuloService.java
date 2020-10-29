package services;

import dtos.ArticuloDTO;
import exception.ServiceException;

public interface ArticuloService {

    public void ingresarArticulo(ArticuloDTO articuloDTO)throws ServiceException;
    public void consultarArticulo(Integer idArticulo);

}

package services;

import dtos.ArticuloDTO;

public interface ArticuloService {

    public void ingresarArticulo(ArticuloDTO articuloDTO);
    public void consultarArticulo(Integer idArticulo);

}

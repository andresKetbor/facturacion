package services;

import dtos.FacturaDTO;
import dtos.FacturaItemDTO;
import model.Factura;
import model.FacturaItem;

import java.util.List;

public interface FacturaService {

    void calcularFactura(List<FacturaItemDTO> item);
    void ingresarFactura(FacturaDTO fac);

}

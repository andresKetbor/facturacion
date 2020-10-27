package services.impl;

import daos.FacturaDAO;
import daos.impl.FacturaDAOImp;
import dtos.FacturaDTO;
import dtos.FacturaItemDTO;
import model.Factura;
import services.FacturaService;

import java.util.List;

public class FacturaServiceImpl implements FacturaService {

    private FacturaDAO facturaDAO;

    public FacturaServiceImpl(){
        facturaDAO = new FacturaDAOImp();
    }

    public void calcularFactura(List<FacturaItemDTO> item) {

    }

    public void ingresarFactura(FacturaDTO fac) {

        Factura factura = converter(fac);

        facturaDAO.insert(factura);
    }


    private Factura converter(FacturaDTO facturaDTO){

        Factura factura = new Factura();

        factura.setFechaFactura(facturaDTO.getFecha());

        return  factura;
    }

}

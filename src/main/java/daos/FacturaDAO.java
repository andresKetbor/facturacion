package daos;

import model.Factura;

public interface FacturaDAO {

    public void insert(Factura factura);
    public void update(Factura factura);
    public void delete(Integer id);
    public Factura queyId(Integer id);
}

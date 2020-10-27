package dtos;

public class FacturaItemDTO {

    private Integer idItem;
    private Short cantidad;
    private Integer idArticulo;

    public Integer getIdItem() {
        return idItem;
    }

    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }

    public Short getCantidad() {
        return cantidad;
    }

    public void setCantidad(Short cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(Integer idArticulo) {
        this.idArticulo = idArticulo;
    }
}

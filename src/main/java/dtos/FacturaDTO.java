package dtos;

import model.FacturaItem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FacturaDTO {

    private Date fecha;
    private List<FacturaItemDTO> items = new ArrayList<FacturaItemDTO>();

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<FacturaItemDTO> getItems() {
        return items;
    }

    public void setItems(List<FacturaItemDTO> items) {
        this.items = items;
    }
}

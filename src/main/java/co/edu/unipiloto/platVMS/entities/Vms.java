package co.edu.unipiloto.platVMS.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Vms {

    @Id
    private String id;
    private int kilometro;
    private String ubicacion;
    private String tipo;
    private String carretera;
    private boolean estado;

    public Vms(int kilometro, String ubicacion, String tipo, String carretera, boolean estado) {
        this.kilometro = kilometro;
        this.ubicacion = ubicacion;
        this.tipo = tipo;
        this.carretera = carretera;
        this.estado = estado;
    }
}

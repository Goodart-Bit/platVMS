package co.edu.unipiloto.platVMS.entities;

import com.mongodb.lang.NonNull;
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
    @NonNull
    private double[] coordenadas;
    private String tipo;
    @NonNull
    private boolean estado;

    public Vms(double[] coordenadas, String tipo, boolean estado) {
        this.coordenadas = coordenadas;
        this.tipo = tipo;
        this.estado = estado;
    }
}

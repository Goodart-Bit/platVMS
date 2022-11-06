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

    private String idViaAsignada;
    @NonNull
    private boolean estado;

    public Vms(@NonNull double[] coordenadas, String tipo, String idViaAsignada, boolean estado) {
        this.coordenadas = coordenadas;
        this.tipo = tipo;
        this.idViaAsignada = idViaAsignada;
        this.estado = estado;
    }

    public String getId() {
        return id;
    }

    @NonNull
    public double[] getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(@NonNull double[] coordenadas) {
        this.coordenadas = coordenadas;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getIdViaAsignada() {
        return idViaAsignada;
    }

    public void setIdViaAsignada(String idViaAsignada) {
        this.idViaAsignada = idViaAsignada;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}

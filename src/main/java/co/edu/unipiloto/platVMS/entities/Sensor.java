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
public class Sensor {

    @Id
    private String id;

    private Via viaCubierta;
    private String tipo;

    private double[] coordenadas;
    private boolean estado;

    public Sensor(String tipo, boolean estado, Via viaCubierta) {
        this.tipo = tipo;
        this.estado = estado;
        this.viaCubierta = viaCubierta;
        this.coordenadas = viaCubierta.getPuntoReferencia();
    }

    public Via getViaCubierta() {
        return viaCubierta;
    }

    public void setViaCubierta(Via viaCubierta) {
        this.viaCubierta = viaCubierta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double[] getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(double[] coordenadas) {
        this.coordenadas = coordenadas;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}

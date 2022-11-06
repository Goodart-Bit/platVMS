package co.edu.unipiloto.platVMS.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@NoArgsConstructor
public class Via {

    @Id
    private String id;
    private String nombre;
    private String municipio;
    private double[] puntoReferencia; //long, lat

    public Via(String nombre, String municipio, double[] puntoReferencia) {
        this.nombre = nombre;
        this.municipio = municipio;
        this.puntoReferencia = puntoReferencia;
    }

    public Via(String nombre, String municipio) {
        this.nombre = nombre;
        this.municipio = municipio;
        this.puntoReferencia = new double[] {0.0 , 0.0};
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public double[] getPuntoReferencia() {
        return puntoReferencia;
    }

    public void setPuntoReferencia(double[] puntoReferencia) {
        this.puntoReferencia = puntoReferencia;
    }
}

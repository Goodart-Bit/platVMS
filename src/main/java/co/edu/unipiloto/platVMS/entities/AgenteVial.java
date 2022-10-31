package co.edu.unipiloto.platVMS.entities;


import com.mongodb.lang.NonNull;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class AgenteVial {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    @Indexed(unique = true)
    private String email;
    @NonNull
    private String ubicacionAsignada;

    public AgenteVial(String firstName, String lastName, String email, String ubicacionAsignada) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.ubicacionAsignada = ubicacionAsignada;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @NonNull
    public String getUbicacionAsignada() {
        return ubicacionAsignada;
    }

    public void setUbicacionAsignada(@NonNull String ubicacionAsignada) {
        this.ubicacionAsignada = ubicacionAsignada;
    }
}

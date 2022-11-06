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
    private String idViaAsignada;

    public AgenteVial(String firstName, String lastName, String email, String idViaAsignada) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.idViaAsignada = idViaAsignada;
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
    public String getIdViaAsignada() {
        return idViaAsignada;
    }

    public void setIdViaAsignada(String idViaAsignada) {
        this.idViaAsignada = idViaAsignada;
    }
}

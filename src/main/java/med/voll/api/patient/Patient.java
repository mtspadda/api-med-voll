package med.voll.api.patient;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import med.voll.api.adress.Adress;

@Entity
@Table(name = "patient")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

    @Id
    private Long id;

    private String name;

    private String phoneNumber;

    @Embedded
    private Adress adress;


    public Patient(PatientData data){
        this.name = data.name();
        this.phoneNumber = data.phoneNumber();
        this.adress = new Adress(data.adress());
    }

}

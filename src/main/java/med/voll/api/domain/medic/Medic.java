package med.voll.api.domain.medic;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.domain.adress.Adress;

@Entity
@Table(name = "medic")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String crm;

    @Enumerated(EnumType.STRING)
    private Speciality speciality;

    @Embedded
    private Adress adress;

    private String phone;

    private Boolean status;


    public Medic(MedicData data) {
        this.name = data.name();
        this.email = data.email();
        this.crm = data.crm();
        this.speciality = data.speciality();
        this.adress = new Adress(data.adress());
        this.phone = data.phone();
    }

    public void updateInfo(DataUpdateMedic dataUpdateMedic) {
        if (dataUpdateMedic.name() != null){
            this.name = dataUpdateMedic.name();
        }
        if (dataUpdateMedic.phoneNumber() != null){
            this.phone = dataUpdateMedic.phoneNumber();
        }
        if (dataUpdateMedic.adressData() != null){
            this.adress.updateAdress(dataUpdateMedic.adressData());
        }
    }

    public void delete() {
        this.status = false;
    }
}

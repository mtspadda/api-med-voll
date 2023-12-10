package med.voll.api.medic;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.adress.Adress;

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
    private Specialty specialty;

    @Embedded
    private Adress adress;

    private String phone;


    public Medic(MedicData data) {
        this.name = data.name();
        this.email = data.email();
        this.crm = data.crm();
        this.specialty = data.specialty();
        this.adress = new Adress(data.adress());
        this.phone = data.phone();
    }
}

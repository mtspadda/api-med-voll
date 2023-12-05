package med.voll.api.adress;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Adress {

    private String street;

    @Column(name = "zipcode")
    private String zipcode;

    private String city;

    private Integer number;

    public Adress(AdressData adress) {
        this.street = adress.street();
        this.zipcode = adress.zipcode();
        this.city = adress.city();
        this.number = adress.number();
    }
}

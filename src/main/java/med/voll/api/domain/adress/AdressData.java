package med.voll.api.domain.adress;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AdressData(
        @NotBlank
        String street,
        @NotNull
        String zipcode,
        @NotNull
        String city,
        Integer number) {
}

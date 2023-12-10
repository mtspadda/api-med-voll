package med.voll.api.medic;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.adress.AdressData;

public record MedicData(
        @NotBlank // Only for strings
        String name,
        @NotBlank @Email
        String email,

        @NotBlank @Pattern(regexp = "\\d{4,6}")
        String crm,

        @NotNull
        Specialty specialty,

        @NotNull @Valid
        AdressData adress,

        @NotBlank
        String phone
) {


}

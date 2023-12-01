package med.voll.api.medic;

import med.voll.api.adress.AdressData;

public record MedicData(String name, String email, String crm, Specialty specialty, AdressData adress) {
}

package med.voll.api.domain.patient;

import med.voll.api.domain.adress.AdressData;

import java.time.LocalDate;

public record PatientData(String name, String phoneNumber, LocalDate birthDate, AdressData adress) {
}

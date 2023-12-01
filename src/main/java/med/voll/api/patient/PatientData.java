package med.voll.api.patient;

import med.voll.api.adress.AdressData;

import java.time.LocalDate;

public record PatientData(String name, String phoneNumber, LocalDate birthDate, AdressData adress) {
}

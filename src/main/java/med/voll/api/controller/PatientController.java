package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.patient.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("patient")
public class PatientController {

    @Autowired
    private PatientRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity save(@RequestBody @Valid PatientData data, UriComponentsBuilder uriComponentsBuilder) {
        var patient = new Patient(data);
        repository.save(patient);

        var URI = uriComponentsBuilder.path("/patient/{id}").buildAndExpand(patient.getId()).toUri();

        return ResponseEntity.created(URI).body(new DataListPatient(patient));
    }

    @GetMapping
    public ResponseEntity<Page<DataListPatient>> listing(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable) {
        var page = repository.findAll(pageable).map(DataListPatient::new);
        return ResponseEntity.ok(page);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletePatient(@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid DataUpdatePatient dataUpdatePatient){
        var patient = repository.getReferenceById(dataUpdatePatient.id());
        patient.updatePatient(dataUpdatePatient);
        return ResponseEntity.ok(new DataListPatient(patient));
    }
}

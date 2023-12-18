package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medic.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("medic")
public class MedicController {

    @Autowired
    private MedicRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity save(@RequestBody @Valid MedicData data, UriComponentsBuilder uriComponentsBuilder) {
        var medic = new Medic(data);
        repository.save(medic);

        var URI = uriComponentsBuilder.path("/medic/{id}").buildAndExpand(medic.getId()).toUri();

        return ResponseEntity.created(URI).body(new DataDetailMedic(medic));
    }

    @GetMapping
    public ResponseEntity<Page<DataListMedic>> listing(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable) {
        var page = repository.findAll(pageable).map(DataListMedic::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid DataUpdateMedic dataUpdateMedic){
        var medic = repository.getReferenceById(dataUpdateMedic.id());
        medic.updateInfo(dataUpdateMedic);
        return ResponseEntity.ok(new DataDetailMedic(medic));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteMedico(@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/inativa/{id}")
    @Transactional
    public void inativateMedic(@PathVariable Long id){
        var medic = repository.getReferenceById(id);
        medic.delete();
    }

    @GetMapping ("/detail/{id}")
    public ResponseEntity detailMedic(@PathVariable Long id){
        var medic = repository.getReferenceById(id);
        return ResponseEntity.ok(new DataDetailMedic(medic));
    }
}

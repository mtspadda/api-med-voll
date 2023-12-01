package med.voll.api.controller;

import med.voll.api.patient.PatientData;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("patient")
public class PatientController {

    public void save(@RequestBody PatientData patient){
        System.out.println(patient);
    }
}

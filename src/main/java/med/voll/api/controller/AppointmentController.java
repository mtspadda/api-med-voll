package med.voll.api.controller;


import jakarta.validation.Valid;
import med.voll.api.domain.appointment.AppointmentData;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("appointment")
public class AppointmentController {

    @PostMapping
    @Transactional
    public ResponseEntity schedule(@RequestBody @Valid AppointmentData data){
        System.out.println(data);
        return ResponseEntity.ok(new AppointmentData(null, null, null, null));
    }
}

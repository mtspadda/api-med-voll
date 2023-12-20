package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.users.AuthenticationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager manager;

    @PostMapping
    public ResponseEntity doLogin(@RequestBody @Valid AuthenticationData data){
        var token = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        Authentication authenticate = manager.authenticate(token);
        return ResponseEntity.ok().build() ;
    }
}

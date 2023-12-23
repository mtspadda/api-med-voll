package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.users.AuthenticationData;
import med.voll.api.domain.users.Users;
import med.voll.api.infra.security.TokenDataJWT;
import med.voll.api.infra.security.TokenService;
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

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity doLogin(@RequestBody @Valid AuthenticationData data){
        var token = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        Authentication authenticate = manager.authenticate(token);
        String tokenJWT = tokenService.tokenGenerate((Users) authenticate.getPrincipal());
        return ResponseEntity.ok(new TokenDataJWT(tokenJWT));
    }
}

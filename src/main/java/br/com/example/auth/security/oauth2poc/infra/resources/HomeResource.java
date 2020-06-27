package br.com.example.auth.security.oauth2poc.infra.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/home")
public class HomeResource {

    @GetMapping
    public ResponseEntity<String> homeText(@RequestHeader("TESTE") String teste, @RequestHeader("TESTE2") String teste2, @RequestParam("teste") String parameterTest) {
        return ResponseEntity.ok("Its ok, you do not need authentication here");
    }

}

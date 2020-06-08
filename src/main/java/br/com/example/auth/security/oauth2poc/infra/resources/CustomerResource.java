package br.com.example.auth.security.oauth2poc.infra.resources;

import br.com.example.auth.security.oauth2poc.domain.Customer;
import br.com.example.auth.security.oauth2poc.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerResource {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> searchAll() {
        return ResponseEntity.ok(this.customerService.findAll());
    }
//
//     public static void main(String[] args) {
//         var crypt = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//         System.out.println(crypt.encode("password"));
//     }
}

package br.com.facol.bank.bank_api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.facol.bank.bank_api.helper.Constants;

@RestController
@RequestMapping(path = Constants.API_VERSION)
public class HealthController {

    @GetMapping("/health")
    public ResponseEntity<String> getHealth(){
        return ResponseEntity.ok("Application is running");
    }

}

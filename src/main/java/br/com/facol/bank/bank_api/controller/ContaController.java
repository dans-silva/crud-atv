
package br.com.facol.bank.bank_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.facol.bank.bank_api.model.ContaEntity;
import br.com.facol.bank.bank_api.service.ContaService;

@RestController
@RequestMapping("/api/v1/contas")
public class ContaController {

    @Autowired
    private ContaService service;

    @PostMapping
    public ResponseEntity<ContaEntity> criarConta(@RequestBody ContaEntity entity) {
        try {
            ContaEntity createdEntity = service.criarConta(entity);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdEntity);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<ContaEntity>> listarContas() {
        List<ContaEntity> contas = service.listarContas();
        return ResponseEntity.ok(contas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContaEntity> buscarContaPorId(@PathVariable Long id) {
        try {
            ContaEntity conta = service.buscarConta(id);
            return conta != null ? ResponseEntity.ok(conta) : ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarConta(@PathVariable Long id, @RequestBody ContaEntity entity) {
        try {
            service.atualizarConta(id, entity);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarConta(@PathVariable Long id) {
        try {
            service.deletarConta(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}

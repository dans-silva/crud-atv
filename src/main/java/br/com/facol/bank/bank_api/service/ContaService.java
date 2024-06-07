
package br.com.facol.bank.bank_api.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.facol.bank.bank_api.model.ContaEntity;
import br.com.facol.bank.bank_api.repository.ContaRepository;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    public ContaEntity criarConta(ContaEntity contaEntity) throws IllegalArgumentException {
        if (contaEntity.getNumeroConta() == null || contaEntity.getNumeroConta().isEmpty()) {
            throw new IllegalArgumentException("Número da conta não pode ser vazio.");
        }
        return contaRepository.save(contaEntity);
    }

    public List<ContaEntity> listarContas() {
        return contaRepository.findAll();
    }

    public ContaEntity atualizarConta(Long id, ContaEntity entity) throws Exception {
        ContaEntity conta = buscarConta(id);
        if (entity.getNumeroConta() != null && !entity.getNumeroConta().isEmpty()) {
            conta.setNumeroConta(entity.getNumeroConta());
            return contaRepository.save(conta);
        }
        throw new IllegalArgumentException("Número da conta fornecido é inválido.");
    }

    public ContaEntity buscarConta(Long id) throws Exception {
        return contaRepository.findById(id).orElseThrow(() -> new Exception("Conta não encontrada."));
    }

    public void deletarConta(Long id) throws Exception {
        ContaEntity conta = buscarConta(id);
        contaRepository.delete(conta);
    }
}

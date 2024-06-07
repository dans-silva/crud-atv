package br.com.facol.bank.bank_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.facol.bank.bank_api.model.ContaEntity;

@Repository
public interface ContaRepository extends JpaRepository<ContaEntity, Long>{

}

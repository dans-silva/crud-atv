package br.com.facol.bank.bank_api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(schema = "bank", name = "conta")
@NoArgsConstructor
@Getter
@Setter
public class ContaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_conta")
    @NotBlank(message = "Numero da conta nao pode ficar vazio")
    @Min(message = "numero da conta abaixo do minimo", value = 1L)
    private String numeroConta;

}

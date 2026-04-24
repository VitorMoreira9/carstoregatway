package br.projetopessoal.carstoregateway.dto;

import br.projetopessoal.carstoregateway.model.enuns.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarroDTO {

    private String modelo;
    private int ano;
    private String cor;
    private double preco;
    private String descricao;
    private Status status;

}

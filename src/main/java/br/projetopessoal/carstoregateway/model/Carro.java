package br.projetopessoal.carstoregateway.model;

import br.projetopessoal.carstoregateway.model.enuns.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "carros")
public class Carro {

    @Id
    private String id;

    private String modelo;
    private int ano;
    private String cor;
    private double preco;
    private String descricao;
    private Status status;
}

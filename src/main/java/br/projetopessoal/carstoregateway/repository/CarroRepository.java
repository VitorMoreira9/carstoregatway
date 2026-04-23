package br.projetopessoal.carstoregateway.repository;

import br.projetopessoal.carstoregateway.model.Carro;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CarroRepository extends MongoRepository<Carro, Carro> {
}

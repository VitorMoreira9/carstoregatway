package br.projetopessoal.carstoregateway.usecase;

import br.projetopessoal.carstoregateway.model.Carro;
import br.projetopessoal.carstoregateway.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarroUseCase {

    @Autowired
    private CarroRepository repository;

    public Carro salvar(Carro carro) {
        return repository.save(carro);
    }


}

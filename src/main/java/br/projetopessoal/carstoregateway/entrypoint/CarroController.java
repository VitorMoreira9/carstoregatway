package br.projetopessoal.carstoregateway.entrypoint;

import br.projetopessoal.carstoregateway.model.Carro;
import br.projetopessoal.carstoregateway.usecase.CarroUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carstore")
public class CarroController {

    @Autowired
    private CarroUseCase carroUseCase;

    @PostMapping("/cadastro/carros")
    public ResponseEntity<Carro> cadastroCarro(@RequestBody Carro carro){
        return ResponseEntity.status(HttpStatus.CREATED).body(carroUseCase.salvar(carro));
    }
}

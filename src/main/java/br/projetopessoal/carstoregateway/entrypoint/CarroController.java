package br.projetopessoal.carstoregateway.entrypoint;

import br.projetopessoal.carstoregateway.dto.CarroDTO;
import br.projetopessoal.carstoregateway.model.Carro;
import br.projetopessoal.carstoregateway.usecase.CarroUseCase;
import br.projetopessoal.carstoregateway.utils.CarroMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/carstore")
public class CarroController {

    @Autowired
    private CarroUseCase carroUseCase;

    @PostMapping("/cadastro/carros")
    public ResponseEntity<Object> cadastroCarro(@RequestBody CarroDTO carroDTO){
        try {
            Carro carro = CarroMapper.toEntity(carroDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(carroUseCase.execute(carro));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", e.getMessage()));
        }
    }
}

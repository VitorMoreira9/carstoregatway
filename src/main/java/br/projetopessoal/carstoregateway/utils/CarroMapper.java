package br.projetopessoal.carstoregateway.utils;

import br.projetopessoal.carstoregateway.dto.CarroDTO;
import br.projetopessoal.carstoregateway.model.Carro;

public class CarroMapper {
    public static CarroDTO toDTO(Carro carro) {
        CarroDTO dto = new CarroDTO();
        dto.setModelo(carro.getModelo());
        dto.setAno(carro.getAno());
        dto.setCor(carro.getCor());
        dto.setPreco(carro.getPreco());
        dto.setDescricao(carro.getDescricao());
        dto.setStatus(carro.getStatus());
        return dto;
    }

    public static Carro toEntity(CarroDTO dto) {
        Carro carro = new Carro();
        carro.setModelo(dto.getModelo());
        carro.setAno(dto.getAno());
        carro.setCor(dto.getCor());
        carro.setPreco(dto.getPreco());
        carro.setDescricao(dto.getDescricao());
        carro.setStatus(dto.getStatus());
        return carro;
    }
}


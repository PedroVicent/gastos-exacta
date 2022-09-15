package com.exacta.exactaproject.util.mapper;

import com.exacta.exactaproject.entity.Gasto;
import com.exacta.exactaproject.entity.dto.GastoDTO;

public class GastoMapper {
	public static Gasto toEntity(GastoDTO gasto) {
		return Gasto.builder()
				.nomePessoa(gasto.getNomePessoa())
				.descricao(gasto.getDescricao())
				.valor(gasto.getValor())
				.tags(gasto.getTags())
				.build();
	}
	
}

package com.exacta.exactaproject.entity.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.Getter;

@Getter
public class GastoDTO {

	private String nomePessoa;
	private String descricao;
	private BigDecimal valor;
	private List<String> tags;
}

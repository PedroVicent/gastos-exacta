package com.exacta.exactaproject.util.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.exacta.exactaproject.entity.Gasto;
import com.exacta.exactaproject.entity.Tag;
import com.exacta.exactaproject.entity.dto.GastoDTO;
import com.exacta.exactaproject.util.mapper.GastoMapper;

@Component
public class GastoMapperImpl implements GastoMapper{

	@Override
	public Gasto toEntity(GastoDTO gastoDTO) {
		Gasto gasto = new Gasto();
		gasto.setNomePessoa(gastoDTO.getNomePessoa());
		gasto.setDescricao(gastoDTO.getDescricao());
		gasto.setValor(gastoDTO.getValor());
		if(null != gastoDTO.getTags()) {
			List<Tag> tags = new ArrayList<>();
			gastoDTO.getTags().forEach(tag -> {
				tags.add(new Tag(tag));
			});
			gasto.setTags(tags);
		}
		return gasto;
	}
	

}

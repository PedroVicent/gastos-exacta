package com.exacta.exactaproject.util.mapper;

import org.mapstruct.Mapper;

import com.exacta.exactaproject.entity.Gasto;
import com.exacta.exactaproject.entity.dto.GastoDTO;

@Mapper(componentModel = "spring")
public interface GastoMapper {
	
	Gasto toEntity(GastoDTO gastoDTO);
	
}

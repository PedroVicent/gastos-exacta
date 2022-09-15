package com.exacta.exactaproject.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exacta.exactaproject.entity.Gasto;
import com.exacta.exactaproject.entity.dto.GastoDTO;
import com.exacta.exactaproject.repository.GastoRepository;
import com.exacta.exactaproject.util.exception.GastoNaoEncontradoException;
import com.exacta.exactaproject.util.mapper.GastoMapper;

@Service
public class GastoService {
	
	@Autowired
	private GastoRepository repository;
	
	private GastoMapper mapper;

	public Gasto createGasto(GastoDTO gasto) {
		Gasto novoGasto = mapper.toEntity(gasto);
		novoGasto.setData(LocalDateTime.now());
		return repository.save(novoGasto);
	}
	
	public Gasto getGastoById(Long id) throws GastoNaoEncontradoException {
		Optional<Gasto> gastoEncontrado = repository.findById(id);
		if (gastoEncontrado.isPresent()) {
			return gastoEncontrado.get();
		}
		throw new GastoNaoEncontradoException("Gasto não Encontrado!!");
	}
	
	public Iterable<Gasto> getAllGastos() {
		return repository.findAll();
		
	}
}

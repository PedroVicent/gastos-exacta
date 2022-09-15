package com.exacta.exactaproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exacta.exactaproject.entity.Gasto;
import com.exacta.exactaproject.entity.dto.GastoDTO;
import com.exacta.exactaproject.service.GastoService;
import com.exacta.exactaproject.util.exception.GastoNaoEncontradoException;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gasto")
@RequiredArgsConstructor
public class GastoController {
	
	@Autowired
	private GastoService service;
	
	@PostMapping()
	public Gasto create(@RequestBody GastoDTO gasto) {
		return service.createGasto(gasto);
	}
	
	@GetMapping(path = "/{id}")
	public Gasto findById(@PathVariable Long id) throws GastoNaoEncontradoException {
		return service.getGastoById(id);
	}
	
	@GetMapping
	public Iterable<Gasto> getAllGastos() {
		return service.getAllGastos();
	}

}

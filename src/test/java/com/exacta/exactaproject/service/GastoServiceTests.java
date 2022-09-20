package com.exacta.exactaproject.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.exacta.exactaproject.entity.Gasto;
import com.exacta.exactaproject.entity.dto.GastoDTO;
import com.exacta.exactaproject.repository.GastoRepository;
import com.exacta.exactaproject.util.exception.GastoNaoEncontradoException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class GastoServiceTests {
	
	public static final Long ID = 1L;
	
	@InjectMocks
	private GastoService service;

	@Mock
	private GastoRepository repository;
	
	public Gasto newGasto() {
		return new Gasto(ID, "Pedro", "Batata", LocalDateTime.now(), BigDecimal.TEN, "comida");
	}
	
	@Test
	public void createGasto() {
		GastoDTO gasto = new GastoDTO();
		when(repository.save(any(Gasto.class))).thenReturn(newGasto());
		
		Gasto gastoCreated = service.createGasto(gasto);
		assertEquals(gastoCreated.getId(), ID);
		assertEquals(gastoCreated.getNomePessoa(), newGasto().getNomePessoa());
	}
	
	@Test
	public void getGastoById() throws GastoNaoEncontradoException {
		Optional<Gasto> gastoFound = Optional.of(newGasto());
		when(repository.findById(ID)).thenReturn(gastoFound);
		
		Gasto gasto = service.getGastoById(ID);
		assertNotNull(gasto);
		assertEquals(gasto.getId(), ID);
	}
	
	@Test
	public void getGastoByIdShouldThrowException() {
		when(repository.findById(ID)).thenReturn(Optional.empty());
		
		assertThrows(GastoNaoEncontradoException.class, () -> service.getGastoById(ID));
	}
	
	@Test
	public void getAllGastos() {
		List<Gasto> gastoList = new ArrayList<>();
		gastoList.add(newGasto());
		when(repository.findAll()).thenReturn(gastoList);
		
		List<Gasto> allGastosList = service.getAllGastos();
		assertNotNull(allGastosList);
		assertEquals(allGastosList.size(), 1);
	}
}

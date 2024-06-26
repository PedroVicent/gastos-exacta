package com.exacta.exactaproject.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Gasto {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nomePessoa;
	
	@Column(nullable = false)
	private String descricao;
	
	@Column
	private LocalDateTime data;
	
	@Column(nullable = false)
	private BigDecimal valor;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	private List<Tag> tags;
	
}

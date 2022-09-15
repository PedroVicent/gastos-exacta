package com.exacta.exactaproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.exacta.exactaproject.entity.Gasto;

@Repository
public interface GastoRepository extends CrudRepository<Gasto, Long>{

}

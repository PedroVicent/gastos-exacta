package com.exacta.exactaproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exacta.exactaproject.entity.Gasto;

@Repository
public interface GastoRepository extends JpaRepository<Gasto, Long>{

}

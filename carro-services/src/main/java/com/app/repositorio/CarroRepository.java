package com.app.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entidades.Carro;

public interface CarroRepository extends JpaRepository<Carro, Integer>{

	List<Carro> findByUsuarioId(int usuarioId);
}

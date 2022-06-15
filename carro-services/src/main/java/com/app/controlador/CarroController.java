package com.app.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entidades.Carro;
import com.app.servicio.CarroService;

@RestController
@RequestMapping("/api")
public class CarroController {

	@Autowired
	private CarroService carroService;
	
	@GetMapping("/carro")
	public ResponseEntity<List<Carro>> listarCarros(){
		List<Carro> carros = carroService.getAll();
		if(carros.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(carros);
	}
	
	@GetMapping("/carro/{id}")
	public ResponseEntity<Carro> obtenerCarro(@PathVariable("id") int id){
		Carro carro = carroService.getCarroById(id);
		if(carro == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(carro);
	}
	
	@PostMapping
	public ResponseEntity<Carro> guardarCarro(@RequestBody Carro carro){
		Carro nuevoCarro = carroService.save(carro);
		return ResponseEntity.ok(nuevoCarro);
	}
	
	@GetMapping("/usuario/{usuarioId}")
	public ResponseEntity<List<Carro>> listarCarrosPorUsuarioId(@PathVariable("usuarioId") int id){
		List<Carro> carros = carroService.byUsuarioId(id);
		if(carros.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(carros);
	}
}

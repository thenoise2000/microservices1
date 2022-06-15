package com.app.feignClients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import com.app.modelo.Carro;

@FeignClient(name = "carro-services",url = "http://localhost:8081")
@RequestMapping("/api")
public interface CarroFeignClient {

	@PostMapping()
	public Carro save(@RequestBody Carro carro);
	
	@GetMapping("/usuario/{usuarioId}")
	public List<Carro> getCarros(@PathVariable("usuarioId") int usuarioId);
}
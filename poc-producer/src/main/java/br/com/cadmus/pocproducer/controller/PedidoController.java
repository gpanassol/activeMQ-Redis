package br.com.cadmus.pocproducer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cadmus.pocproducer.entity.Pedido;
import br.com.cadmus.pocproducer.service.PedidoService;

@RestController
@RequestMapping("/api/v1")
public class PedidoController {

	@Autowired
	private PedidoService service;
	
	@RequestMapping(method=RequestMethod.GET, value="/", produces="application/json")
	public String getPedidos(){
		return "API Rest - online";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/pedido")
	public Pedido postPedido(@RequestBody Pedido pedido) {
		return service.sendAMQ(pedido);
	}
}

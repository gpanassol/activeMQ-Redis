package br.com.cadmus.pocproducer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

import br.com.cadmus.pocproducer.entity.Pedido;

@Service
public class PedidoService {

	@Autowired
	private JmsTemplate jmsTemplate;
	
	public Pedido sendAMQ(Pedido pedido) {
		String json = JSON.toJSONString(pedido);
		System.out.println("Enviado para fila " + json);
		jmsTemplate.convertAndSend("fila.pedidos", json);
		return pedido;
	}
}

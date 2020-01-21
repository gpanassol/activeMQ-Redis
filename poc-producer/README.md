# POC - Producer

Projeto WebService escrito em Spring-Boot responsavel por receber pedidos e enviar para uma fila no activeMQ.

Para rodar

```
Necessário fila chamada 'fila.pedidos' no ActiveMQ rodando na porta padrão
```

EndPoint

```
POST localhost:8080/api/v1/pedido
```

Formato JSON Pedido

```
{
    "codPedido": 123470,
    "valorPedido": 1022.00
}
```
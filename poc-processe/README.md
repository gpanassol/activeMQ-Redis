# Poc - Processe

Projeto responsavel por processa pedidos, enviar para um determinado topico no activeMQ e enviar para cache no Redis

Para rodar

- ActiveMQ
```
Necessário fila chamada 'fila.pedidos' e topic 'topico.pedidos.processados' no ActiveMQ rodando na porta padrão
```

Redis
```
docker run -d -p 6379:6379 -i -t redis
```
# Estudos sobre Redis e ActiveMQ

Nesse repositorio foram criados dois projetos que conversão entre sí.

## Poc-producer

Projeto WebService escrito em Spring-Boot responsavel por receber pedidos e enviar para uma fila no activeMQ


## Poc-processe

Projeto responsavel por processa pedidos, enviar para um determinado topico no activeMQ e enviar para cache no Redis
# Game Fácil

Sistema desenvolvido em Java para gerenciamento de jogadores e torneios, permitindo cadastro, inscrição e controle de pontuação com base nos tipos de competições.

## Funcionalidades

- Cadastro de jogadores
- Cadastro de torneios (Desafio Rápido, Campeonato e Maratona)
- Inscrição de jogadores em torneios
- Controle de pontuação dos jogadores
- Listagem de jogadores por ranking
- Exibição de detalhes dos torneios

## Jogadores

- Identificados por **email único**
- Possuem:
  - Nome
  - Email
  - Pontuação acumulada
  - Número de torneios disputados
- Ao participar de torneios:
  - Acumulam pontos
  - Incrementam contador de participações

## Torneios

###  Desafio Rápido
- Pontuação fixa:
  - **2 pontos**

###  Campeonato
- Pontuação baseada na duração:
  - **pontos = duração**

###  Maratona
- Sem bônus:
  - **pontos = duração**
- Com bônus:
  - **pontos = duração + 10**

## Inscrição

### Regras:

- Não permite:
  - Inscrição duplicada no mesmo torneio
  - Exceder número máximo de participantes
- Ao se inscrever:
  - Jogador recebe pontos
  - Incrementa número de torneios disputados

## Listagem de Jogadores

O sistema oferece diferentes formas de ordenação:

-  Por pontuação (decrescente)
-  Por nome (ordem alfabética)
-  Desempate:
  - Pontuação (decrescente)
  - Nome (crescente)

## Regras de Negócio

- Email do jogador é único
- Torneios possuem limite máximo de participantes
- Não permite:
  - Cadastro duplicado de jogadores
  - Inscrição em torneio inexistente
  - Inscrição de jogador inexistente
- Exceções são lançadas para operações inválidas

## Objetivo Acadêmico

Este projeto tem como foco:

- Praticar **Programação Orientada a Objetos**
- Aplicar conceitos de:
  - Herança
  - Polimorfismo
  - Encapsulamento
- Trabalhar com **coleções em Java**
- Implementar lógica de ranking
- Modelar sistemas baseados em competições

## Autor

**Kaio Vitor**  
Estudante de Computação - UFCG

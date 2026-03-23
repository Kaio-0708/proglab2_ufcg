# Agenda Fácil

Projeto em Java que simula um sistema de gerenciamento de estudantes e eventos acadêmicos (palestras, workshops e oficinas de aprendizagem), utilizando conceitos de Programação Orientada a Objetos (POO) e testes unitários com JUnit 5.

## Objetivo do Projeto

O Agenda Fácil tem como objetivo:

- Cadastrar estudantes com nome e email
- Registrar eventos acadêmicos: palestras, workshops e oficinas
- Inscrever estudantes em eventos
- Controlar pontos dos estudantes conforme participação e tipo de evento
- Listar estudantes em ordem decrescente de pontos
- Exibir detalhes dos eventos, incluindo participantes e pontuação
- Garantir regras de negócio com validações e exceções

## Estrutura do Projeto

src/Agenda

├── AgendaFacilController.java

├── Estudante.java

├── Evento.java

├── Palestra.java

├── Workshop.java

├── OficinaAprendizagem.java

teste/Agenda

├── AgendaFacilControllerTest.java

├── PalestraTest.java

├── WorkshopTest.java

└── OficinaAprendizagemTest.java


## Descrição das Classes

### AgendaFacilController
Classe central do sistema, responsável por orquestrar as operações.

**Funcionalidades:**
- Adicionar estudantes
- Cadastrar eventos
- Inscrever estudantes em eventos
- Exibir detalhes de estudantes e eventos
- Lançar exceções quando estudante ou evento não existem

### Estudante
Responsável por armazenar informações do estudante.

**Atributos:**
- nome
- email
- pontos
- quantidade de eventos que participa

**Funcionalidades:**
- Criar estudante
- Adicionar pontos e eventos
- Retornar dados formatados

### Evento (classe abstrata)
Gerencia dados do evento e interações com estudantes.

**Atributos:**
- titulo
- descricao
- data
- maxParticipantes
- participantes (HashMap)

**Funcionalidades:**
- Inscrever participantes
- Calcular pontuação do evento
- Exibir detalhes do evento

### Palestra, Workshop e OficinaAprendizagem
Classes concretas que estendem Evento, diferenciando-se por pontuação, duração e emissão de certificado (oficina).

**Funcionalidades adicionais:**
- Workshop e Oficina possuem duração em horas
- Oficina pode emitir certificado, aumentando a pontuação

### Testes Unitários
Testes implementados utilizando JUnit 5 para verificar:

- Listagem de estudantes em ordem decrescente de pontos
- Cálculo de pontuação de eventos (palestra, workshop, oficina)
- Regras de inscrição e limite de participantes

## Regras de Negócio

- Um estudante só pode se inscrever uma vez no mesmo evento
- Limite máximo de participantes por evento
- Estudantes são identificados exclusivamente pelo email
- Pontuação varia conforme tipo de evento e emissão de certificado

## Tecnologias Utilizadas

- Java (POO)
- JUnit 5

## Aprendizados

Implementação de sistemas orientados a objetos

Polimorfismo e herança (Evento e suas subclasses)

Encapsulamento de dados e regras de negócio

Controle de pontuação e ranking

Testes unitários com JUnit

Modelagem UML de classes e relacionamentos

## Autor

**Kaio Vitor**  
Estudante de Computação - UFCG

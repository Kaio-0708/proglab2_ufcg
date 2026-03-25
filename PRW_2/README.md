
# Sistema PRW (Paraíba Restaurant Week) 2

Sistema desenvolvido em Java para gerenciamento de um evento gastronômico, permitindo o cadastro de clientes, restaurantes, registro de visitas, votos em pratos e geração de relatórios.

## Funcionalidades

- Cadastro de clientes e restaurantes
- Registro de visitas (com ou sem comentário)
- Controle de gastos dos clientes
- Votação em pratos preferidos
- Listagem de clientes por restaurante
- Relatórios:
  - Geral
  - Financeiro
  - Engajamento

## Clientes

- Identificados por **email único**
- Possuem:
  - Nome
  - Prato preferido
  - Total de gastos
- Podem:
  - Visitar restaurantes
  - Votar em pratos
  - Definir prato preferido

## Restaurantes

- Identificados por **nome único**
- Possuem:
  - Prato principal
  - Valor fixo do menu (R$ 89,90)
  - Lista de clientes
  - Livro de visitas
  - Quantidade de votos

## Visitas

- Registram:
  - Data
  - Cliente
  - Restaurante
  - Comentário (opcional)

### Regras:
- Ao visitar um restaurante:
  - Cliente é adicionado ao restaurante
  - Visita é registrada no sistema
  - Gasto é incrementado automaticamente

## Votação

- Cliente pode votar no prato do restaurante
- Só pode votar se tiver visitado
- Caso não tenha visitado:
- A visita é registrada automaticamente

## Relatórios

### Relatório Geral
- Restaurantes participantes
- Clientes participantes
- Média de visitantes por restaurante
- Média de visitas por restaurante
- Restaurante mais visitado

### Relatório Financeiro
- Receita total do evento
- Média de receita por restaurante
- Média de gasto por cliente

### Relatório de Engajamento
- Quantidade de visitas por cliente em cada restaurante


## Regras de Negócio

- Máximo de **50 clientes**
- Máximo de **50 restaurantes**
- Não permite:
  - Cadastro duplicado
  - Dados inválidos (nome/email vazio)
- Visitas inválidas geram exceção
- Melhor prato:
  - Baseado na maior quantidade de votos
  - Não pode existir sem votos

## Testes

O projeto possui testes com **JUnit**, cobrindo:

- Cadastro de clientes e restaurantes
- Registro de visitas
- Controle de gastos
- Votação de pratos
- Geração de relatórios
- Tratamento de exceções

## Objetivo Acadêmico

Este projeto tem como foco:

- Praticar **Programação Orientada a Objetos**
- Aplicar conceitos de:
  - Encapsulamento
  - Coleções (`HashMap`, `List`, `Set`)
- Implementar **regras de negócio reais**
- Trabalhar com **relatórios e agregação de dados**
- Desenvolver **testes automatizados com JUnit**

## Tecnologias Utilizadas

- Java
- JUnit 5
- Coleções Java (`HashMap`, `ArrayList`, `HashSet`)
- API de datas (`LocalDate`)

## Observações

- Os dados são mantidos em memória
- Foco principal: **lógica de negócio e modelagem orientada a objetos**

## Autor

**Kaio Vitor**  
Estudante de Computação - UFCG

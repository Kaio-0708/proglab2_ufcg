#  Sistema Paraíba Restaurante Week

Projeto em **Java** que simula um sistema simples de gerenciamento de **clientes**, **restaurantes** e **votação de pratos preferidos**, utilizando conceitos de **Programação Orientada a Objetos (POO)** e **testes unitários com JUnit 5**.

---

##  Objetivo do Projeto

O Sistema PRW tem como objetivo:

- Cadastrar clientes e restaurantes  
- Registrar visitas de clientes a restaurantes  
- Permitir que clientes votem no prato do restaurante visitado  
- Identificar o prato mais votado entre os restaurantes  
- Garantir regras de negócio por meio de validações e testes automatizados  

---

##  Estrutura do Projeto

```
src/PRW
├── Clientes.java
├── Restaurante.java
├── Sistema_PRW.java
teste/PRW
└── Sistema_PRWTest.java
```

## Descrição das Classes

### Clientes
Responsável por armazenar informações do cliente.

Atributos:

nome

email

pratoPreferido

Funcionalidades:

Criar cliente com nome e email

Definir prato preferido após votação

Retornar dados formatados do cliente

### Restaurante
Gerencia dados do restaurante e interação com clientes.

Atributos:

nome

pratoEscolhido

valorMenu (fixo em R$ 89,90)

Lista de clientes visitantes

Quantidade de votos

Funcionalidades:

Registrar visita de clientes (sem duplicidade)

Registrar voto apenas de clientes que visitaram

Listar clientes visitantes

Contabilizar votos do prato

### Sistema_PRW
Classe central do sistema, responsável por orquestrar as operações.

Funcionalidades:

Adicionar clientes

Adicionar restaurantes

Registrar visita de cliente ao restaurante

Permitir votação de prato preferido

Listar clientes de um restaurante

Retornar o prato mais votado

Lançar exceções quando cliente ou restaurante não existem

## Sistema_PRWTest
Classe de testes unitários utilizando JUnit 5.

Testes implementados:

- Registrar voto quando o cliente visitou o restaurante

## Regras de Negócio
Um cliente só pode votar em um restaurante que já visitou

Clientes são identificados exclusivamente pelo email

Não é permitido voto sem visita prévia

Não é permitido votar ou visitar restaurantes inexistentes

Limites do sistema:

Até 100 clientes

Até 50 restaurantes

##Tecnologias Utilizadas

Java (POO)

JUnit 5

IDE compatível com Java (IntelliJ, Eclipse, VS Code)

## Como Executar o Projeto
Clone o repositório:
```
git clone https://github.com/seu-usuario/seu-repositorio.git
```

Abra o projeto em sua IDE Java

Execute a classe de testes:
```
Sistema_PRWTest
```

##Aprendizados

-Este projeto aborda conceitos fundamentais como:

-Encapsulamento

-Arrays e controle de capacidade

-Validação de regras de negócio

-Lançamento de exceções

-Testes unitários com JUnit

## Autor

Kaio Vitor - [GitHub](https://github.com/Kaio-0708)

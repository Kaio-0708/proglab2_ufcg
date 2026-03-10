# AcademiaPro

Sistema simples de gerenciamento de academia desenvolvido em **Java**, com foco em **Programação Orientada a Objetos (POO)**, utilizando conceitos como **herança, abstração, encapsulamento e polimorfismo**.

O sistema permite o **cadastro de alunos**, **criação de treinos** de diferentes tipos e **inscrição de alunos em treinos**, além de calcular automaticamente a **pontuação acumulada** de cada aluno com base nos treinos realizados.

# Funcionalidades

- Cadastro de alunos
- Listagem de alunos ordenados por pontuação
- Exibição de informações de um aluno
- Cadastro de diferentes tipos de treinos
- Inscrição de alunos em treinos
- Controle de capacidade de treinos
- Sistema de pontuação baseado no tipo de treino
- Testes automatizados com **JUnit**

# Estrutura do Projeto

O projeto é organizado no pacote:
PRO

Contendo as seguintes classes principais:

PRO

├── AcademiaProController.java

├── Aluno.java

├── Treino.java

├── TreinoCardio.java

├── TreinoFuncional.java

├── TreinoMusculacao.java

##  Arquitetura e Conceitos de POO

O projeto **AcademiaPro** foi desenvolvido seguindo princípios de **Programação Orientada a Objetos (POO)**, garantindo organização, reutilização de código e baixo acoplamento entre as classes.

###  Conceitos de POO Aplicados

## Abstração

O sistema utiliza uma **classe abstrata** para representar o conceito geral de treino:
Treino

Essa classe define atributos e comportamentos comuns, além de um método abstrato responsável pelo cálculo de pontuação.

## Herança

Os diferentes tipos de treino herdam da classe base `Treino`:

Treino

├── TreinoCardio

├── TreinoFuncional

└── TreinoMusculacao

Cada tipo de treino possui características próprias, mas reutiliza a estrutura comum definida na classe base.

## Polimorfismo

Cada tipo de treino implementa sua própria lógica de pontuação através do método:
calcularPontos()

Isso permite que o sistema trate todos os treinos de forma genérica, mas com comportamentos específicos.

## Encapsulamento

O projeto protege o estado interno das classes utilizando:
private,
getters e
métodos controlados.

Dessa forma, os atributos não podem ser alterados diretamente, garantindo maior segurança e controle sobre os dados.

## Testes

O sistema possui **testes unitários com JUnit**, responsáveis por garantir:

- funcionamento correto do **cálculo de pontos**
- **validação de valores esperados**
- **comportamento correto das classes**

## Tecnologias Utilizadas

Java (POO)

JUnit 5

IDE compatível com Java (IntelliJ, Eclipse, VS Code)

## Como Executar o Projeto
Clone o repositório:
```
git clone https://github.com/Kaio-0708/proglab2_ufcg
```

Abra o projeto em sua IDE Java

Execute a classe de testes:
```
AcademiaProControllerTest
TreinoCardioTest
TreinoFuncionalTest
TreinoMusculacaoTest
```

## Autor

Kaio Vitor - [GitHub](https://github.com/Kaio-0708)

## Curso: Bacharelado em Ciência da Computação - UFCG

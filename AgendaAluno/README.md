# Sistema de Controle de Alunos e Turmas

Sistema simples de gerenciamento de estudantes e turmas acadêmicas desenvolvido em Java, com foco em Programação Orientada a Objetos (POO), utilizando conceitos como herança, abstração, encapsulamento e polimorfismo.

O sistema permite o cadastro de estudantes, criação de diferentes tipos de turmas e inscrição de alunos nessas turmas, além de calcular automaticamente a pontuação acumulada de cada estudante com base nas atividades realizadas.

## Funcionalidades

- Cadastro de estudantes
- Listagem de estudantes ordenados por pontuação (crescente e decrescente)
- Listagem de estudantes por nome
- Listagem de estudantes por e-mail
- Exibição de informações de um estudante
- Cadastro de diferentes tipos de turmas
- Inscrição de estudantes em turmas
- Controle de capacidade máxima de participantes
- Sistema de pontuação baseado no tipo de turma
- Exibição detalhada das turmas
- Testes automatizados com JUnit

## Estrutura do Projeto

O projeto é organizado no pacote: `Aluno`

Contendo as seguintes classes principais:


Aluno

├── ControleAlunoController.java

├── Estudante.java

├── Turma.java

├── Computacao.java

├── Informatica.java

├── Eletrica.java


## Arquitetura e Conceitos de POO

O projeto foi desenvolvido seguindo princípios de Programação Orientada a Objetos (POO), garantindo organização, reutilização de código e baixo acoplamento entre as classes.

### Conceitos de POO Aplicados

#### Abstração

O sistema utiliza uma classe abstrata para representar o conceito geral de turma:

`Turma`

Essa classe define atributos comuns como título, descrição, data, capacidade e lista de estudantes, além de métodos abstratos para cálculo de pontuação e exibição de detalhes.

#### Herança

Os diferentes tipos de turmas herdam da classe base `Turma`:


Turma

├── Computacao

├── Informatica

└── Eletrica


Cada tipo possui regras específicas de pontuação e detalhes próprios.

#### Polimorfismo

Cada tipo de turma implementa sua própria lógica de pontuação através do método:

`calcularPontuacao()`

Isso permite tratar todas as turmas de forma genérica, mas com comportamentos diferentes dependendo do tipo.

#### Encapsulamento

Os atributos das classes são privados ou protegidos e acessados por métodos controlados, garantindo segurança e consistência dos dados.

## Regras de Negócio

- Um estudante não pode ser cadastrado com e-mail duplicado
- Um estudante não pode se matricular duas vezes na mesma turma
- A turma possui limite máximo de participantes
- Ao se inscrever:
  - O estudante ganha pontos automaticamente
  - O número de eventos do estudante é incrementado
- A pontuação varia conforme o tipo da turma:
  - **Computação:** pontuação fixa
  - **Informática:** baseada na duração
  - **Elétrica:** baseada na duração + bônus por certificação

## Testes

O sistema possui testes unitários com JUnit, responsáveis por garantir:

- funcionamento correto do cálculo de pontuação
- validação de regras de negócio
- comportamento esperado das classes
- ordenação correta de estudantes

## Tecnologias Utilizadas

- Java (POO)
- JUnit 5
- Estruturas de dados (`HashMap`, `List`, `ArrayList`)

## Autor

**Kaio Vitor**  
Estudante de Computação - UFCG
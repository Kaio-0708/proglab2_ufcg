# EsporteFácil

Repositório destinado aos estudos e implementações das disciplinas **Programação 2** e **Laboratório de Programação 2** da **Universidade Federal de Campina Grande (UFCG)**.
O projeto consiste em um sistema de gerenciamento de atividades esportivas, permitindo o cadastro de atletas, criação de atividades e controle de participação com pontuação.

##  Funcionalidades

- Cadastro de atletas
- Listagem de atletas ordenados por pontuação
- Cadastro de atividades:
  - Treinos
  - Campeonatos
  - Workshops técnicos
- Inscrição de atletas em atividades
- Controle de pontuação dos atletas
- Exibição de detalhes das atividades

##  Conceitos Aplicados

- **Orientação a Objetos (POO)**:
  - Abstração (classe abstrata `Atividade`)
  - Herança (`Treino`, `Campeonato`, `Workshop`)
  - Polimorfismo (`calcularPontuacao()` e `toString()`)
  - Encapsulamento

- Boas práticas de programação  
- Uso da linguagem Java  
- Estruturas de dados (`HashMap`, `ArrayList`)  
- Ordenação com `Comparator`  
- Testes automatizados com JUnit  
- Modelagem com **UML (Diagrama de Classes)**  

##  Estrutura do Projeto

###  Pacote `Academia`

- `Atividade` (abstrata)
- `Treino`
- `Campeonato`
- `Workshop`
- `Atleta`
- `EsporteFacilController`

## Regras de Negócio

### Atletas
- Identificados por e-mail único  
- Acumulam pontos ao participar de atividades  
- Possuem:
  - Quantidade de treinos  
  - Quantidade de competições  

### Atividades

#### Treino
- Pontuação fixa:

2 pontos

#### Campeonato
- Pontuação baseada na duração:

pontos = duração

#### Workshop Técnico

- Com certificado:

pontos = duração + 10

- Sem certificado:

pontos = duração

### Inscrição
- Não permite:
  - Exceder número máximo de participantes  
  - Inscrição duplicada  

- Ao se inscrever:
  - Atleta recebe pontos  
  - Incrementa contadores de treino e competição  

## Testes

O projeto possui testes com **JUnit**, cobrindo:

- Cálculo de pontuação  
- Ordenação de atletas  
- Cadastro e inscrição  
- Regras de negócio  

## Objetivo Acadêmico

Este projeto tem como foco:

- Praticar orientação a objetos  
- Aplicar herança e polimorfismo  
- Trabalhar com coleções em Java  
- Implementar regras de negócio  
- Criar testes automatizados  
- Representar sistemas com UML  

## Autor

**Kaio Vitor**  
Estudante de Computação - UFCG

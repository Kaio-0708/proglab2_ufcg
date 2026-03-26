# Tech Cursos

Sistema desenvolvido em Java para gerenciamento de alunos e cursos, permitindo cadastro, matrícula e controle de pontuação baseado nos tipos de cursos realizados.

## Funcionalidades

- Cadastro de alunos
- Cadastro de cursos (Livre, Profissionalizante e Bootcamp)
- Matrícula de alunos em cursos
- Controle de pontuação dos alunos
- Listagem de alunos ordenados por desempenho

## Alunos

- Identificados por **matrícula única**
- Possuem:
  - Nome
  - Matrícula
  - Pontuação acumulada
- Podem:
  - Se matricular em cursos
  - Acumular pontos conforme os cursos realizados

## Cursos

### Curso Livre
- Pontuação fixa:
  - **10 pontos**

### Curso Profissionalizante
- Pontuação baseada na carga horária:
  - **pontos = carga horária**

### Bootcamp
- Pontuação bônus:
  - **pontos = carga horária + 20**

## Matrícula

### Regras:

- Não permite:
  - Exceder o número máximo de alunos no curso
  - Matrícula duplicada no mesmo curso
- Ao matricular:
  - O aluno é adicionado ao curso
  - Recebe a pontuação correspondente ao tipo de curso

## Ordenação de Alunos

- Ordenação por:
  1. **Pontuação (crescente)**
  2. **Nome (ordem alfabética, em caso de empate)**

## Regras de Negócio

- Matrícula única por aluno
- Curso possui limite máximo de alunos
- Não permite:
  - Cadastro duplicado de alunos
  - Matrícula em curso inexistente
  - Matrícula de aluno inexistente
- Exceções são lançadas para operações inválidas

## Testes

O projeto possui testes com **JUnit**, cobrindo:

- Ordenação de alunos
- Distribuição de pontuação
- Matrícula em cursos
- Regras de negócio
- Casos de empate na ordenação

## Objetivo Acadêmico

Este projeto tem como foco:

- Praticar **Programação Orientada a Objetos**
- Aplicar conceitos de:
  - Herança
  - Polimorfismo
  - Encapsulamento
- Trabalhar com **coleções em Java**
- Implementar regras de negócio
- Desenvolver testes automatizados

## Tecnologias Utilizadas

- Java
- JUnit 5
- Coleções Java (`HashMap`, `ArrayList`)

## Autor

Kaio Vitor - [GitHub](https://github.com/Kaio-0708)

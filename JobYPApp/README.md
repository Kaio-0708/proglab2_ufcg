# JobYP - Sistema de Vagas e Candidaturas

Projeto desenvolvido com foco em **Programação Orientada a Objetos (POO)**, simulando uma plataforma de conexão entre **pessoas candidatas** e **vagas de emprego**.

O sistema permite cadastro de usuários, publicação de vagas, aplicação em jobs e cálculo de compatibilidade com base em habilidades.

## Funcionalidades

### Gestão de Pessoas
- Cadastro de pessoas com:
  - Nome
  - CPF (único)
  - Link de currículo (opcional)
  - Lista de habilidades
- Atualização de link de currículo
- Listagem de pessoas cadastradas
- Controle de convocações (limite de 5 por pessoa)

### Gestão de Vagas (Jobs)
- Cadastro de vagas com:
  - Nome da empresa
  - Descrição
  - Quantidade de vagas
  - Contato
  - Habilidades exigidas
- Limite máximo de 100 vagas no sistema

### Processo de Candidatura
- Aplicação de pessoas em vagas
- Registro automático de candidatura
- Registro de convocação pela empresa

### Cálculo de Compatibilidade
A compatibilidade entre candidato e vaga é baseada na quantidade de habilidades em comum:

| Habilidades em comum | Chance |
|---------------------|--------|
| 0                   | 0%     |
| 1                   | 30%    |
| 2                   | 60%    |
| ≥ 3                 | 90%    |

### Listagens
- Listagem de candidatos de uma vaga
- Listagem de candidatos com alta chance (≥ 90%)
- Consulta da chance de um candidato em uma vaga
- Quantidade de convocações recebidas por pessoa

## Regras de Negócio

- CPF é único no sistema
- Máximo de:
  - 100 pessoas cadastradas
  - 100 vagas cadastradas
- Cada pessoa pode receber até **5 convocações**
- Link de currículo pode ser nulo (tratado como "Vazio")
- Aplicações são feitas por índice da vaga
- Comparação de habilidades é feita por igualdade de strings

## Estrutura do Projeto

### Classe `Pessoa`
Representa um candidato no sistema.

**Responsabilidades:**
- Armazenar dados pessoais
- Gerenciar habilidades
- Controlar convocações recebidas
- Atualizar link do currículo

### Classe `Job`
Representa uma vaga de emprego.

**Responsabilidades:**
- Armazenar informações da vaga
- Gerenciar candidatos
- Calcular compatibilidade com candidatos
- Listar candidatos com suas chances

###  Classe `JobYPAppController`
Controlador principal do sistema (Facade).

**Responsabilidades:**
- Gerenciar pessoas e vagas
- Controlar fluxo de candidaturas
- Realizar consultas e listagens
- Aplicar regras de negócio

### Conceitos Aplicados

-Encapsulamento
- Coesão e baixo acoplamento
- Uso de coleções
- Sobrecarga de métodos
- Regras de negócio centralizadas
- Tratamento de exceções

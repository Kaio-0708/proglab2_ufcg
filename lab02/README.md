# CoISA
CoISA - Controle Institucional da Situação Acadêmica

Projeto em Java que simula um sistema acadêmico simples para acompanhamento de atividades de estudantes, utilizando conceitos de Programação Orientada a Objetos (POO).

## Objetivo do Projeto

O Sistema Coisa tem como objetivo:

- Representar estudantes com informações básicas
- Controlar o tempo de estudo online por disciplina
- Gerenciar desempenho em disciplinas (notas e horas)
- Avaliar nível de descanso do estudante
- Registrar e buscar resumos de conteúdos estudados
- Aplicar conceitos fundamentais de POO na prática

## Estrutura do Projeto

src/br/edu/ufcg/computacao/p2lp2/coisa

├── Aluno.java

├── Coisa.java

├── CoisaPlus.java

├── Descanso.java

├── Disciplina.java

├── RegistroResumos.java

├── RegistroTempoOnline.java

└── Resumo.java

## Descrição das Classes

### Aluno

Responsável por armazenar informações do estudante.

**Atributos:**

- nome  
- anoNascimento  
- cra  

**Funcionalidades:**

- Criar aluno com nome e ano de nascimento  
- Definir CRA  
- Calcular idade  
- Retornar representação textual  

### Descanso

Controla o nível de descanso do estudante.

**Atributos:**

- horasDescanso  
- numeroSemanas  

**Funcionalidades:**

- Definir horas de descanso  
- Definir número de semanas  
- Avaliar status geral (descansado ou cansado)  

### RegistroTempoOnline

Gerencia o tempo de estudo online por disciplina.

**Atributos:**

- nomeDisciplina  
- tempoOnline  
- tempoOnlineEsperado  

**Funcionalidades:**

- Adicionar tempo online  
- Verificar se atingiu a meta  
- Exibir progresso  

### Disciplina

Gerencia informações acadêmicas de uma disciplina.

**Atributos:**

- nomeDisciplina  
- horas  
- notas (array com 4 posições)  

**Funcionalidades:**

- Cadastrar horas de estudo  
- Cadastrar notas  
- Calcular média  
- Verificar aprovação (média ≥ 7)  
- Retornar dados da disciplina  

### Resumo

Representa um resumo de conteúdo estudado.

**Atributos:**

- nome  
- conteudo  

**Funcionalidades:**

- Armazenar tema e conteúdo  
- Retornar dados do resumo  

### RegistroResumos

Gerencia múltiplos resumos.

**Atributos:**

- numeroDeResumos  
- contador  
- array de Resumo  

**Funcionalidades:**

- Adicionar resumos (sem duplicidade de tema)  
- Listar resumos  
- Contar resumos cadastrados  
- Verificar existência de resumo por tema  
- Buscar resumos por palavra-chave  
- Imprimir resumo geral  

### Coisa

Classe principal de execução com exemplos de uso do sistema.

**Funcionalidades:**

- Testar controle de descanso  
- Testar tempo online  
- Testar disciplinas  
- Testar registro de resumos  

### CoisaPlus

Classe adicional para testes avançados de busca em resumos.

**Funcionalidades:**

- Buscar resumos por palavra-chave  
- Exibir resultados ordenados  

## Regras de Negócio

- Um aluno é criado com CRA inicial igual a 0.0  
- O status de descanso depende da média de horas por semana  
- A aprovação em disciplina ocorre apenas com média ≥ 7  
- O número de notas por disciplina é fixo em 4  
- Resumos não podem ter temas duplicados  
- O sistema de resumos respeita limite máximo e sobrescreve antigos (circular)  
- A busca de resumos não diferencia maiúsculas de minúsculas  

## Limites do Sistema

- Quantidade máxima de resumos definida na criação do registro  
- Cada disciplina possui exatamente 4 notas  

## Tecnologias Utilizadas

- Java (POO)

- IDE compatível com Java (IntelliJ, Eclipse, VS Code)

## Aprendizados

Este projeto aborda conceitos fundamentais como:

- Encapsulamento  

- Arrays e controle de capacidade  

- Sobrescrita de métodos  

- Organização de código em múltiplas classes  

- Regras de negócio aplicadas  

- Manipulação de Strings e coleções  

## Autor

Kaio Vitor - [GitHub](https://github.com/Kaio-0708)

## Curso: Bacharelado em Ciência da Computação - UFCG

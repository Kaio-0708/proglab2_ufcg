# Sistema Biblioteca Digital

Projeto em Java que simula um sistema de gerenciamento de biblioteca digital, com cadastro de leitores, controle de empréstimos de livros e sistema de pontuação baseado no tipo de leitura, utilizando conceitos de Programação Orientada a Objetos (POO) e testes unitários com JUnit 5.

## Objetivo do Projeto

O Sistema Biblioteca Digital tem como objetivo:

- Cadastrar leitores com nome e email
- Registrar diferentes tipos de livros (romance, científico e didático)
- Controlar empréstimos de livros
- Gerar pontuação para leitores com base no tipo de livro
- Listar leitores por pontuação ou ordem alfabética
- Exibir detalhes dos livros e leitores
- Garantir regras de negócio com validações e exceções

## Estrutura do Projeto

src/BD

├── BibliotecaDigitalController.java

├── Leitor.java

├── Livro.java

├── Romance.java

├── Cientifico.java

├── Didatico.java

teste/BD

├── BibliotecaDigitalControllerTest.java

├── RomanceTest.java

├── CientificoTest.java

└── DidaticoTest.java

## Descrição das Classes

### BibliotecaDigitalController
Classe central do sistema, responsável por orquestrar as operações.

**Funcionalidades:**

- Cadastrar leitores
- Listar leitores por pontos (ranking)
- Listar leitores por nome
- Cadastrar livros de diferentes tipos
- Registrar empréstimos de livros
- Exibir detalhes de livros

### Leitor
Responsável por armazenar informações do leitor.

**Atributos:**

- nome  
- email  
- pontos  
- número de livros emprestados  

**Funcionalidades:**

- Adicionar pontos de leitura  
- Registrar empréstimos  
- Retornar dados formatados  

### Livro (classe abstrata)
Gerencia dados gerais dos livros e empréstimos.

**Atributos:**

- titulo  
- autor  
- data  
- maxEmprestimos  
- leitores (HashMap)  

**Funcionalidades:**

- Registrar empréstimos de leitores  
- Controlar limite de empréstimos  
- Gerar pontuação (abstrato)  
- Exibir detalhes (abstrato)  

### Romance, Cientifico e Didatico
Classes concretas que estendem Livro, diferenciando-se pela forma de pontuação.

**Funcionalidades específicas:**

- **Romance:** pontuação fixa (2 pontos)  
- **Científico:** pontuação baseada no número de páginas  
- **Didático:** pontuação baseada no número de páginas, podendo incluir bônus  

### Testes Unitários
Testes implementados utilizando JUnit 5.

**Testes implementados:**

- Ranking de leitores por pontuação  
- Ranking de leitores por nome  
- Cálculo de pontuação dos livros  
- Validação de regras de negócio  

## Regras de Negócio

- Um leitor não pode ser cadastrado com email duplicado  
- Um leitor não pode pegar o mesmo livro mais de uma vez  
- O número de empréstimos não pode ultrapassar o limite do livro  
- Pontuação do leitor aumenta a cada empréstimo  
- Leitores são identificados exclusivamente pelo email  

## Limites do Sistema

- Limite de empréstimos definido por livro  
- Quantidade de leitores e livros depende da memória do sistema  

## Tecnologias Utilizadas

- Java (POO)
  
- JUnit 5

## Aprendizados

Aplicação de herança e polimorfismo

Encapsulamento de dados e regras de negócio

Modelagem orientada a objetos

Sistema de pontuação e ranking

Uso de coleções (HashMap, List)

Testes unitários com JUnit

Modelagem UML de classes

## Autor

**Kaio Vitor**  
Estudante de Computação - UFCG

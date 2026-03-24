# Sistema Biblioteca Cripto

Projeto em Java que simula uma biblioteca de criptografia de textos, permitindo a aplicação de diferentes algoritmos de criptografia de forma dinâmica, utilizando conceitos de Programação Orientada a Objetos (POO) e testes unitários com JUnit 5.

## Objetivo do Projeto

O Sistema Biblioteca Cripto tem como objetivo:

- Criptografar textos utilizando diferentes algoritmos
- Permitir troca dinâmica de algoritmos de criptografia
- Armazenar textos originais inseridos pelo usuário
- Aplicar conceitos de polimorfismo e interfaces
- Garantir funcionamento correto com testes automatizados

## Estrutura do Projeto

src/Cripto

├── BibliotecaCripto.java

├── Criptografia.java

├── ROT13.java

├── EXP.java

├── L33T.java

teste/Cripto

└── BibliotecaCriptoTeste.java

## Descrição das Classes

### BibliotecaCripto
Classe principal do sistema, responsável por gerenciar os textos e aplicar os algoritmos de criptografia.

**Atributos:**

- textosOriginais  
- algoritmo (tipo Criptografia)  

**Funcionalidades:**

- Criptografar textos  
- Armazenar textos originais  
- Listar textos inseridos  
- Alterar algoritmo de criptografia dinamicamente  

### Criptografia 
Define o contrato para os algoritmos de criptografia.

**Funcionalidades:**

- Método `criptografar(String texto)` que deve ser implementado por todas as classes de criptografia  

### ROT13
Implementa o algoritmo ROT13 (rotação de 13 posições no alfabeto).

**Funcionalidades:**

- Substitui cada letra por outra 13 posições à frente  
- Mantém apenas letras minúsculas no processamento  

### EXP
Implementa um algoritmo de expansão de caracteres.

**Funcionalidades:**

- Duplica cada caractere do texto  
- Exemplo: "abc" → "aabbcc"  

### L33T
Implementa o algoritmo estilo “leet speak”.

**Funcionalidades:**

- Substitui letras por símbolos/números  
- Exemplo: "matheus" → "|\\/|4+h3|_|5"  

### BibliotecaCriptoTeste
Classe de testes unitários utilizando JUnit 5.

**Testes implementados:**

- Criptografia padrão (ROT13)  
- Troca de algoritmo para EXP  
- Troca de algoritmo para L33T  
- Reconfiguração para ROT13  

## Regras de Negócio

- O algoritmo padrão é ROT13  
- O sistema permite troca dinâmica de algoritmo  
- Todo texto criptografado é armazenado na lista de textos originais  
- O algoritmo aplicado depende da configuração atual  
- Cada algoritmo deve implementar a interface Criptografia  

## Limites do Sistema

- Não há limite definido para quantidade de textos armazenados  
- Apenas algoritmos previamente implementados podem ser utilizados  

## Tecnologias Utilizadas

- Java (POO)
- JUnit 5

## Aprendizados

Uso de interfaces para definir contratos

Polimorfismo (múltiplos algoritmos com mesma interface)

Encapsulamento de comportamento

Troca dinâmica de estratégias (Strategy Pattern)

Testes unitários com JUnit

Manipulação de Strings

## Autor

**Kaio Vitor**  
Estudante de Computação - UFCG

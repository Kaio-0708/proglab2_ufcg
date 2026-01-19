#📘 Diário de Bordo em Java

Este projeto implementa um **Diário de Classe** simples em Java, executado via **linha de comando**, permitindo registrar, consultar, listar e pesquisar anotações de aulas associadas a datas específicas.

O objetivo é **educacional**, praticando conceitos fundamentais de **Programação Orientada a Objetos (POO)**, manipulação de datas, arrays e entrada de dados pelo console.

---

#  Estrutura do Projeto

###  `Anotacao`
Responsável por representar uma anotação de aula.

**Principais responsabilidades:**
- Armazenar data e texto da anotação
- Formatar a data (`dd/MM/yyyy`)
- Complementar anotações existentes
- Verificar se contém uma palavra-chave
- Sobrescrever `equals`, `hashCode` e `toString`

---

###  `DiarioDeClasse`
Gerencia um conjunto fixo de anotações.

**Funcionalidades:**
- Adicionar anotações até o limite definido
- Recuperar anotações por índice
- Listar todas as anotações
- Pesquisar anotações por palavra-chave
- Comparar dois diários (`equals`)

---

###  `InterfaceLinhaDeComando`
Interface interativa via terminal.

**Funções principais:**
- Exibir menu de opções
- Receber entradas do usuário
- Validar dados (datas, números e limites)
- Executar operações do diário

---

###  `Main`
Classe responsável por iniciar o programa.

- Recebe como argumento o número máximo de aulas
- Inicializa a interface de linha de comando

---

##  Funcionalidades do Sistema

-  Adicionar anotação com data
-  Consultar anotação por índice
-  Listar todas as anotações
-  Pesquisar por palavra-chave
-  Validação de datas
-  Controle de limite de anotações

---

##  Menu do Programa

1- adicionar anotacao
2- pesquisar i-esima anotacao
3- listar anotacoes
4- pesquisar palavra-chave
5- sair

yaml
Copiar código

---

##  Como Executar

###  Pré-requisitos

- Java 8 ou superior
- Terminal / Prompt de Comando

###  Compilação

```
javac diario_bordo/*.java
```
▶️ Execução
O programa exige 1 argumento, que representa o número máximo de aulas (anotações):

```
java diario_bordo.Main 10
```
O exemplo acima permite até 10 anotações no diário.

### Conceitos Trabalhados

- Programação Orientada a Objetos (POO)
- Encapsulamento
- Sobrecarga de construtores
- Arrays
- Entrada de dados com Scanner
- Manipulação de datas (LocalDate)
- Sobrescrita de métodos (equals, hashCode, toString)

## Autor

Kaio Vitor - [GitHub](https://github.com/Kaio-0708)

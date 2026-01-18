#  RepareBem – Sistema de Ordens de Serviço

Projeto em **Java** que simula um sistema simples de gerenciamento de **ordens de serviço para reparos de roupas**, permitindo o cadastro de reparos, criação de ordens de serviço, alteração de status e cálculo de valores totais.

O sistema foi desenvolvido com foco em **orientação a objetos**, utilizando classes bem definidas e testes unitários com **JUnit 5**.

---

##  Estrutura do Projeto

O projeto está organizado no pacote:

### Classes Principais

- **RepareBem**
- **OrdemDeServico**
- **Reparo**

### Classes de Teste

- **OrdemDeServicoTest**
- **ReparoTest**

---

##  Funcionalidades

###  Reparo
- Cadastro de reparos com:
  - Identificador
  - Descrição
  - Preço
- Reajuste de preço por percentual (positivo ou negativo)

###  Ordem de Serviço
- Cadastro de ordem de serviço com:
  - Cliente
  - Telefone
  - Roupa
- Associação de até **10 reparos** por ordem
- Cálculo automático do preço total
- Controle de status:
  - `Não iniciada`
  - `Em andamento`
  - `Concluida`
- Listagem de ordens por status

###  RepareBem (Classe Controladora)
- Cadastro de reparos (sem duplicação de identificador)
- Cadastro de ordens de serviço
- Reajuste de preço de reparos
- Alteração do status de ordens de serviço

---

##  Testes Unitários

O projeto utiliza **JUnit 5** para garantir o funcionamento correto das regras de negócio.

### Testes Implementados

####  `ReparoTest`
- Reajuste positivo de preço
- Reajuste negativo de preço

####  `OrdemDeServicoTest`
- Alteração de status para:
  - Em andamento
  - Concluida
  - Não iniciada

---

## Conceitos Aplicados

- Encapsulamento
- Composição de objetos
- Validação de regras de negócio
- Testes unitários
- Boas práticas em métodos getters e setters


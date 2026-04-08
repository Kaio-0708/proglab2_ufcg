# Sistema de Contas Bancárias

Projeto desenvolvido com foco em **Programação Orientada a Objetos (POO)**, simulando um sistema bancário com diferentes tipos de contas e operações básicas como saque e depósito.

O sistema utiliza **polimorfismo** por meio de uma interface comum para representar diferentes comportamentos de contas.

## Funcionalidades

### Gestão de Contas
- Cadastro de diferentes tipos de contas:
  - Conta Corrente
  - Conta Poupança
  - Conta Família
- Cada conta possui um número único gerado automaticamente

### Operações Bancárias
- Depósito em conta
- Saque com validação de saldo
- Regras específicas por tipo de conta

## Regras de Negócio

### Conta Corrente
- Possui **cheque especial**
- Pode sacar valores maiores que o saldo (respeitando o limite)

### Conta Poupança
- Só permite saque se houver saldo suficiente
- Possui um **percentual de rendimento (2%)** (não aplicado automaticamente no sistema atual)

### Conta Família
- Conta compartilhada entre dois CPFs
- Possui saldo único
- Suporte a saque e depósito
- (Cheque especial declarado, mas não inicializado explicitamente)

### Regras Gerais
- Cada conta é identificada por um número único
- Operações só ocorrem se a conta existir
- Saque retorna:
  - `true` → sucesso
  - `false` → saldo insuficiente

## Estrutura do Projeto

### Interface `Contabil`
Define o comportamento comum de contas.

**Métodos:**
- `sacar(double valor)`
- `depositar(double valor)`

### Classe `ContaCorrente`
Representa uma conta com cheque especial.

**Responsabilidades:**
- Permitir saque além do saldo
- Gerenciar saldo e limite

### Classe `ContaPoupanca`
Representa uma conta com restrições de saque.

**Responsabilidades:**
- Permitir saque apenas com saldo disponível
- Definir taxa de rendimento

### Classe `ContaFamilia`
Representa uma conta compartilhada.

**Responsabilidades:**
- Gerenciar saldo conjunto
- Permitir operações para dois titulares

### Classe `ContaController`
Controlador principal do sistema (Facade).

**Responsabilidades:**
- Gerenciar contas
- Realizar operações bancárias
- Controlar criação e identificação das contas

## Tecnologias Utilizadas

- Java
- Programação Orientada a Objetos (POO)
- Conceitos aplicados:
  - Interface
  - Polimorfismo
  - Encapsulamento
- Estruturas de dados:
  - `HashMap`

## Conceitos Aplicados

- Polimorfismo via interface
- Encapsulamento
- Coesão e baixo acoplamento
- Reutilização de código
- Separação de responsabilidades

## Autor

Kaio Vitor - [GitHub](https://github.com/Kaio-0708)

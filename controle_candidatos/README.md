# Processo Seletivo 

Este projeto é um **programa em Java** que simula um processo seletivo, demonstrando conceitos de **orientação a objetos**, **controle de fluxo** e **estruturas de repetição**. Ele foi desenvolvido como exercício prático para estudos de **Programação 2** e **Laboratório de Programação 2**.

---

## Funcionalidades

O programa contém métodos que realizam as seguintes operações:

1. **Simulação de contato com candidatos**
   - Lista de candidatos predefinida.
   - Método `entrandoContato(String candidato)` tenta contatar cada candidato até 3 vezes ou até que o candidato atenda.
   - Método `atender()` simula a resposta do candidato de forma aleatória.

2. **Impressão de candidatos**
   - Método `imprimirSelecionados()` imprime a lista de candidatos utilizando **loop for tradicional** e **for-each**.

3. **Seleção de candidatos com base no salário**
   - Método `selecaoCandidato()` seleciona até 5 candidatos com salário pretendido menor ou igual ao **salário base** (R$ 2000,00).
   - Método `valorPretendido()` gera aleatoriamente o salário solicitado por cada candidato.
   - Método `analisarCandidato(double salarioPretendido)` avalia cada candidato e decide se entra em contato, faz contraproposta ou aguarda outros resultados.

---

## Estrutura do Código


ProcessoSeletivo.java
├── main()                     # Executa o programa
├── entrandoContato()           # Simula tentativas de contato com candidato
├── atender()                   # Gera resposta aleatória do candidato
├── imprimirSelecionados()      # Exibe os candidatos
├── selecaoCandidato()          # Seleciona candidatos com base no salário
├── valorPretendido()           # Gera salário pretendido aleatório
└── analisarCandidato()         # Avalia candidatos para possível contato 

## Como Executar

Certifique-se de ter o **Java 17+** instalado.

### Compile o programa:

```bash
javac ProcessoSeletivo.java
java candidatura.ProcessoSeletivo
```

O programa exibirá no console o resultado das tentativas de contato e a seleção dos candidatos.

---

## Objetivos de Aprendizado

- Praticar **loops** (`for`, `while`, `do-while`) e **condicionais** (`if`, `else if`, `else`).
- Trabalhar com **arrays** e **iteração for-each**.
- Manipular valores aleatórios usando `Random` e `ThreadLocalRandom`.

---

**Autor:** Kaio Vitor  
**Curso:** Bacharelado em Ciência da Computação - UFCG

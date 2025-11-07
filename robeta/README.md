# RoBeta - Simulador de Robô Falante

## Descrição do Projeto
RoBeta é um projeto em Java que simula um robô capaz de falar palavras armazenadas em memória. O robô possui um sistema de bateria que é consumido a cada fala, permitindo praticar conceitos fundamentais de **programação orientada a objetos (POO)** como encapsulamento, construtores, métodos, atributos e interação com o usuário via console.

O projeto inclui um menu interativo que permite ao usuário:
- Visualizar a bateria atual do robô.
- Trocar o valor da bateria.
- Exibir informações completas do robô.
- Fazer o robô falar palavras específicas ou aleatórias.

---

## Objetivos de Aprendizado
Este projeto tem como foco ensinar e reforçar os seguintes conceitos:

1. **Classes e Objetos**
   - Criação de classes (`RoBeta`) e instâncias (objetos).
   - Diferenciação entre atributos de instância e métodos.

2. **Encapsulamento**
   - Uso de modificadores de acesso `private` para proteger atributos.
   - Uso de getters e setters para acesso controlado aos dados.

3. **Construtores**
   - Inicialização de objetos com valores específicos.
   - Tratamento de entradas nulas para evitar erros de execução.

4. **Métodos**
   - Métodos com e sem parâmetros.
   - Métodos privados (`consomeEnergia`) e públicos (`falar`, `exibeRobo`).
   - Sobrecarga de métodos (`falar()` e `falar(int i)`).

5. **Estruturas de Controle**
   - Uso de `if`, `switch` e loops `do-while`.
   - Tratamento de exceções (`try-catch`) para entradas inválidas.

6. **Arrays e Random**
   - Armazenamento e manipulação de múltiplas palavras.
   - Seleção aleatória de palavras usando `Random`.

7. **Interação com o Usuário**
   - Entrada de dados via `Scanner`.
   - Exibição de informações no console de forma amigável.

---

## Funcionalidades
- **Exibir Bateria:** Mostra o nível atual de bateria do robô.
- **Trocar Bateria:** Permite definir um novo valor para a bateria.
- **Exibir Robô:** Mostra o estado completo do robô, incluindo a lista de palavras.
- **Falar Palavra Específica:** Faz o robô falar uma palavra escolhida pelo usuário.
- **Falar Palavra Aleatória:** Faz o robô falar uma palavra escolhida aleatoriamente.
- **Encerramento:** Permite sair do programa de forma segura.

---

## Como Executar

```bash
javac robeta/RoBeta.java robeta/Main.java
java robeta.Main
```

---

**Autor:** Kaio Vitor  
**Curso:** Bacharelado em Ciência da Computação - UFCG

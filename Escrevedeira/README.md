#  Escrevedeira

Projeto desenvolvido como parte da disciplina de **Programação em Laboratório 2** da **UFCG**, com o objetivo de praticar conceitos de programação, manipulação de arquivos, testes e lógica de código. Utilizando a linguagem **Java**, com o objetivo de praticar conceitos fundamentais de programação orientada a objetos e testes automatizados.

 A **Escrevedeira** é uma plataforma que tem como objetivo tornar a leitura e a escrita mais populares entre as pessoas. Um de seus serviços principais são os **clubes de leitura**, que promovem encontros para discussão de livros entre leitores com interesses em comum.

A ideia central do sistema é reduzir o caráter solitário da leitura, permitindo que leitores que já finalizaram um livro possam se reunir para conversar e trocar experiências sobre a obra.
Neste projeto, **não é necessário implementar a classe `Main`**, responsável pela interação direta com o usuário. O foco está na implementação da **classe de sistema `Escrevedeira`**, que fornece todas as funcionalidades que seriam invocadas pelo `Main`.

---

---

##  Estrutura do Repositório

```
proglab2_ufcg/
└── Escrevedeira/
    ├── src/
    │   └── escrevedeira---           # Código-fonte principal
    └── teste/
        └── escrevedeira              # Testes para validação do código
 ```

As principais funcionalidades do projeto envolvem:

- Entrada e saída de dados
- Manipulação de strings e arquivos
- Uso de estruturas condicionais e de repetição
- Aplicação de estruturas de dados básicas
- Verificação do comportamento do sistema por meio de **testes automatizados com JUnit**

---

##  Como Executar

### Pré-requisitos

Antes de executar o projeto, é necessário ter instalado:

 **Java JDK** (versão 11 ou superior)  
 **Eclipse IDE**  
 **JUnit** configurado no projeto (geralmente já incluso nos projetos de laboratório)

---

### Passo 1 — Clonar o Repositório

Abra o terminal e execute:

```bash
git clone https://github.com/Kaio-0708/proglab2_ufcg.git
```

### Passo 2 — Importar o Projeto no Eclipse
Abra o Eclipse

- No menu superior, clique em File → Import

- Selecione General → Existing Projects into Workspace

- Clique em Next

- Em Select root directory, escolha a pasta:

proglab2_ufcg/Escrevedeira

-Certifique-se de que o projeto foi detectado

- Clique em Finish

### Passo 3 — Executar os Testes Automatizados

### teste/escrevedeira

- Clique com o botão direito sobre a classe de teste
- Selecione **Run As → JUnit Test**

Os testes automatizados validam se as funcionalidades implementadas estão de acordo com o comportamento esperado pelo enunciado do laboratório.

## Autor

Kaio Vitor - [GitHub](https://github.com/Kaio-0708)

# Sistema Clube do Café

Projeto em Java que simula um sistema de gerenciamento de um clube do café, com cadastro de sócios, registro de cafés, degustações e avaliação de qualidade, utilizando conceitos de Programação Orientada a Objetos (POO) e testes unitários com JUnit 5.

## Objetivo do Projeto

O Sistema Clube do Café tem como objetivo:

- Cadastrar sócios e controlar seu status (ativo/inativo)
- Registrar diferentes tipos de cafés
- Permitir que sócios degustem cafés e avaliem com notas e comentários
- Calcular a qualidade dos cafés com base nas avaliações
- Identificar o café de melhor qualidade
- Gerenciar lista de cafés favoritos dos sócios
- Garantir regras de negócio com validações e exceções

## Estrutura do Projeto

src/Clube

├── ClubeDoCafeController.java

├── Cafe.java

├── CafeTradicional.java

├── CafeEspecial.java

├── CafePremium.java

├── Socio.java

├── Opiniao.java

teste/Clube

├── DegustarCafeTest.java

└── ListarQualidadeDosCafesTest.java

## Descrição das Classes

### ClubeDoCafeController
Classe central do sistema, responsável por gerenciar as operações.

**Funcionalidades:**

- Cadastrar cafés (tradicional, especial, premium)
- Cadastrar sócios
- Listar cafés e sócios
- Permitir degustação de cafés
- Alterar status do sócio
- Buscar café de melhor qualidade
- Adicionar cafés aos favoritos

### Socio
Responsável por armazenar informações do sócio.

**Atributos:**

- codigo  
- nome  
- status (ativo/inativo)  
- lista de cafés favoritos  

**Funcionalidades:**

- Alterar status  
- Adicionar cafés favoritos (apenas após degustação)  
- Retornar informações do sócio  

### Cafe (classe abstrata)
Representa um café e suas avaliações.

**Atributos:**

- nome  
- origem  
- intensidade  
- quantidade de degustações  
- lista de opiniões  

**Funcionalidades:**

- Adicionar opinião  
- Calcular média das notas  
- Verificar se sócio já degustou  
- Definir qualidade (abstrato)  

### CafeTradicional, CafeEspecial e CafePremium
Classes concretas que estendem Cafe, diferenciando-se pelo cálculo de qualidade.

**Funcionalidades específicas:**

- **Tradicional:** qualidade baseada no tempo de torra  
- **Especial:** qualidade baseada no nível de aroma  
- **Premium:** qualidade baseada na raridade  

### Opiniao
Representa a avaliação de um sócio sobre um café.

**Atributos:**

- código do sócio  
- nome do café  
- nota (0 a 5)  
- comentário  

### Testes Unitários

Testes implementados utilizando JUnit 5.

**Testes implementados:**

- Validação de degustação de café  
- Validação de sócio inexistente  
- Verificação de status do sócio (ativo/inativo)  
- Identificação do café com melhor qualidade  

## Regras de Negócio

- Sócios são identificados pelo código  
- Cafés são identificados pelo nome  
- Um sócio só pode degustar se estiver ativo  
- Nota da degustação deve estar entre 0 e 5  
- Um café pode receber múltiplas opiniões  
- Só é possível favoritar um café após degustação  
- Qualidade do café depende do tipo e média das avaliações  

## Limites do Sistema

- Não há limite definido para quantidade de sócios e cafés  
- Cada café armazena suas próprias avaliações  

## Tecnologias Utilizadas

- Java (POO)
- JUnit 5

## Aprendizados

Aplicação de herança e polimorfismo

Encapsulamento e regras de negócio

Uso de listas e HashMap

Cálculo de métricas (média e qualidade)

Validação de estados (ativo/inativo)

Testes unitários com JUnit

Modelagem UML

## Autor

**Kaio Vitor**  
Estudante de Computação - UFCG

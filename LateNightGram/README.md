# 🌙 LateNightGram 

Projeto desenvolvido com foco em **Programação Orientada a Objetos (POO)**, simulando uma rede social onde usuários podem criar posts, escrever crônicas e interagir por meio de curtidas.

O sistema também introduz um mecanismo de **reputação**, onde usuários podem se tornar **especialistas** com base no engajamento.

## Funcionalidades

### Gestão de Usuários
- Cadastro de usuários com:
  - Nick (único)
  - Nome
  - E-mail
- Recuperação de dados do usuário
- Listagem de usuários cadastrados

### Posts
- Criação de posts com:
  - Texto
  - Link (opcional)
- Listagem de posts de um usuário
- Curtidas em posts

### Crônicas
- Cadastro de crônicas com:
  - Autor
  - Tema
  - Título (único)
  - Texto
- Listagem de temas existentes
- Listagem de crônicas por tema
- Curtidas em crônicas

### Sistema de Reputação
- Cada crônica pode receber curtidas
- Ao atingir **100 curtidas**, o autor se torna:
  - **Especialista**
- Listagem de usuários especialistas

## Regras de Negócio

- Nick do usuário não pode ser vazio
- Título da crônica não pode ser vazio
- Usuário deve existir para:
  - Criar posts
  - Criar crônicas
  - Curtir conteúdos
- Curtidas:
  - Incrementam de 1 em 1
- Posts:
  - São adicionados sempre no topo da lista (ordem mais recente primeiro)
- Crônicas:
  - Não podem ter títulos duplicados (uso de `HashSet`)
- Usuário se torna especialista automaticamente ao atingir 100 curtidas em uma crônica

## Estrutura do Projeto

### Classe `Usuario`
Representa um usuário da rede.

**Responsabilidades:**
- Armazenar dados pessoais
- Gerenciar posts
- Controlar status de especialista
- Curtir posts

### Classe `Post`
Representa uma publicação simples.

**Responsabilidades:**
- Armazenar conteúdo do post
- Registrar curtidas

### Classe `Cronica`
Representa um conteúdo mais elaborado com tema.

**Responsabilidades:**
- Armazenar título, tema e texto
- Controlar curtidas
- Promover autor a especialista ao atingir 100 curtidas

### Classe `LateNigthGramController`
Controlador principal do sistema (Facade).

**Responsabilidades:**
- Gerenciar usuários, posts e crônicas
- Controlar interações (curtidas)
- Realizar listagens e consultas
- Aplicar regras de negócio

### Conceitos Aplicados

- Encapsulamento
- Coesão e baixo acoplamento
- Uso de coleções
- Sobrescrita de métodos (equals, hashCode, toString)
- Controle de regras de negócio
- Estrutura de Facade (Controller)

## Autor

**Kaio Vitor**  
Estudante de Computação - UFCG

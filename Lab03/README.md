# FilmNow
FilmNow - A sua lista de filmes e séries

Projeto baseado no laboratório 3 da disciplina de Programação 2 da UFCG. 

---

## Sobre

O FilmNow é uma aplicação Java que permite organizar e visualizar listas de filmes e séries. É uma implementação acadêmica que faz parte de atividades de laboratório da graduação em Computação na UFCG.

---

##  Estrutura do Projeto

O projeto está organizado em cinco classes principais:

- **FilmNow**  
  Classe central responsável pelo gerenciamento dos filmes e da HotList.

- **Filme**  
  Representa um filme, contendo nome, ano de lançamento, locais de exibição e informações sobre sua posição na HotList.

- **DetalharFilme**  
  Exibe informações detalhadas de um filme, incluindo todos os seus locais de exibição.

- **LeitorFilmNow**  
  Responsável por realizar a leitura automática de filmes a partir de arquivos `.csv`.

- **MainFilmNow**  
  Interface de linha de comando que permite a interação do usuário com o sistema.


---

##  Funcionalidades

-  Cadastrar novos filmes  
-  Listar filmes cadastrados  
-  Detalhar informações de um filme específico  
-  Remover filmes  
-  Adicionar ou remover filmes da **HotList (Top 10)**  
-  Adicionar e remover locais de exibição dos filmes  
-  Buscar filmes por **nome** ou **ano**  
-  Carregar automaticamente filmes a partir de um arquivo **CSV**

## Executar

1. **Compilar os arquivos**:

   ```bash
   javac filmnow/*.java


2. **Executar o sistema**:

   ```bash
   java filmnow.MainFilmNow
   ```

3. **Opcionalmente**, certifique-se de que o arquivo `filmes_inicial.csv` esteja no diretório raiz do projeto com a seguinte estrutura:

   ```
   POSICAO,NOME,ANO,LOCAL
   1,Poderoso chefao,1950,Netflix
   2,A Origem,2007,Prime Video
   ...
   ```

## Exemplo de Uso

Ao iniciar o programa, o seguinte menu será exibido:

<img width="281" height="372" alt="image" src="https://github.com/user-attachments/assets/660edabb-cd2f-4bfd-9e0f-a600590c7b30" />


Escolha a opção digitando a letra correspondente e siga as instruções.

## Autor

Kaio Vitor - [GitHub](https://github.com/Kaio-0708)

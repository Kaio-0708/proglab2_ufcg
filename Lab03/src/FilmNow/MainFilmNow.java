package FilmNow;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Interface com menus texto para manipular o sistema FilmNow.
 * 
 * @author Kaio Vitor Santos Queiroz
 */
public class MainFilmNow {
    
	/**
     * Método principal da aplicação. Inicializa o sistema FilmNow,
     * carrega filmes iniciais (se o arquivo existir) e inicia o loop
     * de interação por menu textual.
     *
     * @param args argumentos da linha de execução (não utilizados)
     */
	public static void main(String[] args) {
		FilmNow fn = new FilmNow();

		System.out.println("Carregando filmes ...");
		try {
			/*
			 * Essa é a maneira de lidar com possíveis erros por falta do arquivo. 
			 */
			carregaFilmes("filmes_inicial.csv", fn);
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo não encontrado: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Erro lendo arquivo: " + e.getMessage());
		}

		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha, fn, scanner);
		}

	}

	/**
	 * Exibe o menu e captura a escolha do/a usuário/a.
	 * 
	 * @param scanner Para captura da opção do usuário/a.
	 * @return O comando escolhido.
	 */
	
	private static String menu(Scanner scanner) {
		System.out.println(
				"\n---\nMENU\n" + 
						"(A)Adicionar filme\n" +
						"(F)Remover Filme\n" +
						"(M)Mostrar todos\n" + 
						"(N)Mostrar Todos Pelo Nome\n" +
						"(G)Mostrar Todos Pelo Ano\n" +
						"(D)Detalhar filme\n" +
						"(E)Exibir HotList\n" +
						"(H)Atribuir Hot\n" +
						"(R)Remover Hot\n" +
						"(L)Adicionarlocal\n" +
						"(O)Remover Local\n" +
						"(S)air\n" + 
						"\n" + 
						"Opção> ");
		return scanner.next().toUpperCase();
	}

	/**
	 * Interpreta a opção escolhida por quem está usando o sistema.
	 * 
	 * @param opcao   Opção digitada.
	 * @param fn  O sistema FilmNow que estamos manipulando.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 */
	private static void comando(String opcao, FilmNow fn, Scanner scanner) {
		switch (opcao) {
		case "A":
			adicionarFilme(fn, scanner);
			break;
		case "M":
			mostrarFilmes(fn);
			break;
		case "N":
			mostrarFilmesPeloNome(fn,scanner);
			break;
		case "G":
			mostrarFilmesPeloAno(fn,scanner);
			break;
		case "D":
			detalharFilme(fn, scanner);
			break;
		case "E":
			exibirHotList(fn);
			break;
		case "H":
			atribuirHot(fn, scanner);
			break;
		case "R":
			removerHot(fn,scanner);
			break;
		case "F":
			removerFilme(fn,scanner);
			break;
		case "L":
			adicionarLocal(fn,scanner);
			break;
		case "O":
			removerLocal(fn,scanner);
			break;
		case "S":
			sai();
			break;
		default:
			System.out.println("Opção inválida!");
		}
	}

	/**
	 * Cadastra um filme no sistema. 
	 * 
	 * @param fn O sistema FilmNow a ser manipulado.
	 * @param scanner Scanner para pedir informações do contato.
	 */
	private static void adicionarFilme(FilmNow fn, Scanner scanner) {
		System.out.print("\nPosição no sistema> ");
		int posicao = scanner.nextInt();
		scanner.nextLine();
		System.out.print("\nNome> ");
		String nome = scanner.nextLine(); 
		System.out.print("\nAno> ");
		String ano = scanner.next();
		scanner.nextLine();
		System.out.print("\nLocal> ");
		String local = scanner.nextLine();
		System.out.println(fn.cadastrarFilme(posicao, nome, ano, local));
	}
	
	/**
	 * Imprime lista de filmes.
	 * 
	 * @param fn O sistema FilmNow a ser manipulado.
	 */
	private static void mostrarFilmes(FilmNow fn) {

		Filme[] filmes = fn.getFilmes();
		for (int i = 0; i < filmes.length; i++) {
			if (filmes[i] != null) {
				System.out.println(formataFilme(i, filmes[i]));
			}
		}
	}
	
	/**
	 * Formata um filme para impressão. 
	 * 
	 * @param posicao A posição do filme (que é exibida)/
	 * @param filme O filme a ser impresso.
	 * @return A String formatada.
	 */
	private static String formataFilme(int posicao, Filme filme) {
		return (posicao + 1) + " - " + filme;
	}
    
	/**
	 * Solicita um nome e exibe todos os filmes que possuem esse nome.
	 *
	 * @param fn o sistema FilmNow
	 * @param scanner scanner para entrada do nome
	 */
	private static void mostrarFilmesPeloNome(FilmNow fn, Scanner scanner) {
		System.out.println("\nQual o nome do filme?");
		scanner.nextLine();
		String nome = scanner.nextLine();
		System.out.println(fn.mostrarTodosPeloNome(nome));
	}
	
	/**
	 * Solicita um ano e exibe todos os filmes cadastrados com esse ano.
	 *
	 * @param fn o sistema FilmNow
	 * @param scanner scanner para entrada do ano
	 */
	private static void mostrarFilmesPeloAno(FilmNow fn, Scanner scanner) {
		System.out.println("\nQual o ano do filme?");
		int ano = scanner.nextInt();
		scanner.nextLine();
		System.out.println(fn.mostrarTodosPeloAno(ano));
	}
	
	/**
	 * Imprime os detalhes de um dos filmes. 
	 * 
	 * @param fn O sistema FilmNow a ser manipulado.
	 * @param scanner Scanner para capturar qual contato.
	 */
	private static void detalharFilme(FilmNow fn, Scanner scanner) {
		System.out.print("\nQual filme> ");
		int posicao = scanner.nextInt();
		Filme filme = fn.getFilme(posicao);
		DetalharFilme df = new DetalharFilme(filme, posicao);
		System.out.println(df.toString());
	}
    
	/**
	 * Exibe a HotList atual.
	 *
	 * @param fn o sistema FilmNow
	 */
	private static void exibirHotList(FilmNow fn) {
		System.out.println(fn.exibirHotList());
	}
	
	/**
	 * Atribui um filme a uma posição da HotList.
	 *
	 * @param fn o sistema FilmNow
	 * @param scanner scanner para entrada das posições
	 */
	private static void atribuirHot(FilmNow fn, Scanner scanner) {
		System.out.println("Filme> ");
		int posicaoFilme = scanner.nextInt();
		System.out.println("posicao> ");
		int posicaoHot = scanner.nextInt();
		Filme filme = fn.getFilme(posicaoFilme);
		System.out.println(fn.atribuirHot(filme, posicaoHot));
	}
	
	/**
	 * Remove o filme presente em uma determinada posição da HotList.
	 *
	 * @param fn o sistema FilmNow
	 * @param scanner scanner para entrada da posição
	 */
	private static void removerHot(FilmNow fn,Scanner scanner) {
		System.out.println("Posicao> ");
		int posicao = scanner.nextInt(); 
		fn.removerHot(posicao);
	}
	
	/**
	 * Remove um filme do sistema.
	 *
	 * @param fn o sistema FilmNow
	 * @param scanner scanner para entrada da posição
	 */
	private static void removerFilme(FilmNow fn, Scanner scanner) {
		System.out.println("Posicao> ");
		int posicao = scanner.nextInt(); 
		fn.removerFilme(posicao);
	}
	
	/**
	 * Adiciona um novo local de exibição a um ou vários filmes.
	 *
	 * @param fn o sistema FilmNow
	 * @param scanner scanner utilizado para entrada dos dados
	 */
	private static void adicionarLocal(FilmNow fn, Scanner scanner) {
		System.out.println("Local>");
		scanner.nextLine();
		String local = scanner.nextLine();
		System.out.println("Filme(s) a receber esse local separados por vírgula>");
		String []posicoes = scanner.nextLine().split(",");
		
		for (String posicao:posicoes) {
			int pos = Integer.parseInt(posicao);
			if (pos > 100 || pos < 1 || fn.getFilme(pos) == null) {
				System.out.println("POSIÇÃO " + pos + " INVÁLIDA");
			} else {
				Filme filme = fn.getFilme(pos);
				filme.adicionarLocal(local);
			}
		}
	}
	

	/**
	 * Remove um local de exibição de um filme específico.
	 *
	 * @param fn o sistema FilmNow
	 * @param scanner scanner utilizado para entrada das informações
	 */
	private static void removerLocal(FilmNow fn, Scanner scanner) {
		System.out.println("Posição do filme a ter o local removido>");
		int pos = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Local>");
		String local = scanner.nextLine();
		if (pos > 100 || pos < 1 || fn.getFilme(pos) == null) {
			System.out.println("POSIÇÃO INVÁLIDA");
		} else {
			fn.getFilme(pos).removerLocal(local);
		}
	}
	
	/**
	 * Sai da aplicação.
	 */
	private static void sai() {
		System.out.println("\nVlw flw o/");
		System.exit(0);
	}

	/**
	 * Lê carga de filmes de um arquivo csv. 
	 * 
	 * @param arquivoFilmes O caminho para o arquivo.
	 * @param fn O sistema FilmNow a ser populado com os dados.
	 * @throws IOException Caso o arquivo não exista ou não possa ser lido.
	 */
	private static void carregaFilmes(String arquivoFilmes, FilmNow fn) throws FileNotFoundException, IOException {
		LeitorFilmNow leitor = new LeitorFilmNow();
		
		int carregados =  leitor.carregaContatos(arquivoFilmes, fn);
		System.out.println("Carregamos " + carregados + " registros.");
	}
}
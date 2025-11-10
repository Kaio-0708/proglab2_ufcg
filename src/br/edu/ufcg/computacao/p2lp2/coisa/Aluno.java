/**
* Representação de um estudante, especificamente de computação, matriculado na * UFCG. 
* Cada aluno possui nome, ano de nascimento e um CRA (Coeficiente de Rendimento Acadêmico).
* 
* @author Kaio Vitor
*/
package br.edu.ufcg.computacao.p2lp2.coisa;

public class Aluno {


    /** Nome do aluno. */
    private String nome;

    /** Ano de nascimento do aluno. */
    private int anoNascimento;

    /** Coeficiente de Rendimento Acadêmico (CRA) do aluno. */
    private double cra;

    /**
     * Constrói um novo aluno a partir de seu nome e ano de nascimento.
     * O CRA é inicializado com valor 0.0.
     * 
     * @param nome o nome do aluno
     * @param anoNascimento o ano de nascimento do aluno
     */
    public Aluno(String nome, int anoNascimento) {
        this.nome = nome;
        this.cra = 0.0;
        this.anoNascimento = anoNascimento;
    }

    /**
     * Define o CRA (Coeficiente de Rendimento Acadêmico) do aluno.
     * 
     * @param cra o novo valor do CRA
     */
    public void setCra(double cra) {
        this.cra = cra;
    }

    /**
     * Retorna a idade atual do aluno com base no ano de nascimento.
     * 
     * @return a idade do aluno em relação ao ano de 2021
     */
    public int getIdade() {
        return 2021 - anoNascimento;
    }

    /**
     * Retorna uma representação textual do aluno.
     * 
     * @return uma string contendo a identificação do aluno
     */
    public String toString() {
        return "Aluno - " + this.nome;
    }
}
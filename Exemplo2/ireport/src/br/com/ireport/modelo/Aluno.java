package br.com.ireport.modelo;

import java.util.List;

public class Aluno {

	private Integer id;
	private String nome;
	private List<String> disciplinas;

	public Aluno(Integer id, String nome, List<String> disciplinas) {
		this.id = id;
		this.nome = nome;
		this.disciplinas = disciplinas;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<String> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<String> disciplinas) {
		this.disciplinas = disciplinas;
	}

}

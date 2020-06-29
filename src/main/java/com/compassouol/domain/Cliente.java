package com.compassouol.domain;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Cliente extends BaseObject {

	private static final long serialVersionUID = 1L;
	
	private String nome, sexo, dataDeNascimento, idade;
	
	@ManyToOne
	@JoinColumn(name="cidade_id")
	private Cidade cidade;
	
	public Cliente() {
		
	}

	public Cliente(String nome, String sexo, String dataDeNascimento, String idade, Cidade cidade) {
		this.nome = nome;
		this.sexo = sexo;
		this.dataDeNascimento = dataDeNascimento;
		this.idade = idade;
		this.cidade = cidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(String dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", sexo=" + sexo + ", dataDeNascimento=" + dataDeNascimento + ", idade="
				+ idade + ", cidade=" + cidade + "]";
	}
}

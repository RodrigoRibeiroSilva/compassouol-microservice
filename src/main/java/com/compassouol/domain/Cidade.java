package com.compassouol.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Cidade extends BaseObject {
	
	private static final long serialVersionUID = 1L;
	
	private String nome, estado;
	
	@OneToMany(mappedBy = "cidade")
	@JsonIgnore
	private List<Cliente> listaDeClientes;

	public Cidade() {
		
	}

	public Cidade(String nome, String estado) {
		this.nome = nome;
		this.estado = estado;
		this.listaDeClientes = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public List<Cliente> getListaDeClientes() {
		return listaDeClientes;
	}

	public void setListaDeClientes(List<Cliente> listaDeClientes) {
		this.listaDeClientes = listaDeClientes;
	}
	
	public void adicionarCliente(Cliente cliente) {
		this.listaDeClientes.add(cliente);
	}

	@Override
	public String toString() {
		return "Cidade [nome=" + nome + ", estado=" + estado + "]";
	}
}

package br.com.fiap.model;

import java.util.Calendar;

public class Filme {

	private int id;
	private String titulo;
	private Calendar dataPublicacao;
	private Genero genero;
	private int classificacao;
	private Produtora produtora;
	private int duracao;

	public Filme(String titulo, Calendar dataPublicacao,  int classificacao, int duracao) {
		this.titulo = titulo;
		this.dataPublicacao = dataPublicacao;
		this.classificacao = classificacao;
		this.duracao = duracao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Calendar getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(Calendar dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public int getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(int classificacao) {
		this.classificacao = classificacao;
	}

	public Produtora getProdutora() {
		return produtora;
	}

	public void setProdutora(Produtora produtora) {
		this.produtora = produtora;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

}

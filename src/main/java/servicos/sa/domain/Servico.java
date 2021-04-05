package servicos.sa.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Servico {
	
	@Id
	private String nome;
	private String descricao;
	private long valor;
	
	public Servico() {
		
	}
	
	public Servico(String nome, String descricao, long valor) {
		this.nome = nome;
		this.descricao = descricao;
		this.valor = valor;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public long getValor() {
		return valor;
	}
	public void setValor(long valor) {
		this.valor = valor;
	}
	

}

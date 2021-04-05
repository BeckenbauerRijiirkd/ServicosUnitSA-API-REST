package servicos.sa.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cliente {
	@Id
	private long cnpj;
	private String nome;
	private  int contato;
	
	public Cliente() {
		
	}
	
	public Cliente(long cnpj, String nome, int contato) {
		
		this.cnpj = cnpj;
		this.nome = nome;
		this.contato = contato;
	}
	public long getCnpj() {
		return cnpj;
	}
	public void setCnpj(long cnpj) {
		this.cnpj = cnpj;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getContato() {
		return contato;
	}
	public void setContato(int contato) {
		this.contato = contato;
	}
	
	
}

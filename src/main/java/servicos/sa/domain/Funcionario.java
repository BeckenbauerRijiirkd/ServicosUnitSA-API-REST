package servicos.sa.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Funcionario {

	
	@Id
	private int cpf;
	private String nome;
	private int contato;
	private int salario;
	
	public Funcionario() {
		
	}
	
	public Funcionario(String nome,int cpf, int contato, int salario) {

		this.nome = nome;
		this.cpf = cpf;
		this.contato = contato;
		this.salario = salario;
	}
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
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
	public int getSalario() {
		return salario;
	}
	public void setSalario(int salario) {
		this.salario = salario;
	}
	
	
}

package servicos.sa.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;



@Entity
public class ServicoExecutado {

	@Id @GeneratedValue
	private Long id;
	private String funcionario;
	private String cliente;
	private String servico;
	
	@Temporal(TemporalType.DATE)
	private Date data;
	
	@JsonFormat(pattern="HH:mm:ss")
	@Temporal(TemporalType.TIME)
	private Date horarioInicio;
	
	@JsonFormat(pattern="HH:mm:ss")
	@Temporal(TemporalType.TIME)
	private Date horarioFinal;
	
	
	public ServicoExecutado() {
		
	}
	
	public ServicoExecutado(Long id, String funcionario, String cliente, String servico, Date data, Date horarioInicio, Date horarioFinal) {
		
		this.id = id;
		this.funcionario = funcionario;
		this.cliente = cliente;
		this.servico = servico;
		this.data = data;
		this.horarioInicio = horarioInicio;
		this.horarioFinal = horarioFinal;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(String funcionario) {
		this.funcionario = funcionario;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}

	public Date getHorarioInicio() {
		return horarioInicio;
	}

	public void setHorarioInicio(Date horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	public Date getHorarioFinal() {
		return horarioFinal;
	}

	public void setHorarioFinal(Date horarioFinal) {
		this.horarioFinal = horarioFinal;
	}

	public String getServico() {
		return servico;
	}

	public void setServico(String servico) {
		this.servico = servico;
	}
	
	
}

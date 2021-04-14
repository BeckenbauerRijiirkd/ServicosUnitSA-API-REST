package servicos.sa.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import servicos.sa.domain.ServicoExecutado;

@Repository
	public interface ServicoExecutadoRepository extends CrudRepository<ServicoExecutado, String>{
		
		List<ServicoExecutado> findAllByservico(String servico);
		List<ServicoExecutado> findAllByDataBetween(Date datainicio, Date datafim);
	}


	


package servicos.sa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import servicos.sa.domain.ServicoExecutado;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@EnableJpaRepositories
public interface BuscaRepository extends JpaRepository<ServicoExecutado, String> {
	//List lista = new ArrayList(); ou List lista = new LinkedList();
	
		List<ServicoExecutado> findAllByData(Date data);
		
	
}

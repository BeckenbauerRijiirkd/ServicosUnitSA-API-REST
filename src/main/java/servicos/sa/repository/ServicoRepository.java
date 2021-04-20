package servicos.sa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import servicos.sa.domain.Servico;
import servicos.sa.domain.ServicoExecutado;


@Repository
public interface ServicoRepository extends CrudRepository<Servico, String>{
	Servico findBynome(String servico);
	Boolean existsBynome(String nome); 
}

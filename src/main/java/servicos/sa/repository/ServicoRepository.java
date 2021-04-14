package servicos.sa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import servicos.sa.domain.Servico;


@Repository
public interface ServicoRepository extends CrudRepository<Servico, String>{

}

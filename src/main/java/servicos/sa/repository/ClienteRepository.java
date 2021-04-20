package servicos.sa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import servicos.sa.domain.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, String>{
	Cliente findBynome(String cliente);
	Boolean existsBycnpj(long cnpj);
	
}
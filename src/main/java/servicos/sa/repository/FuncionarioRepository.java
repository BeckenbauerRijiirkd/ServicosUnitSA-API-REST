package servicos.sa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import servicos.sa.domain.Funcionario;


@Repository
public interface FuncionarioRepository extends CrudRepository<Funcionario, String> {
	Funcionario findBynome(String nome);
	Boolean existsBycpf(int cpf); 
	
}


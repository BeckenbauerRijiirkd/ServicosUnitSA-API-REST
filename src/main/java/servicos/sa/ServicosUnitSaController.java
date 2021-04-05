package servicos.sa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import servicos.sa.domain.Cliente;
import servicos.sa.domain.ClienteRepository;
import servicos.sa.domain.Funcionario;
import servicos.sa.domain.FuncionarioRepository;



@RestController
@RequestMapping(value="/servicos")
public class ServicosUnitSaController {

	@Autowired
	FuncionarioRepository servicosRepository;
	
	
	@PostMapping("/cadastrarfuncionario")
	public ResponseEntity<Object> cadastrarfuncionario (@RequestBody Funcionario funcionario){
		
		
		
		servicosRepository.save(funcionario);
		
		return ResponseEntity.badRequest().body(true);
	}
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@PostMapping("/cadastrarcliente")
	public ResponseEntity<Object> cadastrarcliente (@RequestBody Cliente cliente){
		
		clienteRepository.save(cliente);
		
		return ResponseEntity.badRequest().body(true);
	}
	
	
}


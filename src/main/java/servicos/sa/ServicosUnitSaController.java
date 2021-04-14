package servicos.sa;

import java.util.Date;
import java.util.TimeZone;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.List;

import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import servicos.sa.domain.Busca;
import servicos.sa.domain.Cliente;
import servicos.sa.domain.Funcionario;
import servicos.sa.domain.Servico;
import servicos.sa.domain.ServicoExecutado;
import servicos.sa.repository.BuscaRepository;
import servicos.sa.repository.ClienteRepository;
import servicos.sa.repository.FuncionarioRepository;
import servicos.sa.repository.ServicoExecutadoRepository;
import servicos.sa.repository.ServicoRepository;



@RestController
@RequestMapping(value="/servicos")
public class ServicosUnitSaController {

	@Autowired
	FuncionarioRepository servicosRepository;
	
	
	@PostMapping("/cadastrar/funcionario")
	public ResponseEntity<Object> cadastrarfuncionario (@RequestBody Funcionario funcionario){
		
		
		
		servicosRepository.save(funcionario);
		
		return ResponseEntity.badRequest().body(true);
	}
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@PostMapping("/cadastrar/cliente")
	public ResponseEntity<Object> cadastrarcliente (@RequestBody Cliente cliente){
		
		clienteRepository.save(cliente);
		
		return ResponseEntity.badRequest().body(true);
	}
	
	@Autowired
	ServicoRepository servicoRepository;
	
	@PostMapping("/cadastrar/servico")
	public ResponseEntity<Object> cadastrarservico (@RequestBody Servico servico){
		
			servicoRepository.save(servico);
		
		return ResponseEntity.badRequest().body(true);
	}
	
	@Autowired
	ServicoExecutadoRepository servicoexecutadoRepository;
	BuscaRepository buscarepository;
	
	@PostMapping("/cadastrar/servicoexecutado")
	public ResponseEntity<Object> cadastrarservicoexecutado (@RequestBody ServicoExecutado servicoexecutado){
			 

			servicoexecutadoRepository.save(servicoexecutado);
		
		return ResponseEntity.badRequest().body(true);
	}
	

	 
	@GetMapping("/pesquisar")
	public ResponseEntity<Object> pesquisarServico(@RequestBody Busca busca ){
		
		List<ServicoExecutado> servico_executado_obtido = servicoexecutadoRepository.findAllByservico(busca.getServico());
		
		System.out.print(servico_executado_obtido);
		
		
		
		List<ServicoExecutado> result = servicoexecutadoRepository.findAllByDataBetween(busca.getDataInicio(), busca.getDataFim());
		

		return ResponseEntity.badRequest().body(result);
	}
	
}


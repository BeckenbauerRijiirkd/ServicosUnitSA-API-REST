package servicos.sa;

import java.util.*;
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
@RequestMapping(value = "/servicos")
public class ServicosUnitSaController {

	@Autowired
	FuncionarioRepository funcionarioRepository;

	@PostMapping("/cadastrar/funcionario")
	public ResponseEntity<Object> cadastrarfuncionario(@RequestBody Funcionario funcionario) {
		try {
			if (funcionarioRepository.existsBycpf(funcionario.getCpf()) == true) {

				return ResponseEntity.badRequest().body("Cadastro negado. Este funcionario ja esta cadastrado");
			} else {
				funcionarioRepository.save(funcionario);
				return ResponseEntity.badRequest().body("Funcionario: " + funcionario.getNome() + " Cadastrado");
			}
		} catch (Exception e) {

			e.printStackTrace();
			return ResponseEntity.badRequest().body(false);
		}
	}

	@Autowired
	ClienteRepository clienteRepository;

	@PostMapping("/cadastrar/cliente")
	public ResponseEntity<Object> cadastrarcliente(@RequestBody Cliente cliente) {

		try {
			if (clienteRepository.existsBycnpj(cliente.getCnpj()) == true) {

				return ResponseEntity.badRequest().body("Cadastro negado. Este Cliente ja esta cadastrado");
			} else {
				clienteRepository.save(cliente);
				return ResponseEntity.badRequest().body("Cliente: " + cliente.getNome() + " Cadastrado");
			}
		} catch (Exception e) {

			e.printStackTrace();
			return ResponseEntity.badRequest().body(false);
		}
	}

	@Autowired
	ServicoRepository servicoRepository;

	@PostMapping("/cadastrar/servico")
	public ResponseEntity<Object> cadastrarservico(@RequestBody Servico servico) {

		try {
			if (servicoRepository.existsBynome(servico.getNome()) == true) {

				return ResponseEntity.badRequest().body("Cadastro negado. Este Servico ja esta cadastrado");
			} else {
				servicoRepository.save(servico);
				return ResponseEntity.badRequest().body("Servico: " + servico.getNome() + " Cadastrado");
			}
		} catch (Exception e) {

			e.printStackTrace();
			return ResponseEntity.badRequest().body(false);
		}
	}

	@Autowired
	ServicoExecutadoRepository servicoexecutadoRepository;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD

=======
	
=======
	BuscaRepository buscarepository;
>>>>>>> parent of 26df80b (Busca_por_servico_e_data)
=======
	BuscaRepository buscarepository;
>>>>>>> parent of 26df80b (Busca_por_servico_e_data)
	
>>>>>>> 26df80b (Busca_por_servico_e_data)
	@PostMapping("/cadastrar/servicoexecutado")
	public ResponseEntity<Object> cadastrarservicoexecutado(@RequestBody ServicoExecutado servicoexecutado) {
		try {
			Funcionario funcionario = funcionarioRepository.findBynome(servicoexecutado.getFuncionario());
			Cliente cliente = clienteRepository.findBynome(servicoexecutado.getCliente());
			
		if (servicoRepository.existsBynome(servicoexecutado.getServico()) == true && funcionarioRepository.existsBycpf(funcionario.getCpf()) == true) {
			// && clienteRepository.existsBycnpj(cliente.getCnpj()) == true
			servicoexecutadoRepository.save(servicoexecutado);
			
		return ResponseEntity.badRequest().body("Serviço Executado do Servico: "+servicoexecutado.getServico()+" Cadastrado");
	}

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
		else {
			return ResponseEntity.badRequest().body("O Servico executado não foi cadastrado, porque o tipo de servico nao foi cadastrado previamente");
		}
	}catch (Exception e) {

		e.printStackTrace();
		return ResponseEntity.badRequest().body(false);
		}
	}
		

	@Autowired
	BuscaRepository buscarepository;

	@GetMapping("/pesquisar")
	public ResponseEntity<Object> pesquisarServico(@RequestBody Busca busca) {

		List<ServicoExecutado> servico_executado_obtido = servicoexecutadoRepository
				.findAllByservico(busca.getServico());

		List<ServicoExecutado> result = servicoexecutadoRepository.findAllByservico(busca.getServico());
		servicoexecutadoRepository.findAllByDataBetween(busca.getDataInicio(), busca.getDataFim());

		long tempoAux = 0;
		long tempoTotal = 0;

		for (int i = 0; i < servico_executado_obtido.size(); i++) {
			ServicoExecutado p = result.get(i);

			long tempoInicial = p.getHorarioInicio().getTime();
			long tempoFinal = p.getHorarioFinal().getTime();
			tempoAux = (tempoInicial - tempoFinal);
			tempoAux = tempoAux / (60 * 60 * 1000) % 24;
			tempoTotal = tempoTotal + tempoAux;

		}

		Servico servico_hora = servicoRepository.findBynome(busca.getServico());

		Long hora = servico_hora.getValor();

		Long valor_total = (hora * tempoTotal);

		return ResponseEntity.badRequest()
				.body("VALOR TOTAL: " + valor_total + "$" + " HORAS: " + tempoTotal + ", VALOR POR HORA: " + hora);
=======
	 @Autowired
	 BuscaRepository buscarepository;
=======
	 
>>>>>>> parent of 26df80b (Busca_por_servico_e_data)
=======
	 
>>>>>>> parent of 26df80b (Busca_por_servico_e_data)
	@GetMapping("/pesquisar")
	public ResponseEntity<Object> pesquisarServico(@RequestBody Busca busca ){
		
		List<ServicoExecutado> servico_executado_obtido = servicoexecutadoRepository.findAllByservico(busca.getServico());
		
		System.out.print(servico_executado_obtido);
		
		
		ServicoExecutado p = servico_executado_obtido.get(0);
		
		long tempoinicial = p.getHorarioInicio().getTime();
		long tempofinal = p.getHorarioFinal().getTime();
		Long tempototal = (tempoinicial - tempofinal); 
		tempototal = tempototal / (60 * 60 * 1000) % 24;
		
	
		
		System.out.print(tempoinicial);
		
		
		List<ServicoExecutado> result = servicoexecutadoRepository.findAllByDataBetween(busca.getDataInicio(), busca.getDataFim());
		

<<<<<<< HEAD
<<<<<<< HEAD
		return ResponseEntity.badRequest().body(result);
>>>>>>> 26df80b (Busca_por_servico_e_data)
=======
		return ResponseEntity.badRequest().body(tempototal);
>>>>>>> parent of 26df80b (Busca_por_servico_e_data)
=======
		return ResponseEntity.badRequest().body(tempototal);
>>>>>>> parent of 26df80b (Busca_por_servico_e_data)
	}

}

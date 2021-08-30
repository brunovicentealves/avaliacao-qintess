package avaliacao.qintess.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import avaliacao.qintess.response.dto.ClientDTO;
import avaliacao.qintess.service.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private ClientService clientService;

	@GetMapping("/find-all-vip")
	public ResponseEntity<Page<ClientDTO>> findAllClientVip(@RequestParam(value = "page", defaultValue = "0") Integer page,
					@RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
					@RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
					@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);

		return ResponseEntity.ok(clientService.findAllClientVipPaged(pageRequest));

	}

}

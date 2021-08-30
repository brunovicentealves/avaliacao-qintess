package avaliacao.qintess.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import avaliacao.qintess.request.dto.NumericRequestDTO;
import avaliacao.qintess.response.dto.NumericResponseDTO;
import avaliacao.qintess.service.NumericService;

@RestController
@RequestMapping("/numeric")
public class NumericController {

	@Autowired
	private NumericService numericService;

	@PostMapping
	public ResponseEntity<NumericResponseDTO> saveCategory(@RequestBody NumericRequestDTO dto) {

		return ResponseEntity.ok(numericService.checkingNumber(dto));

	}

}

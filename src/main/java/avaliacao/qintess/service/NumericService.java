package avaliacao.qintess.service;

import org.springframework.stereotype.Service;
import avaliacao.qintess.exception.NumericBadRequestException;
import avaliacao.qintess.request.dto.NumericRequestDTO;
import avaliacao.qintess.response.dto.NumericResponseDTO;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class NumericService {

	public NumericResponseDTO checkingNumber(NumericRequestDTO numeric) {

		log.info("validando se numero é menor ou igual a zero");
		validatingNumber(numeric.getNumeric());

		log.info("validando Verificando se numero é primo ou não é ");
		int dividerNumber = checkingIfNumberIsPrime(numeric.getNumeric());

		log.info("Retornando mensagem");
		return new NumericResponseDTO(returnMessage(numeric.getNumeric(), dividerNumber));

	}

	private void validatingNumber(int numeric) {
		log.info("validando se o numero é menor ou igual a zero");
		if (numeric <= 0) {
			throw new NumericBadRequestException("Numero precisa ser maior que zero");
		}
	}

	private int checkingIfNumberIsPrime(int numeric) {

		log.info("Realizando o calculo para ver se é numero primo");
		int dividerNumber = 0;

		for (int i = 1; i <= numeric; i++) {
			if (numeric % i == 0) {
				dividerNumber++;
			}
		}
		return dividerNumber;
	}

	private String returnMessage(int numeric, int dividerNumber) {
		if (dividerNumber == 2) {
			return "numero digitado " + numeric + " é primo ";
		} else {
			return "numero digitado " + numeric + " não é primo ";
		}
	}

}

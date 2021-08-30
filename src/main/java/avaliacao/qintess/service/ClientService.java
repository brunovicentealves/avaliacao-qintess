package avaliacao.qintess.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import avaliacao.qintess.model.Client;
import avaliacao.qintess.repository.ClientRepository;
import avaliacao.qintess.response.dto.ClientDTO;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ClientService {

	@Autowired
	private ClientRepository clietRepository;

	public Page<ClientDTO> findAllClientVipPaged(PageRequest pageRequest) {

		log.info("Retornando todos clientes que são vips ");
		Page<Client> client = clietRepository.findAllByClientVip(pageRequest);

		return client.map(x -> new ClientDTO(x));
	}

}

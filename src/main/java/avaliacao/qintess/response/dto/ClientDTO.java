package avaliacao.qintess.response.dto;

import avaliacao.qintess.enums.CustomerTypeEnum;
import avaliacao.qintess.model.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {

	private String name;

	private CustomerTypeEnum customerType;

	public ClientDTO(Client client) {

		this.name = client.getName();
		this.customerType = client.getCustomerType();
	}

}

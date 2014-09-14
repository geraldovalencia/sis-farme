package cadastroClientes;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;


@Entity
public class PessoaFisica extends Pessoa{
	
	@Column(unique = true)
	private String cpf;
	
	@XmlTransient
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	
	

}

package cadastroClientes;

import java.util.List;

import javax.persistence.*;


@Entity
public class PessoaJuridica extends Pessoa{
	
	@Column(unique = true)
	private String cnpj;
	
	@OneToMany
	private List<Produto> produtos;

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	
	

}

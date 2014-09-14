package cadastroClientes;

import java.util.List;

import javax.persistence.*;


@Entity
@PrimaryKeyJoinColumn(name="id")
public class Gerente extends Usuario{
	
	private String setor;
	
	
	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}


}

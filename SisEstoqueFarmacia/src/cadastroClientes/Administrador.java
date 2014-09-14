package cadastroClientes;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;


@Entity
@PrimaryKeyJoinColumn(name="id")
public class Administrador extends Usuario{
	
	private String EmpresaTerceirizada;
	
	
	
	public String getEmpresaTerceirizada() {
		return EmpresaTerceirizada;
	}



	public void setEmpresaTerceirizada(String empresaTerceirizada) {
		EmpresaTerceirizada = empresaTerceirizada;
	}



	public Administrador() {
		super();
	}


}

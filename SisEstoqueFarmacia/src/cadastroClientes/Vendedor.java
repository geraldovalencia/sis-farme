package cadastroClientes;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class Vendedor extends Usuario{
	
	
		private String setorVendedor;
		

		public String getSetorVendedor() {
			return setorVendedor;
		}


		public void setSetorVendedor(String setorVendedor) {
			this.setorVendedor = setorVendedor;
		}


		

}

package cadastroClientes;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Compra extends Movimento {
	
	@ManyToOne	
	private PessoaJuridica pj;

	public Compra(String notaFiscal) {
		super();
		NotaFiscal = notaFiscal;
	}

	public Compra() {
		super();
	}

	private String NotaFiscal;

	
	
	public PessoaJuridica getPj() {
		return pj;
	}

	public void setPj(PessoaJuridica pj) {
		this.pj = pj;
	}

	public String getNotaFiscal() {
		return NotaFiscal;
	}

	public void setNotaFiscal(String notaFiscal) {
		NotaFiscal = notaFiscal;
	}
	
	
	

}

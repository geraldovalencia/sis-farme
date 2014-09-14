package cadastroClientes;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@Entity
@XmlType(propOrder = { "pf" })
public class Venda extends Movimento{
	
	@ManyToOne	
	private PessoaFisica pf;	
	
	@XmlElement(name="compradorMedicamento")
	public PessoaFisica getPf() {
		return pf;
	}

	public void setPf(PessoaFisica pf) {
		this.pf = pf;
	}

	public Venda(float desconto) {
		super();
		this.desconto = desconto;
	}

	public Venda() {
		super();
		// TODO Auto-generated constructor stub
	}

	private float desconto;
	@XmlTransient
	public float getDesconto() {
		return desconto;
	}

	public void setDesconto(float desconto) {
		this.desconto = desconto;
	}
	
	

}

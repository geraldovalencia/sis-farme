package cadastroClientes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@SequenceGenerator(sequenceName="item_movimento_seq", name="item_movimento_id", allocationSize=1 )
public class ItemMovimento extends AbstractEntity{
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="item_movimento_id")
	private long id;
	
	private double quantidade;
	private double preco;
		
	@ManyToOne
	private Movimento movimento;
	@ManyToOne
	private Produto produto;

	
	public ItemMovimento(long id) {
		super();
		this.id = id;
	}

	public ItemMovimento() {
		super();
		// TODO Auto-generated constructor stub
	}
	@XmlTransient
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}
	@XmlTransient
	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	@XmlTransient
	public Movimento getMovimento() {
		return movimento;
	}

	public void setMovimento(Movimento movimento) {
		this.movimento = movimento;
	}

	@XmlTransient
	public Produto getProduto() {
		return produto;
	}
	
	@XmlElement(name="registroMSMedicamento")
	public String getRegistroMSMedicamento() {
		return produto.getRegistroMSMedicamento();
	}
	
	@XmlElement(name="numeroLoteMedicamento")
	public String getNumeroLoteMedicamento() {
		return produto.getNumeroLoteMedicamento();
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}

package cadastroClientes;

import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@Entity
@SequenceGenerator(sequenceName = "movimento_seq", name = "movimento_id", allocationSize = 1)
@XmlType(propOrder = { "itemMovimentos", "data" })
public class Movimento extends AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movimento_id")
	private long id;

	public Movimento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Movimento(long id) {
		super();
		this.id = id;
	}

	@Temporal(TemporalType.DATE)
	private Date data;

	private float total;

	@ManyToOne
	private Usuario usuario;

	@OneToMany(mappedBy = "movimento", cascade = CascadeType.ALL)
	private List<ItemMovimento> itemMovimentos;

	// Gets
	@XmlTransient
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	@XmlTransient
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	@XmlElement(name="medicamentoVenda")
	public List<ItemMovimento> getItemMovimentos() {
		return itemMovimentos;
	}
	
	public void removerItemPorID(int id){
		for (ItemMovimento item : itemMovimentos) {
			if(item.getProduto().getId() == id){
				itemMovimentos.remove(item);
			}
		}
	}

	public void setItemMovimentos(List<ItemMovimento> itemMovimentos) {
		this.itemMovimentos = itemMovimentos;
	}
	@XmlElement(name="dataVendaMedicamento")
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	@XmlTransient
	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

}

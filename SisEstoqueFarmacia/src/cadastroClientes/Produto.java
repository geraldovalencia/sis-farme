package cadastroClientes;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@SequenceGenerator(sequenceName="produto_seq", name="produto_id", allocationSize=1)
public class Produto extends AbstractEntity{
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="produto_id")
	private long id;
	private String nome;
	private Double precovenda;
	private Double qtde_estoque;
	
	@Column(unique = true)
	private String registroMSMedicamento;
	
	private String numeroLoteMedicamento;
	
	@Temporal(TemporalType.DATE)
	private Calendar dataRecebimentoMedicamento;
	
	@ManyToOne
	private PessoaJuridica pessoaJuridica;
	
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Unidade getUnidade() {
		return unidade;
	}
	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}
	public Produto(long id) {
		super();
		this.id = id;
	}
	public Produto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@ManyToOne
	private Categoria categoria;
	
	@ManyToOne
	private Unidade unidade;
	
	private String marca;
	
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	@XmlTransient
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getPrecovenda() {
		return precovenda;
	}
	public void setPrecovenda(Double precovenda) {
		this.precovenda = precovenda;
	}
	public Double getQtde_estoque() {
		return qtde_estoque;
	}
	public void setQtde_estoque(Double qtde_estoque) {
		this.qtde_estoque = qtde_estoque;
	}
	public String getRegistroMSMedicamento() {
		return registroMSMedicamento;
	}
	public void setRegistroMSMedicamento(String registroMSMedicamento) {
		this.registroMSMedicamento = registroMSMedicamento;
	}
	public String getNumeroLoteMedicamento() {
		return numeroLoteMedicamento;
	}
	public void setNumeroLoteMedicamento(String numeroLoteMedicamento) {
		this.numeroLoteMedicamento = numeroLoteMedicamento;
	}
	public PessoaJuridica getPessoaJuridica() {
		return pessoaJuridica;
	}
	public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}
	public Calendar getDataRecebimentoMedicamento() {
		return dataRecebimentoMedicamento;
	}
	public void setDataRecebimentoMedicamento(Calendar dataRecebimentoMedicamento) {
		this.dataRecebimentoMedicamento = dataRecebimentoMedicamento;
	}
	


	
}

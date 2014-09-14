package cadastroClientes;

import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@SequenceGenerator(sequenceName="pessoa_seq", name="pessoa_id", allocationSize=1)
public class Pessoa extends AbstractEntity{
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pessoa_id")
	private long id;
	private String nome;
	private String emal;
	private String telefone;
	private String celular;
	private String rg;
	private String orgaoExpedidor;
	
	@Enumerated(EnumType.STRING)	
	private Uf uf;
	
	
	@XmlElement(name="numeroDocumento")
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	@XmlElement(name="UFEmissaoDocumento")
	public Uf getUf() {
		return uf;
	}
	public void setUf(Uf uf) {
		this.uf = uf;
	}
	@XmlElement(name="orgaoExpedidor")
	public String getOrgaoExpedidor() {
		return orgaoExpedidor;
	}
	public void setOrgaoExpedidor(String orgaoExpedidor) {
		this.orgaoExpedidor = orgaoExpedidor;
	}
	public Pessoa(long id) {
		super();
		this.id = id;
	}
	public Pessoa() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Embedded//QUando é embedded se coloca que tipo de anotation usa, ou se usa ou não.
	private Endereco endereco;
	
	@XmlTransient
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	@XmlTransient
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@XmlElement(name="nomeComprador")
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@XmlTransient
	public String getEmal() {
		return emal;
	}
	public void setEmal(String emal) {
		this.emal = emal;
	}
	@XmlTransient
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	@XmlTransient
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	
	
	
	
	
	
	

}

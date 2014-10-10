package Entidades;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;


@Entity
@PrimaryKeyJoinColumn(name="id")
public class Governador extends Candidato {
	

	@Column(name="numero", length=2, nullable=false)
	private String numero;
	private String coligacao;
	
	@Enumerated(EnumType.STRING)	
	private Uf uf;
	
	public Uf getUf() {
		return uf;
	}
	public void setUf(Uf uf) {
		this.uf = uf;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getColigacao() {
		return coligacao;
	}
	public void setColigacao(String coligacao) {
		this.coligacao = coligacao;
	}

}

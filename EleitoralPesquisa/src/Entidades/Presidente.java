package Entidades;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class Presidente extends Candidato {
	
	@Column(name="numero", length=2, nullable=false)
	private String numero;
	private String coligacao;
	
	
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

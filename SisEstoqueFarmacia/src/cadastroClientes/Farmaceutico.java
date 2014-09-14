package cadastroClientes;

import java.util.List;

import javax.persistence.*;


@Entity
@PrimaryKeyJoinColumn(name="id")
public class Farmaceutico extends Usuario {
	
	
	private String titulacao;
	
	@Column(unique = true)
	private String crf;
	
	
	public String getTitulacao() {
		return titulacao;
	}
	public void setTitulacao(String titulacao) {
		this.titulacao = titulacao;
	}
	public String getCrf() {
		return crf;
	}
	public void setCrf(String crf) {
		this.crf = crf;
	}
	
	

}

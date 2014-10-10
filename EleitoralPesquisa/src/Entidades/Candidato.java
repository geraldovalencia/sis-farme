package Entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;


@Entity
@SequenceGenerator(sequenceName="candidato_seq", name="candidato_id", allocationSize=1)
@Inheritance(strategy = InheritanceType.JOINED)
public class Candidato extends AbstractEntidade{
	

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="candidato_id")
	private long id;
	private String nome;
	private String partido;
	private int votos;
	
	
	public int getVotos() {
		return votos;
	}
	public void setVotos(int votos) {
		this.votos = votos;
	}
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
	public String getPartido() {
		return partido;
	}
	public void setPartido(String partido) {
		this.partido = partido;
	}
	
	
	
	

	
	

}

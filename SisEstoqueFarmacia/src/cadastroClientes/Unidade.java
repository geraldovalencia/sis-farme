package cadastroClientes;

import javax.persistence.*;

@Entity
@SequenceGenerator(sequenceName="unidade_seq", name="unidade_id", allocationSize=1)
public class Unidade extends AbstractEntity {
		
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="unidade_id")
	private long id;
	
	private String nome;


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	

}

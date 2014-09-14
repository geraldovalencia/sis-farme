package cadastroClientes;

import javax.persistence.*;


@Entity
@SequenceGenerator(sequenceName="categoria_seq", name="categoria_id", allocationSize=1)
public class Categoria extends AbstractEntity{
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="categoria_id")
	private long id;
	
	@Column(columnDefinition="boolean default FALSE")
	private boolean controlado;
	private String nome;
	

	public boolean isControlado() {
		return controlado;
	}

	public void setControlado(boolean controlado) {
		this.controlado = controlado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Categoria(long id) {
		super();
		this.id = id;
	}

	public Categoria() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	
	
	
	

}

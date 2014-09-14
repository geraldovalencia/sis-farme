package cadastroClientes;

import javax.persistence.*;



@Entity
@SequenceGenerator(name="usuario_id", sequenceName="usuario_seq", allocationSize=1)
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario extends AbstractEntity{

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="usuario_id")
	private Long id;
	
	@Column(unique = true)
	private String login;
	
	private String senha;
	private String nome;
	
	@Column(unique = true)
	private String cpf;
	
	@Column(unique = true)
	private String matricula;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name="Tipo_Usuario")
	private Tipo tipo;
	
	
	

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	@Override
	public long getId() {
		return id;
	}

	@Override
	public void setId(long id) {
		this.id = id;
		
	}
	
	

}
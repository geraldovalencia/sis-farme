package br.com.cocodonto.modelo.entidade;

public class Endereco {
	
	private String rua;
	private String cidade;
	private String cep;
	private SexoType bairro;

	public Endereco() {
	}

	
	public String getRua() {
		return rua;
	}


	public void setRua(String rua) {
		this.rua = rua;
	}


	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public SexoType getBairro() {
		return bairro;
	}

	public void setBairro(SexoType bairro) {
		this.bairro = bairro;
	}
}
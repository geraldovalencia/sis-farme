package Facada;

import java.sql.Date;

import javax.persistence.Column;

public class notaFiscalEntradaMedicamento {
	
	@Column(unique = true)
	private String numeroNotaFiscal;
	
	private String tipoOperacaoNotaFiscal;
	
	private Date dataNotaFiscal;
	
	private String cnpjOrigem;
	private String cnpjDestino;
	
	
	
	
	public String getNumeroNotaFiscal() {
		return numeroNotaFiscal;
	}
	public void setNumeroNotaFiscal(String numeroNotaFiscal) {
		this.numeroNotaFiscal = numeroNotaFiscal;
	}
	public String getTipoOperacaoNotaFiscal() {
		return tipoOperacaoNotaFiscal;
	}
	public void setTipoOperacaoNotaFiscal(String tipoOperacaoNotaFiscal) {
		this.tipoOperacaoNotaFiscal = tipoOperacaoNotaFiscal;
	}
	public Date getDataNotaFiscal() {
		return dataNotaFiscal;
	}
	public void setDataNotaFiscal(Date dataNotaFiscal) {
		this.dataNotaFiscal = dataNotaFiscal;
	}
	public String getCnpjOrigem() {
		return cnpjOrigem;
	}
	public void setCnpjOrigem(String cnpjOrigem) {
		this.cnpjOrigem = cnpjOrigem;
	}
	public String getCnpjDestino() {
		return cnpjDestino;
	}
	public void setCnpjDestino(String cnpjDestino) {
		this.cnpjDestino = cnpjDestino;
	}
	
	

}

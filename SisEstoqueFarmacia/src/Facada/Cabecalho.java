package Facada;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "cnpjEmissor", "cpfTransmissor", "dataInicio", "dataFim" })
public class Cabecalho{
	
	@XmlElement(name = "cnpjEmissor")
	private String cnpjEmissor = "88998899000101";
	
	
	private String cpfTransmissor;

	private String dataInicio;
	
	private String dataFim;
	
	public String getCpfTransmissor() {
		return cpfTransmissor;
	}

	public void setCpfTransmissor(String cpfTransmissor) {
		this.cpfTransmissor = cpfTransmissor;
	}


	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDataFim() {
		return dataFim;
	}

	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}
	
	
	
	
	
	
}

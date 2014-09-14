package Facada;

import javax.xml.bind.annotation.*;

@XmlRootElement(name="mensagemSNGPC")
@XmlType(propOrder = { "cabecalho", "corpo"})
public class Sngpc {
	
	@XmlAttribute
	private String xmlns = "urn:sngpc-schema" ;
	
	private Cabecalho cabecalho = new Cabecalho();
	
	private Corpo corpo = new Corpo();
	
	public Cabecalho getCabecalho() {
		return cabecalho;
	}

	public void setCabecalho(Cabecalho cabecalho) {
		this.cabecalho = cabecalho;
	}

	public Corpo getCorpo() {
		return corpo;
	}

	public void setCorpo(Corpo corpo) {
		this.corpo = corpo;
	}


	
	
	
	
	
	
	
	
	
	
//	private String mensagemSNGPC = new String("cnpjEmissor");
//		private Attribute xmlns = new Attribute("xmlns", "urn:sngpc-schema");
//			private String cabecalho = new String("cabecalho");
//				private String cnpjEmissor = new String("cnpjEmissor");
//				private String cpfTransmissor = new String("cpfTransmissor");
//				private String dataInicio = new String("dataInicio");
//				private String dataFim = new String("dataFim");
//	
//				
//			private String corpo = new String("corpo");
//				private String medicamentos = new String("medicamentos");
//	//Essa parte precisa ser dinamica, pois ela será preenchida por um foreach de uma lista de resultado que vem do banco
//				private String entradaMedicamentos = new String("entradaMedicamentos");
//					private String notaFiscalEntradaMedicamento = new String("notaFiscalEntradaMedicamento");
//						private String numeroNotaFiscal = new String("numeroNotaFiscal");
//						private String dataNotaFiscal = new String("dataNotaFiscal");
//						private String cnpjOrigem = new String("cnpjOrigem");
//						private String cnpjDestino = new String("cnpjDestino");
//					private String medicamentoEntrada = new String("medicamentoEntrada");
//						private String registroMSMedicamentoENT = new String("registroMSMedicamento");
//						private String numeroLoteMedicamentoENT = new String("numeroLoteMedicamento");
//						private String quantidadeMedicamentoENT = new String("quantidadeMedicamento");
//					private String dataRecebimentoMedicamento = new String("dataRecebimentoMedicamento");
//				
//	//Essa parte precisa ser dinamica, pois ela será preenchida por um foreach de uma lista de resultado que vem do banco
//				private String saidaMedicamentoVendaAoConsumidor = new String("saidaMedicamentoVendaAoConsumidor");
//					private String compradorMedicamento = new String("compradorMedicamento");
//						private String nomeCliente = new String("nomeCliente");
//						private String cpfCliente = new String("cpfCliente");
//					private String medicamentoVenda = new String("medicamentoVenda");
//						private String registroMSMedicamentoVEN = new String("registroMSMedicamento");
//						private String numeroLoteMedicamentoVEN = new String("numeroLoteMedicamento");
//						private String quantidadeMedicamentoVEN = new String("quantidadeMedicamento");
//					private String dataVendaMedicamento = new String("dataVendaMedicamento");
//	
//	//Fazer uma consulta no banco, que deve ser num servletS - ISSO é JDOM
//	
//		
//		
//		String relatorio = new String("RelatorioSngpc");
//		String cabecalho = new String("cabecalho");
//		String cnpj = new String("cnpjEmissor");
//		String cpf = new String("cpfTransmissor");
//		String corpo = new String("corpo");
//		
//		
//		String medicamentos = new String("medicamentos");
//		String entradaMedicamentos = new String("entradaMedicamentos");
//		String classeTerapeutica = new String("classeTerapeutica");
//		
//		
//		
//	   Produto prod = new Produto();
//	   Unidade unidade = new Unidade();
//	   
//	   public void setarStringos(){
//		   medicamentos.addContent(entradaMedicamentos);
//		   medicamentos.addContent(classeTerapeutica);
//		   medicamentos.addContent(unidade.getNome());
//		   medicamentos.addContent(prod.getNome());
//		   
//		   corpo.addContent(medicamentos);
//		   cabecalho.addContent(cnpj);
//		   cabecalho.addContent(cpf);
//		   
//		   relatorio.addContent(cabecalho);
//		   relatorio.addContent(corpo);
//		   
//		   doc.setRootString(relatorio);
//	   }
//	   

}



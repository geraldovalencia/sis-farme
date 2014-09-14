package Servlets;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.stream.StreamResult;

import DAO.VendaDAO;
import Facada.Facada;
import Facada.Sngpc;
import cadastroClientes.ItemMovimento;
import cadastroClientes.PessoaFisica;
import cadastroClientes.Usuario;
import cadastroClientes.Venda;

public class GerarXMLSngpcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GerarXMLSngpcServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
		String dataAtual = (String) session.getAttribute("dataAtual");
		String dataInicio = request.getParameter("dataInicio");
		
		
		System.out.println("Nome Farmaceutico: "+usuarioLogado.getNome());
		System.out.println("-----------------------------------------------");
		System.out.println("              XML GERADO POR JAXB              ");
		System.out.println("-----------------------------------------------");
		
		Sngpc sngpc = new Sngpc();

		ArrayList<Venda> vendas = Facada.listarTodasVendasComControlado();
		
		String dataVendaBanco = null;
		String dataInicioReq = null;
		
		sngpc.getCabecalho().setCpfTransmissor(usuarioLogado.getCpf());
		sngpc.getCabecalho().setDataInicio(dataInicio);
		sngpc.getCabecalho().setDataFim(dataAtual);
		
		Venda vendaParaXML = null;
		ArrayList<Venda> vendaParaXMLs = new ArrayList<>();;
		
		List <ItemMovimento> it = (List<ItemMovimento>) Facada.listarTodosComTesteControlados();
		
		
		for (Venda venda : vendas) {
			
			dataVendaBanco = venda.getData().toString();
			vendaParaXML = new Venda();
			
			if(dataVendaBanco.equals(dataInicio)){
				
				
				vendaParaXML.setItemMovimentos(venda.getItemMovimentos());
				vendaParaXML.setPf(venda.getPf()); 
				vendaParaXML.setData(venda.getData()); 
				vendaParaXMLs.add(vendaParaXML);
				
				System.out.println("\n---------------[ Elementos para XML ]------------------");
				System.out.println("PESSOA FISICA: "+ venda.getPf().getNome());
				System.out.println("DATA: "+ venda.getData());
				System.out.println("ITENS: "+ venda.getItemMovimentos());
				
			}
			System.out.println("---------------[    FIM DA LISTA    ]------------------");
		}
		sngpc.getCorpo().getMedicamentos().setSaidaMedicamentoVendaAoConsumidor(vendaParaXMLs);
		
		try{
			
//			JAXBContext context = JAXBContext.newInstance(Sngpc.class);
//			Marshaller marshaller = context.createMarshaller();
//			
//			FileWriter fw = new FileWriter("xmlAnvisa.xml");
//			
//			marshaller.marshal(sngpc, fw);
//			marshaller.marshal(sngpc, System.out);
			
			//-------------------------------------------------------------------------
			
			//Codigo para gerar XML  no CONSOLE
			
			JAXBContext context = JAXBContext.newInstance(Sngpc.class);
		    Marshaller m = context.createMarshaller();
		    m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		    // Write to System.out
		    m.marshal(sngpc, System.out);
		    
		    m.marshal(sngpc, new FileOutputStream("C:\\Users\\Valencia\\Desktop\\Relatorios\\Arquivo.xml"));  
		    
		    
		}catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		response.sendRedirect("/SisEstoqueFarmacia/principal.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

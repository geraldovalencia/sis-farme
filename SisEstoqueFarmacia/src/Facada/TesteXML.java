package Facada;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class TesteXML {

	public static void main(String[] args) {
		// 

		try{
			JAXBContext context = JAXBContext.newInstance(Sngpc.class);
		    Marshaller m = context.createMarshaller();
		    m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

		    // Write to System.out
		    m.marshal(new Sngpc(), System.out);
		}catch(JAXBException e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

}

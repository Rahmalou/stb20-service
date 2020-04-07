package fr.univ.rouen.stb.util;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.stereotype.Component;

import net.sf.saxon.TransformerFactoryImpl;

@Component
public class TransformXML {
	
	public String transformStbXSL(String stb) throws TransformerException {
		TransformerFactory tFactory = new TransformerFactoryImpl();
	
		Transformer transformer = tFactory.newTransformer(new StreamSource(getClass().getResourceAsStream("/stb20.xsl")));
		
		StringWriter sw = new StringWriter();
		
		transformer.transform(new StreamSource(new StringReader(stb)), new StreamResult(sw));
		
		return sw.toString();
		
	}
	
	public String transformStbListXSL(String stbs) throws TransformerException {
		TransformerFactory tFactory = new TransformerFactoryImpl();
	
		Transformer transformer = tFactory.newTransformer(new StreamSource(getClass().getResourceAsStream("/stbs.xsl")));
		
		StringWriter sw = new StringWriter();
				
		transformer.transform(new StreamSource(new StringReader(stbs)), new StreamResult(sw));
		
		return sw.toString();
		
	}
	
	
	public String transformHelpXSL(String help) throws TransformerException {
		TransformerFactory tFactory = new TransformerFactoryImpl();
	
		Transformer transformer = tFactory.newTransformer(new StreamSource(getClass().getResourceAsStream("/help.xsl")));
		
		StringWriter sw = new StringWriter();
		
		transformer.transform(new StreamSource(new StringReader(help)), new StreamResult(sw));
		
		return sw.toString();
		
	}
	
	public String transformHomeXSL(String projet) throws TransformerException {
		TransformerFactory tFactory = new TransformerFactoryImpl();
	
		Transformer transformer = tFactory.newTransformer(new StreamSource(getClass().getResourceAsStream("/home.xsl")));
		
		StringWriter sw = new StringWriter();
		
		transformer.transform(new StreamSource(new StringReader(projet)), new StreamResult(sw));
		
		return sw.toString();
		
	}
	
	public String transformResponseXSL(String response) throws TransformerException {
		TransformerFactory tFactory = new TransformerFactoryImpl();
	
		Transformer transformer = tFactory.newTransformer(new StreamSource(getClass().getResourceAsStream("/response.xsl")));
		
		StringWriter sw = new StringWriter();
		
		transformer.transform(new StreamSource(new StringReader(response)), new StreamResult(sw));
		
		return sw.toString();
		
	}
	

}

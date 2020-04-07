package fr.univ.rouen.stb.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;

import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import fr.univ.rouen.stb.models.Response;

@Component
public class ValidateXML {

	public static final String SCHEMA_LANGUAGE = "http://www.w3.org/2001/XMLSchema";
	public static final String STB_XSD_FILE = "/stb20.xsd";

	public Response validateStb(String stb) {
		SimpleErrorHandler errorHandler = new SimpleErrorHandler(); 

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setValidating(false);
		factory.setNamespaceAware(true);

		SchemaFactory schemaFactory = 
				SchemaFactory.newInstance(SCHEMA_LANGUAGE);
		DocumentBuilder builder = null;

		try {
			factory.setSchema(schemaFactory.newSchema(
					new Source[] {new StreamSource(getClass().getResourceAsStream(STB_XSD_FILE))}));
			builder = factory.newDocumentBuilder();
			builder.setErrorHandler(errorHandler);
			InputStream is = new ByteArrayInputStream(stb.getBytes(StandardCharsets.UTF_8));
			builder.parse(is);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			return new Response(Response.Type.ERROR, e.getMessage());
		} 

		if (errorHandler.hasError() == false) {
			return new Response(Response.Type.OK);
		} else {
			return new Response(Response.Type.ERROR, errorHandler.getDebugMessage());
		}
	}
}

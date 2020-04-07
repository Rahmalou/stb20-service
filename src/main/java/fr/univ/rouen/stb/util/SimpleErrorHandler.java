package fr.univ.rouen.stb.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class SimpleErrorHandler implements ErrorHandler {
	private boolean errorOccured;
	private transient Logger logger = LoggerFactory.getLogger(SimpleErrorHandler.class);
	private String debugMessage ="";
	
	public SimpleErrorHandler() {
		errorOccured =  false;
	}
	public void warning(SAXParseException exception) throws SAXException {
		errorOccured =  true;
		logger.warn(exception.getMessage());
	}

	public void error(SAXParseException exception) throws SAXException {
		errorOccured =  true;
		logger.error(exception.getMessage());
		if (!debugMessage.isBlank()) {
			debugMessage += "\n";
		}
		debugMessage += exception.getMessage();
	}

	public void fatalError(SAXParseException exception) throws SAXException {
		errorOccured =  true;
		logger.error(exception.getMessage());
	}
	
	public boolean hasError() {
		return errorOccured;
	}
	public String getDebugMessage() {
		return debugMessage;
	}
	public void setDebugMessage(String debugMessage) {
		this.debugMessage = debugMessage;
	}

}

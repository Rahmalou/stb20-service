package fr.univ.rouen.stb.models;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="person")
@XmlAccessorType(XmlAccessType.FIELD)
public class Person {
	@XmlElement
	private Firstname firstname;

	@XmlElement(name="function")
	private List<String> functions;
	
	public Firstname getFirstname() {
		return firstname;
	}
	public void setFirstname(Firstname firstname) {
		this.firstname = firstname;
	}
	
	public List<String> getFunctions() {
		return functions;
	}
	public void setFunctions(List<String> functions) {
		this.functions = functions;
	}
	
	
}

package fr.univ.rouen.stb.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="author")
@XmlAccessorType(XmlAccessType.FIELD)
public class Author {
	
	private String lastname;
	private String firstname;
	
	public Author(String lastname, String firstname) {
		setLastname(lastname);
		setFirstname(firstname);
	}
	
	public Author() {}
	
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
}

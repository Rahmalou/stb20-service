package fr.univ.rouen.stb.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name="firstname")
@XmlAccessorType(XmlAccessType.FIELD)
public class Firstname {
	@XmlValue
	private String value;
	@XmlAttribute
	private String lastname;
	@XmlAttribute
	private String gender;
	@XmlAttribute
	private String mail;
	
	
	public Firstname() {}
	
	
	public Firstname(String value, String lastname, String gender, String mail) {
		this.value = value;
		this.lastname = lastname;
		this.gender = gender;
		this.mail = mail;
	}


	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
}

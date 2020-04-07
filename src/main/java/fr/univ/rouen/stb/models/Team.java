package fr.univ.rouen.stb.models;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="team")
@XmlAccessorType(XmlAccessType.FIELD)
public class Team {
	@XmlElement(name="person")
	private List<Person> persons;
	
	public Team() {}
	
	public Team(List<Person> persons) {
		this.persons = persons;
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
}

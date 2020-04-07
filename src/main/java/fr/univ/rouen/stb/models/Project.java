package fr.univ.rouen.stb.models;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name="project")
@XmlAccessorType(XmlAccessType.FIELD)
public class Project implements Serializable{
	
	private static final long serialVersionUID = 1176819328699622097L;
	@XmlElement(name="author")
	private List<Author> authors;
	@XmlElement
	private String name;
	
	@XmlElement
	private String version;
	
	@XmlElement
	private String date;
	
	@XmlElement(name="command")
	private List<Command> commands;
	
	@XmlElement
	private String image;
	
	
	public Project(List<Author> authors, String name, String date, List<Command> commands, String v, String image) {
		this.authors = authors;
		this.name = name;
		this.date = date;
		this.commands = commands;
		this.version = v;
		this.image = image;
	}
	
	public Project() {}
	
	public List<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public List<Command> getCommands() {
		return commands;
	}
	public void setCommands(List<Command> commands) {
		this.commands = commands;
	}
	
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}

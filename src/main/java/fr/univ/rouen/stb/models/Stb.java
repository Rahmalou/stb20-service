package fr.univ.rouen.stb.models;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import fr.univ.rouen.stb.util.DateAdapter;

@XmlRootElement(name="stb")
@XmlAccessorType(XmlAccessType.FIELD)
public class Stb {

	@XmlElement
	private String title;
	@XmlElement
	private double version;
	@XmlElement
	@XmlJavaTypeAdapter(DateAdapter.class)
	private Date date;
	@XmlElement
	private String description;
	@XmlElement
	private Client client;
	@XmlElement
	private Team team;
	@XmlElement
	private Detail detail;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getVersion() {
		return version;
	}
	public void setVersion(double version) {
		this.version = version;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
	public Detail getDetail() {
		return detail;
	}
	public void setDetail(Detail detail) {
		this.detail = detail;
	}
	
	
}

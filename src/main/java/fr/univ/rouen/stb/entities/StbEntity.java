package fr.univ.rouen.stb.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="stb")
public class StbEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String title;
	
	private double version;
	
	private Date date;
	
	private String description;
	
	@OneToOne(cascade = CascadeType.ALL)
	private ClientEntity client;
	
	@OneToMany(mappedBy="stb", cascade = CascadeType.ALL)
	private List<PersonEntity> persons;
	
	@OneToMany(mappedBy="stb", cascade = CascadeType.ALL)
	private  List<FeatureEntity> features;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public ClientEntity getClient() {
		return client;
	}
	public void setClient(ClientEntity client) {
		this.client = client;
	}
	public List<PersonEntity> getPersons() {
		return persons;
	}
	public void setPersons(List<PersonEntity> persons) {
		this.persons = persons;
	}
	public List<FeatureEntity> getFeatures() {
		return features;
	}
	public void setFeatures(List<FeatureEntity> features) {
		this.features = features;
	}
	
	
}

package fr.univ.rouen.stb.models;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import fr.univ.rouen.stb.util.DateAdapter;

@XmlRootElement(name="feature")
@XmlAccessorType(XmlAccessType.FIELD)
public class Feature {

	@XmlElement
	private String description;
	@XmlElement
	private int priority;
	@XmlElement
	@XmlJavaTypeAdapter(DateAdapter.class)
	private Date delivery;
	@XmlAttribute
	private String name;
	@XmlAttribute
	private int section;
	@XmlAttribute
	private int number;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public Date getDelivery() {
		return delivery;
	}
	public void setDelivery(Date delivery) {
		this.delivery = delivery;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSection() {
		return section;
	}
	public void setSection(int section) {
		this.section = section;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	
}

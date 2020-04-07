package fr.univ.rouen.stb.models;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="stbs")
@XmlAccessorType(XmlAccessType.FIELD)
public class Stbs {
	
	@XmlElement(name="stb")
	private List<StbWithId> values;
	
	public Stbs() {}

	
	
	public Stbs(List<StbWithId> values) {
		super();
		this.values = values;
	}



	public List<StbWithId> getValues() {
		return values;
	}

	public void setValues(List<StbWithId> values) {
		this.values = values;
	}
	
	
}

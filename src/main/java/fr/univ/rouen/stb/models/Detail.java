package fr.univ.rouen.stb.models;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="detail")
@XmlAccessorType(XmlAccessType.FIELD)
public class Detail {
	@XmlElement(name="feature")
	private  List<Feature> features;
	
	public Detail() {}
	
	public Detail(List<Feature> features) {
		this.features = features;
	}
	
	public List<Feature> getFeatures() {
		return features;
	}
	public void setFeatures(List<Feature> features) {
		this.features = features;
	}
	
	
	
}

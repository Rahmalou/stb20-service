package fr.univ.rouen.stb.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="response")
@XmlAccessorType(XmlAccessType.FIELD)
public class Response {
	private int id;
	private Type status;
	private String description;
	
	public Response() {}
	
	public Response(int id, Type status) {
		this.id = id;
		this.status = status;
	}
	public Response(int id, Type status, String message) {
		this.id = id;
		this.status = status;
		this.description = message;
	}
	
	public Response(Type status) {
		this.status = status;
	}
	
	
	public Response(Type status, String message) {
		this.status = status;
		this.description = message;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Type getStatus() {
		return status;
	}


	public void setStatus(Type status) {
		this.status = status;
	}



	public String getDescription() {
		return description;
	}


	public void setDescription(String message) {
		this.description = message;
	}



	public static enum Type{
		OK,
		INSERTED,
		DELETED,
		UPDATED,
		ERROR,
		NONE
	}
}

package fr.univ.rouen.stb.models;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="command")
@XmlAccessorType(XmlAccessType.FIELD)
public class Command {
	private String url;
	private String method;
	private String description;
	
	
	public Command(String url, String method, String description) {
		this.url = url;
		this.method = method;
		this.description = description;
	}
	
	public Command() {}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getMethod() {
		return method;
	}
	public void setMethode(String method) {
		this.method = method;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public static List<Command> getCommands() {
		List<Command> result = new ArrayList<>();
		result.add(new Command("/", "GET", "Affiche la page d’accueil du projet. Format de retour : HTML"));
		result.add(new Command("/help", "GET", "Affiche la page contenant les informations d’aide. Format de retour : HTML"));
		result.add(new Command("/resume", "GET ou POST", "Affiche la liste des STB stockées. Format de retour : XML"));
		result.add(new Command("/stb?id=<id>", "GET", "<id> = valeur numérique de l’identifiant. Retourne le contenu complet de la STB dont l’identifiant est <id>. Format de retour : XML"));
		result.add(new Command("/htmlstb?id=<id>", "GET", "<id> = valeur numérique de l’identifiant. Retourne le contenu complet de la STB dont l’identifiant est <id>. Format de retour : HTMML"));
		result.add(new Command("/insert", "PUT", "Le flux reçu est validé par le schéma XSD de définition STB20. " + 
				"Si le flux est déjà présent (titre et version identique) alors une indication d’erreur est retournée. " + 
				"Si l’opération réussie, alors le flux est ajouté à la base et sa persistance est assurée. " + 
				"La valeur d'identifiant est automatiquement créée si l'insertion est effectuée. " + 
				"Format d'entrée et de retour : XML"));
		result.add(new Command("/delete?id=<id>", "DELETE", "<id> = valeur numérique de l’identifiant. Suppression de la STB dont l’identifiant est <id> " + 
				"Format de retour : XML." ));
		
		return result;
	}
}

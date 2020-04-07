package fr.univ.rouen.stb.services;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import javax.xml.transform.TransformerException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.univ.rouen.stb.entities.StbEntity;
import fr.univ.rouen.stb.mappers.StbMapper;
import fr.univ.rouen.stb.mappers.StbWithIdMapper;
import fr.univ.rouen.stb.models.Author;
import fr.univ.rouen.stb.models.Command;
import fr.univ.rouen.stb.models.Project;
import fr.univ.rouen.stb.models.Response;
import fr.univ.rouen.stb.models.Stb;
import fr.univ.rouen.stb.models.Stbs;
import fr.univ.rouen.stb.repository.StbRepository;
import fr.univ.rouen.stb.util.TransformXML;
import fr.univ.rouen.stb.util.ValidateXML;


@Service
public class StbService {

	@Autowired
	private TransformXML transformer;

	@Autowired
	private JaxService mapper;

	@Autowired
	private ValidateXML validator;

	@Autowired
	private StbRepository stbRepository;
	
	private transient Logger logger = LoggerFactory.getLogger(StbService.class);



	public String getHelp() {
		try {
			List<Command> commands = Command.getCommands();
			Project project = new Project(Arrays.asList(new Author("RAHMANI", "Lounis")),
					"STB20", "2020-04-07", commands, "v03",
					"https://www.nae.fr/wp-content/uploads/2014/06/logo-univ-rouen-800x450.jpg");
			return transformer.transformHelpXSL(mapper.marchall(project));

		} catch (TransformerException e) {
			logger.error("Tranformation XSLT ", e);
			return null;
		}

	}

	public String getHome() {
		try {
			List<Command> commands = Command.getCommands();
			Project project = new Project(Arrays.asList(new Author("RAHMANI", "Lounis")),
					"STB20", "2020-04-07", commands, "v03", 
					"https://www.nae.fr/wp-content/uploads/2014/06/logo-univ-rouen-800x450.jpg");
			return transformer.transformHomeXSL(mapper.marchall(project));

		} catch (TransformerException e) {
			logger.error("Tranformation XSLT ", e);
			return null;
		}

	}

	public String getAllStbs() {
		try {
			return transformer.transformStbListXSL(mapper.marchall(
					new Stbs(StbWithIdMapper.INSTANCE.toModels(stbRepository.findAll()))));
		} catch (TransformerException e) {
			logger.error("Tranformation XSLT ", e);
			return null;
		}
	}

	public String findById(int id) throws NoSuchElementException  {
		try {
			StbEntity stbEntity = stbRepository.findById(id).get();
			return mapper.marchall(StbWithIdMapper.INSTANCE.toModel(stbEntity));
		} catch (NoSuchElementException e) {
			return mapper.marchall(new Response(id, Response.Type.ERROR));
		}	

	}

	public String findByIdHTML(int id) {
		try {
			StbEntity stbEntity = stbRepository.findById(id).get();
			return transformer.transformStbXSL(mapper.marchall(
					StbWithIdMapper.INSTANCE.toModel(stbEntity)));
		} catch (NoSuchElementException e) {
			try {
				return transformer.transformResponseXSL(mapper.marchall(new Response(id, Response.Type.ERROR)));
			} catch (TransformerException e1) {
				logger.error("Tranformation XSLT ", e1);
				return null;
			}
		} catch (TransformerException e) {
			logger.error("Tranformation XSLT ", e);
			return null;
		}	
		
	}

	public String insert(Stb stb) {
		if (stb != null)  {
			Response response = validator.validateStb(mapper.marchall(stb));
			if (response.getStatus() == Response.Type.OK) {
				if (stbRepository.findByTitleAndVersion(stb.getTitle(), stb.getVersion()) != null) {
					return mapper.marchall(new Response(Response.Type.ERROR, "Flux déjà existant !"));
				}
				StbEntity stbEntity = stbRepository.save(StbMapper.INSTANCE.toEntity(stb));
				return mapper.marchall(new Response(stbEntity.getId(), Response.Type.INSERTED));
			} else {
				return mapper.marchall(response);
			}
		} else {
			return mapper.marchall(new Response(Response.Type.ERROR));
		}
	}
	
	public String delete(int id) {
		try {
			StbEntity stbEntity = stbRepository.findById(id).get();
			stbRepository.delete(stbEntity);
			return mapper.marchall(new Response(id, Response.Type.DELETED));
		} catch (NoSuchElementException e) {
			return mapper.marchall(new Response(id, Response.Type.ERROR));
		}	
	}
}

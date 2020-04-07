package fr.univ.rouen.stb.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import fr.univ.rouen.stb.entities.StbEntity;
import fr.univ.rouen.stb.models.Detail;
import fr.univ.rouen.stb.models.Stb;
import fr.univ.rouen.stb.models.Team;

@Mapper
public abstract class StbMapper {
	public static final StbMapper INSTANCE = Mappers.getMapper(StbMapper.class);

	public Stb toModel(StbEntity stbEntity) {
		Stb stb = new Stb();
		stb.setTitle(stbEntity.getTitle());
		stb.setVersion(stbEntity.getVersion());
		stb.setDate(stbEntity.getDate());
		stb.setDescription(stbEntity.getDescription());
		stb.setClient(ClientMapper.INSTANCE.toModel(stbEntity.getClient()));
		stb.setDetail(new Detail(FeatureMapper.INSTANCE.toModels(stbEntity.getFeatures())));
		stb.setTeam(new Team(PersonMapper.INSTANCE.toModels(stbEntity.getPersons())));
		return stb;
	}

	public StbEntity toEntity(Stb stb) {
		StbEntity stbEntity = new StbEntity();
		stbEntity.setTitle(stb.getTitle());
		stbEntity.setVersion(stb.getVersion());
		stbEntity.setDate(stb.getDate());
		stbEntity.setDescription(stb.getDescription());
		stbEntity.setClient(ClientMapper.INSTANCE.toEntity(stb.getClient()));
		stbEntity.setFeatures(FeatureMapper.INSTANCE.toEntities(stb.getDetail().getFeatures()));
		stbEntity.setPersons(PersonMapper.INSTANCE.toEntities(stb.getTeam().getPersons()));
		stbEntity.getFeatures().forEach(f -> f.setStb(stbEntity));
		stbEntity.getPersons().forEach(p -> p.setStb(stbEntity));
		return stbEntity;
	}
	public abstract List<Stb> toModels(List<StbEntity> stbEntities);
	public abstract List<StbEntity> toEntities(List<Stb> stbs);
	
}

package fr.univ.rouen.stb.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import fr.univ.rouen.stb.entities.StbEntity;
import fr.univ.rouen.stb.models.Detail;
import fr.univ.rouen.stb.models.StbWithId;
import fr.univ.rouen.stb.models.Team;

@Mapper
public abstract class StbWithIdMapper {
	public static final StbWithIdMapper INSTANCE = Mappers.getMapper(StbWithIdMapper.class);

	public StbWithId toModel(StbEntity stbEntity) {
		StbWithId stb = new StbWithId();
		stb.setId(stbEntity.getId());
		stb.setTitle(stbEntity.getTitle());
		stb.setVersion(stbEntity.getVersion());
		stb.setDate(stbEntity.getDate());
		stb.setDescription(stbEntity.getDescription());
		stb.setClient(ClientMapper.INSTANCE.toModel(stbEntity.getClient()));
		stb.setDetail(new Detail(FeatureMapper.INSTANCE.toModels(stbEntity.getFeatures())));
		stb.setTeam(new Team(PersonMapper.INSTANCE.toModels(stbEntity.getPersons())));
		return stb;
	}

	public StbEntity toEntity(StbWithId stb) {
		StbEntity stbEntity = new StbEntity();
		stbEntity.setId(stb.getId());
		stbEntity.setTitle(stb.getTitle());
		stbEntity.setVersion(stb.getVersion());
		stbEntity.setDate(stb.getDate());
		stbEntity.setDescription(stb.getDescription());
		stbEntity.setClient(ClientMapper.INSTANCE.toEntity(stb.getClient()));
		stbEntity.setFeatures(FeatureMapper.INSTANCE.toEntities(stb.getDetail().getFeatures()));
		stbEntity.setPersons(PersonMapper.INSTANCE.toEntities(stb.getTeam().getPersons()));
		return stbEntity;
	}
	public abstract List<StbWithId> toModels(List<StbEntity> stbEntities);
	public abstract List<StbEntity> toEntities(List<StbWithId> stbs);
	
}

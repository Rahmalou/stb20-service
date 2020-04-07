package fr.univ.rouen.stb.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import fr.univ.rouen.stb.entities.FeatureEntity;
import fr.univ.rouen.stb.models.Feature;

@Mapper
public abstract class FeatureMapper {
	public static final  FeatureMapper INSTANCE = Mappers.getMapper(FeatureMapper.class);

	public abstract Feature toModel(FeatureEntity featureEntity);
	@Mappings({
		@Mapping(target="id", ignore=true),
		@Mapping(target="stb", ignore=true)
	})
	public abstract FeatureEntity toEntity(Feature feature);
	public abstract List<Feature> toModels(List<FeatureEntity> featureEntities);
	public abstract List<FeatureEntity> toEntities(List<Feature> features);
}

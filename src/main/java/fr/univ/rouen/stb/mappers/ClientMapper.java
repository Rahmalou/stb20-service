package fr.univ.rouen.stb.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import fr.univ.rouen.stb.entities.ClientEntity;
import fr.univ.rouen.stb.models.Client;

@Mapper
public abstract class ClientMapper {
	public static final  ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

	public abstract Client toModel(ClientEntity clientEntity);
	@Mapping(target="id", ignore=true)
	public abstract ClientEntity toEntity(Client client);
	public abstract List<Client> toModels(List<ClientEntity> clientEntities);
	public abstract List<ClientEntity> toEntities(List<Client> clients);
}

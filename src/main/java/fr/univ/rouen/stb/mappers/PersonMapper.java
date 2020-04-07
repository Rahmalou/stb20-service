package fr.univ.rouen.stb.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import fr.univ.rouen.stb.entities.PersonEntity;
import fr.univ.rouen.stb.models.Firstname;
import fr.univ.rouen.stb.models.Person;

@Mapper
public abstract class PersonMapper {
	public static final  PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

	public Person toModel(PersonEntity personEntity) {
		Person person = new Person();
		person.setFirstname(new Firstname(personEntity.getFirstname(), personEntity.getLastname(), personEntity.getGender(), personEntity.getMail()));
		person.setFunctions(personEntity.getFunctions());
		return person;
	}

	public PersonEntity toEntity(Person person) {
		PersonEntity personEntity = new PersonEntity();
		personEntity.setFirstname(person.getFirstname().getValue());
		personEntity.setLastname(person.getFirstname().getLastname());
		personEntity.setGender(person.getFirstname().getGender());
		personEntity.setMail(person.getFirstname().getMail());
		personEntity.setFunctions(person.getFunctions());
		return personEntity;
	}
	public abstract List<Person> toModels(List<PersonEntity> personEntities);
	public abstract List<PersonEntity> toEntities(List<Person> persons);
	
}

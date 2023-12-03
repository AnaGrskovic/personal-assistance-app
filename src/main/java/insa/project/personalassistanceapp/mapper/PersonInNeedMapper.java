package insa.project.personalassistanceapp.mapper;

import insa.project.personalassistanceapp.model.PersonInNeed;
import insa.project.personalassistanceapp.model.dto.PersonInNeedDto;
import insa.project.personalassistanceapp.model.dto.PersonInNeedForm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface PersonInNeedMapper {

    @Mapping(source = "userForm", target = "user")
    PersonInNeed mapFormToObject(PersonInNeedForm form);

    @Mapping(source = "user", target = "userDto")
    PersonInNeedDto mapObjectToDto(PersonInNeed personInNeed);
}

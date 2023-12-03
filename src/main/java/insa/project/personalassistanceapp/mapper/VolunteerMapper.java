package insa.project.personalassistanceapp.mapper;

import insa.project.personalassistanceapp.model.Volunteer;
import insa.project.personalassistanceapp.model.dto.VolunteerDto;
import insa.project.personalassistanceapp.model.dto.VolunteerForm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface VolunteerMapper {

    @Mapping(source = "userForm", target = "user")
    Volunteer mapFormToObject(VolunteerForm volunteerForm);

    @Mapping(source = "user", target = "userDto")
    VolunteerDto mapObjectToDto(Volunteer volunteer);
}

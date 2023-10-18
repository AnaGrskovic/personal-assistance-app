package insa.project.personalassistanceapp.mapper;

import insa.project.personalassistanceapp.model.Volunteer;
import insa.project.personalassistanceapp.model.dto.VolunteerDto;
import insa.project.personalassistanceapp.model.dto.VolunteerForm;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface VolunteerMapper {
    Volunteer mapFormToObject(VolunteerForm volunteerForm);

    VolunteerDto mapObjectToDto(Volunteer volunteer);
}

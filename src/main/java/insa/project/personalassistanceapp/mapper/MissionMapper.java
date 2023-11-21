package insa.project.personalassistanceapp.mapper;

import insa.project.personalassistanceapp.model.Mission;
import insa.project.personalassistanceapp.model.dto.MissionDto;
import insa.project.personalassistanceapp.model.dto.MissionForm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {PersonInNeedMapper.class, VolunteerMapper.class, MissionStatusMapper.class})
public interface MissionMapper {
    Mission mapFormToObject(MissionForm missionForm);

    @Mapping(source = "personInNeed", target = "personInNeedDto")
    @Mapping(source = "volunteer", target = "volunteerDto")
    @Mapping(source = "missionStatus", target = "missionStatusDto")
    MissionDto mapObjectToDto(Mission mission);
}

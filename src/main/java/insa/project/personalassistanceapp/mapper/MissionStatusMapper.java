package insa.project.personalassistanceapp.mapper;

import insa.project.personalassistanceapp.model.MissionStatus;
import insa.project.personalassistanceapp.model.dto.MissionStatusDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MissionStatusMapper {

    MissionStatusDto mapObjectToDto(MissionStatus missionStatus);
}

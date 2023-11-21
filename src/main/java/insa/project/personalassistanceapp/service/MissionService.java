package insa.project.personalassistanceapp.service;

import insa.project.personalassistanceapp.model.dto.MissionDto;
import insa.project.personalassistanceapp.model.dto.MissionForm;
import insa.project.personalassistanceapp.model.dto.MissionRequestDto;

import java.util.List;

public interface MissionService {
    MissionDto createMission(MissionForm missionForm);

    List<MissionDto> getAllMissions();

    List<MissionDto> getAllMissionsByMissionStatusName(MissionRequestDto missionRequestDto);
}

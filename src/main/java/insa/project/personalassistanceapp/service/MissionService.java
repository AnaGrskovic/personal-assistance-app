package insa.project.personalassistanceapp.service;

import insa.project.personalassistanceapp.model.dto.MissionDto;
import insa.project.personalassistanceapp.model.dto.MissionForm;

import java.util.List;

public interface MissionService {
    MissionDto createMission(MissionForm missionForm);

    List<MissionDto> getAllMissions();
}

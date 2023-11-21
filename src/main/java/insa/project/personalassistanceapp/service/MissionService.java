package insa.project.personalassistanceapp.service;

import insa.project.personalassistanceapp.model.dto.MissionDto;
import insa.project.personalassistanceapp.model.dto.MissionForm;

public interface MissionService {
    MissionDto createMission(MissionForm missionForm);
}

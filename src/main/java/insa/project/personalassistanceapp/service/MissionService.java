package insa.project.personalassistanceapp.service;

import insa.project.personalassistanceapp.model.dto.MissionDto;
import insa.project.personalassistanceapp.model.dto.MissionForm;

import java.io.InvalidObjectException;

public interface MissionService {
    MissionDto createMission(MissionForm missionForm) throws InvalidObjectException;
}

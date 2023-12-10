package insa.project.personalassistanceapp.service;

import insa.project.personalassistanceapp.model.dto.MissionDto;
import insa.project.personalassistanceapp.model.dto.MissionForm;
import insa.project.personalassistanceapp.model.dto.MissionRequestDto;
import insa.project.personalassistanceapp.model.dto.MissionStatusDto;

import java.util.List;

import java.io.InvalidObjectException;

public interface MissionService {

    MissionDto createMission(MissionForm missionForm) throws InvalidObjectException;

    List<MissionDto> getAllMissions();

    List<MissionDto> getAllMissionsByMissionStatusName(MissionRequestDto missionRequestDto);

}

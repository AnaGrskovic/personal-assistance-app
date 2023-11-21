package insa.project.personalassistanceapp.controller;

import insa.project.personalassistanceapp.model.dto.MissionDto;
import insa.project.personalassistanceapp.model.dto.MissionForm;
import insa.project.personalassistanceapp.service.MissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InvalidObjectException;

@RestController("/mission")
@RequiredArgsConstructor
public class MissionController {

    private final MissionService missionService;

    @PostMapping
    public MissionDto createMission(MissionForm missionForm) throws InvalidObjectException {
        return missionService.createMission(missionForm);
    }
}

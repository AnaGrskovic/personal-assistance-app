package insa.project.personalassistanceapp.controller;

import insa.project.personalassistanceapp.model.dto.MissionDto;
import insa.project.personalassistanceapp.model.dto.MissionForm;
import insa.project.personalassistanceapp.model.dto.MissionRequestDto;
import insa.project.personalassistanceapp.service.MissionService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import java.io.InvalidObjectException;

@Controller
@RequestMapping("/mission")
@RequiredArgsConstructor
public class MissionController {

    private final MissionService missionService;

    @GetMapping("/creation")
    public String showMissionCreationForm(Model model) {
        MissionForm missionForm = new MissionForm();
        model.addAttribute("missionForm", missionForm);
        return "mission-creation";
    }

    @PostMapping("/creation")
    public String processMissionCreationForm(@ModelAttribute("missionForm") MissionForm missionForm) {
        try {
            missionService.createMission(missionForm);
            return "successful-mission-creation";
        } catch (InvalidObjectException ex) {
            return "invalid-form";
        } catch (EntityNotFoundException ex) {
            return "invalid-username";
        } catch (Exception ex) {
            return "error";
        }
    }

    @GetMapping("/all")
    public List<MissionDto> getAllMissions(){
        return missionService.getAllMissions();
    }

    @PostMapping("/all-by-mission-status")
    public List<MissionDto> getAllMissionsByMissionStatusName(@RequestBody MissionRequestDto missionRequestDto){
        return missionService.getAllMissionsByMissionStatusName(missionRequestDto);
    }

}

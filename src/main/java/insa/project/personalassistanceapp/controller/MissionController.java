package insa.project.personalassistanceapp.controller;

import insa.project.personalassistanceapp.model.dto.MissionDto;
import insa.project.personalassistanceapp.model.dto.MissionForm;
import insa.project.personalassistanceapp.model.dto.MissionRequestDto;
import insa.project.personalassistanceapp.model.dto.MissionStatusDto;
import insa.project.personalassistanceapp.service.MissionService;
import insa.project.personalassistanceapp.service.MissionStatusService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.InvalidObjectException;

@Controller
@RequestMapping("/mission")
@RequiredArgsConstructor
public class MissionController {

    private final MissionService missionService;
    private final MissionStatusService missionStatusService;

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
        } catch (DuplicateKeyException ex) {
            return "mission-name-unique-error";
        } catch (InvalidObjectException ex) {
            return "invalid-form";
        } catch (EntityNotFoundException ex) {
            return "invalid-username";
        } catch (Exception ex) {
            return "error";
        }
    }

    @GetMapping("/all")
    public String getAllMissions(Model model) {
        try {
            List<MissionDto> missions = missionService.getAllMissions();
            model.addAttribute("missions", missions);
            return "get-all-missions";
        } catch (Exception ex) {
            return "error";
        }
    }

    @GetMapping("/all-by-mission-status")
    public List<MissionDto> showGetAllMissionByStatusForm(MissionRequestDto missionRequestDto) {
        return missionService.getAllMissionsByMissionStatusName(missionRequestDto);
    }

    /*@GetMapping("/all-by-mission-status")
    public String showGetAllMissionByStatusForm(Model model) {
        MissionRequestDto missionRequestDto = new MissionRequestDto();
        List<MissionStatusDto> missionStatuses = missionStatusService.getAllMissionStatusNames();
        model.addAttribute("missionRequestDto", missionRequestDto);
        model.addAttribute("missionStatuses", missionStatuses);
        return "mission-status-selection";
    }

    @PostMapping("/all-by-mission-status")
    public String processGetAllMissionByStatusForm(Model model, @ModelAttribute("missionRequestDto") MissionRequestDto missionRequestDto) {
        try {
            List<MissionDto> missions = missionService.getAllMissionsByMissionStatusName(missionRequestDto);
            model.addAttribute("missions", missions);
            return "get-all-missions";
        } catch (Exception ex) {
            return "error";
        }
    }*/

}

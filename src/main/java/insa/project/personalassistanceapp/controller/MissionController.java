package insa.project.personalassistanceapp.controller;

import insa.project.personalassistanceapp.model.dto.MissionForm;
import insa.project.personalassistanceapp.service.MissionService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    //TODO GETALL, GET
}

package insa.project.personalassistanceapp.controller;

import insa.project.personalassistanceapp.model.dto.*;
import insa.project.personalassistanceapp.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/person-in-need/registration")
    public String showPersonInNeedRegistrationForm(Model model) {
        PersonInNeedForm personInNeedForm = new PersonInNeedForm();
        model.addAttribute("personInNeedForm", personInNeedForm);
        return "person-in-need-registration";
    }

    @PostMapping("/person-in-need/registration")
    public String processPersonInNeedRegistrationForm(@ModelAttribute("personInNeedForm") PersonInNeedForm personInNeedForm) {
        try {
            userService.personInNeedRegistration(personInNeedForm);
            return "successful-registration";
        } catch (Exception ex) {
            return "error";
        }
    }

    @GetMapping("/volunteer/registration")
    public String showVolunteerRegistrationForm(Model model) {
        VolunteerForm volunteerForm = new VolunteerForm();
        model.addAttribute("volunteerForm", volunteerForm);
        return "volunteer-registration";
    }

    @PostMapping("/volunteer/registration")
    public String processVolunteerRegistrationForm(@ModelAttribute("volunteerForm") VolunteerForm volunteerForm) {
        try {
            userService.volunteerRegistration(volunteerForm);
            return "successful-registration";
        } catch (Exception ex) {
            return "error";
        }
    }

    @GetMapping("/professional-in-charge/registration")
    public String showProfessionalInChargeRegistrationForm(Model model) {
        ProfessionalInChargeForm professionalInChargeForm = new ProfessionalInChargeForm();
        model.addAttribute("professionalInChargeForm", professionalInChargeForm);
        return "professional-in-charge-registration";
    }

    @PostMapping("/professional-in-charge/registration")
    public String processProfessionalInChargeRegistrationForm(@ModelAttribute("professionalInChargeForm") ProfessionalInChargeForm professionalInChargeForm) {
        try {
            userService.professionalInChargeRegistration(professionalInChargeForm);
            return "successful-registration";
        } catch (Exception ex) {
            return "error";
        }
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        UserForm userForm = new UserForm();
        model.addAttribute("userForm", userForm);
        return "login";
    }

    @PostMapping("/login")
    public String processLoginForm(@ModelAttribute("userForm") UserForm userForm) {
        try {
            userService.userLogin(userForm);
            return "successful-login";
        } catch (EntityNotFoundException ex) {
            return "invalid-credentials";
        } catch (Exception ex) {
            return "error";
        }
    }

}

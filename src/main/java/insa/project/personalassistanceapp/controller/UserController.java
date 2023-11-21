package insa.project.personalassistanceapp.controller;

import insa.project.personalassistanceapp.model.dto.*;
import insa.project.personalassistanceapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;

@RestController("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /*@PostMapping("/person-in-need/registration")
    public PersonInNeedDto personInNeedRegistration (PersonInNeedForm personInNeedForm){
        return userService.personInNeedRegistration(personInNeedForm);
    }

    @PostMapping("/volunteer/registration")
    public VolunteerDto personInNeedRegistration (VolunteerForm volunteerForm){
        return userService.volunteerRegistration(volunteerForm);
    }

    @PostMapping("/professional-in-charge/registration")
    public ProfessionalInChargeDto professionalInChargeRegistration (ProfessionalInChargeForm professionalInChargeForm){
        return userService.professionalInChargeRegistration(professionalInChargeForm);
    }*/

    @GetMapping("/person-in-need/registration")
    public String showPersonInNeedRegistrationForm(Model model) {
        PersonInNeedForm personInNeedForm = new PersonInNeedForm();
        model.addAttribute("personInNeedForm", personInNeedForm);
        return "person-in-need-registration";
    }

    @PostMapping("person-in-need/registration")
    public String processPersonInNeedRegistrationForm(@ModelAttribute("personInNeedForm") PersonInNeedForm personInNeedForm) {
        userService.personInNeedRegistration(personInNeedForm);
        return "successfully-registered";
    }

    @GetMapping("/volunteer/registration")
    public String showVolunteerRegistrationForm(Model model) {
        VolunteerForm volunteerForm = new VolunteerForm();
        model.addAttribute("volunteerForm", volunteerForm);
        return "volunteer-registration";
    }

    @PostMapping("volunteer/registration")
    public String processVolunteerRegistrationForm(@ModelAttribute("volunteerForm") VolunteerForm volunteerForm) {
        userService.volunteerRegistration(volunteerForm);
        return "successfully-registered";
    }

    @GetMapping("/professional-in-charge/registration")
    public String showProfessionalInChargeRegistrationForm(Model model) {
        ProfessionalInChargeForm professionalInChargeForm = new ProfessionalInChargeForm();
        model.addAttribute("professionalInChargeForm", professionalInChargeForm);
        return "professional-in-charge-registration";
    }

    @PostMapping("professional-in-charge/registration")
    public String processProfessionalInChargeRegistrationForm(@ModelAttribute("professionalInChargeForm") ProfessionalInChargeForm professionalInChargeForm) {
        userService.professionalInChargeRegistration(professionalInChargeForm);
        return "successfully-registered";
    }

    @PostMapping("/login")
    public UserDto userLogin (UserForm userForm){
        return userService.userLogin(userForm);
    }

}

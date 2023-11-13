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
    }*/

    @GetMapping("/person-in-need/registration/show")
    public String showPersonInNeedRegistrationForm(Model model) {
        PersonInNeedForm personInNeedForm = new PersonInNeedForm();
        model.addAttribute("personInNeedForm", personInNeedForm);
        return "person-in-need-registration";
    }

    @PostMapping("person-in-need/registration/show")
    public String processPersonInNeedRegistrationForm(@ModelAttribute("personInNeedForm") PersonInNeedForm personInNeedForm) {
        userService.personInNeedRegistration(personInNeedForm);
        // Redirect to a success page or home page
        return "successfully-registered";
    }

    @PostMapping("/volunteer/registration")
    public VolunteerDto personInNeedRegistration (VolunteerForm volunteerForm){
        return userService.volunteerRegistration(volunteerForm);
    }

    @PostMapping("/professional-in-charge/registration")
    public ProfessionalInChargeDto professionalInChargeRegistration (ProfessionalInChargeForm professionalInChargeForm){
        return userService.professionalInChargeRegistration(professionalInChargeForm);
    }

    @PostMapping("/login")
    public UserDto userLogin (UserForm userForm){
        return userService.userLogin(userForm);
    }

}

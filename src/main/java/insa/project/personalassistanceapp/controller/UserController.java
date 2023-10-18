package insa.project.personalassistanceapp.controller;

import insa.project.personalassistanceapp.model.dto.*;
import insa.project.personalassistanceapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/person-in-need/registration")
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
    }

    @PostMapping("/login")
    public UserDto userLogin (UserForm userForm){
        return userService.userLogin(userForm);
    }

}

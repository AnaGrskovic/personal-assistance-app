package insa.project.personalassistanceapp.service;

import insa.project.personalassistanceapp.model.dto.*;

public interface UserService {
    PersonInNeedDto personInNeedRegistration(PersonInNeedForm personInNeedForm);

    VolunteerDto volunteerRegistration(VolunteerForm volunteerForm);

    ProfessionalInChargeDto professionalInChargeRegistration(ProfessionalInChargeForm professionalInChargeForm);

    UserDto userLogin(UserForm userForm);
}

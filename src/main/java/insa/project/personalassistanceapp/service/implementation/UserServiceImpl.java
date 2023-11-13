package insa.project.personalassistanceapp.service.implementation;

import insa.project.personalassistanceapp.mapper.PersonInNeedMapper;
import insa.project.personalassistanceapp.mapper.ProfessionalInChargeMapper;
import insa.project.personalassistanceapp.mapper.UserMapper;
import insa.project.personalassistanceapp.mapper.VolunteerMapper;
import insa.project.personalassistanceapp.model.PersonInNeed;
import insa.project.personalassistanceapp.model.ProfessionalInCharge;
import insa.project.personalassistanceapp.model.User;
import insa.project.personalassistanceapp.model.Volunteer;
import insa.project.personalassistanceapp.model.dto.*;
import insa.project.personalassistanceapp.repository.PersonInNeedRepository;
import insa.project.personalassistanceapp.repository.ProfessionalInChargeRepository;
import insa.project.personalassistanceapp.repository.UserRepository;
import insa.project.personalassistanceapp.repository.VolunteerRepository;
import insa.project.personalassistanceapp.service.UserService;
import insa.project.personalassistanceapp.util.Role;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final PersonInNeedMapper personInNeedMapper;
    private final VolunteerMapper volunteerMapper;
    private final ProfessionalInChargeMapper professionalInChargeMapper;

    private final UserRepository userRepository;
    private final PersonInNeedRepository personInNeedRepository;
    private final VolunteerRepository volunteerRepository;
    private final ProfessionalInChargeRepository professionalInChargeRepository;

    @Override
    public PersonInNeedDto personInNeedRegistration(PersonInNeedForm personInNeedForm) {
        PersonInNeed personInNeed = personInNeedMapper.mapFormToObject(personInNeedForm);
        personInNeed.getUser().setRole(Role.PERSON_IN_NEED);

        personInNeed.setUser(userRepository.save(personInNeed.getUser()));
        personInNeed = personInNeedRepository.save(personInNeed);

        return personInNeedMapper.mapObjectToDto(personInNeed);
    }

    @Override
    public VolunteerDto volunteerRegistration(VolunteerForm volunteerForm) {
        Volunteer volunteer = volunteerMapper.mapFormToObject(volunteerForm);
        volunteer.getUser().setRole(Role.VOLUNTEER);

        volunteer.setUser(userRepository.save(volunteer.getUser()));
        volunteer = volunteerRepository.save(volunteer);

        return volunteerMapper.mapObjectToDto(volunteer);
    }

    @Override
    public ProfessionalInChargeDto professionalInChargeRegistration(ProfessionalInChargeForm professionalInChargeForm) {
        ProfessionalInCharge professionalInCharge = professionalInChargeMapper.mapFormToObject(professionalInChargeForm);
        professionalInCharge.getUser().setRole(Role.PROFESSIONAL);

        professionalInCharge.setUser(userRepository.save(professionalInCharge.getUser()));
        professionalInCharge = professionalInChargeRepository.save(professionalInCharge);

        return professionalInChargeMapper.mapObjectToDto(professionalInCharge);
    }

    @Override
    public UserDto userLogin(UserForm userForm) {
        User user = userRepository.findByUsernameAndPassword(userForm.getUsername(), userForm.getPassword())
                .orElseThrow(() -> new EntityNotFoundException("Invalid login info."));
        return userMapper.mapObjectToDto(user);
    }


}

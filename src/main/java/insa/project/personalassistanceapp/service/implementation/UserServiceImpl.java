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
import insa.project.personalassistanceapp.repository.*;
import insa.project.personalassistanceapp.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    //TODO: Should we specify @Autowired ?
    private final UserMapper userMapper;
    private final PersonInNeedMapper personInNeedMapper;
    private final VolunteerMapper volunteerMapper;
    private final ProfessionalInChargeMapper professionalInChargeMapper;

    private final UserRepository userRepository;
    private final PersonInNeedRepository personInNeedRepository;
    private final VolunteerRepository volunteerRepository;
    private final ProfessionalInChargeRepository professionalInChargeRepository;
    private final RoleRepository roleRepository;

    @Override
    public PersonInNeedDto personInNeedRegistration(PersonInNeedForm personInNeedForm) {
        List<User> users = userRepository.findAll();
        List<String> usernames = users.stream().map(User::getUsername).toList();
        if (usernames.contains(personInNeedForm.getUserForm().getUsername())) {
            throw new DuplicateKeyException("User with that username already exists.");
        }

        PersonInNeed personInNeed = personInNeedMapper.mapFormToObject(personInNeedForm);
        personInNeed.getUser().setRole(roleRepository.getReferenceById(1L));
        personInNeed.setUser(userRepository.save(personInNeed.getUser()));

        personInNeed = personInNeedRepository.save(personInNeed);

        return personInNeedMapper.mapObjectToDto(personInNeed);
    }

    @Override
    public VolunteerDto volunteerRegistration(VolunteerForm volunteerForm) {
        List<User> users = userRepository.findAll();
        List<String> usernames = users.stream().map(User::getUsername).toList();
        if (usernames.contains(volunteerForm.getUserForm().getUsername())) {
            throw new DuplicateKeyException("User with that username already exists.");
        }

        Volunteer volunteer = volunteerMapper.mapFormToObject(volunteerForm);
        volunteer.getUser().setRole(roleRepository.getReferenceById(2L));
        volunteer.setUser(userRepository.save(volunteer.getUser()));

        volunteer = volunteerRepository.save(volunteer);

        return volunteerMapper.mapObjectToDto(volunteer);
    }

    @Override
    public ProfessionalInChargeDto professionalInChargeRegistration(ProfessionalInChargeForm professionalInChargeForm) {
        List<User> users = userRepository.findAll();
        List<String> usernames = users.stream().map(User::getUsername).toList();
        if (usernames.contains(professionalInChargeForm.getUserForm().getUsername())) {
            throw new DuplicateKeyException("User with that username already exists.");
        }

        ProfessionalInCharge professionalInCharge = professionalInChargeMapper.mapFormToObject(professionalInChargeForm);
        professionalInCharge.getUser().setRole(roleRepository.getReferenceById(3L));
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

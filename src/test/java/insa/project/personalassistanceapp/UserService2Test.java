package insa.project.personalassistanceapp;

import insa.project.personalassistanceapp.mapper.PersonInNeedMapper;
import insa.project.personalassistanceapp.mapper.ProfessionalInChargeMapper;
import insa.project.personalassistanceapp.mapper.UserMapper;
import insa.project.personalassistanceapp.mapper.VolunteerMapper;
import insa.project.personalassistanceapp.model.PersonInNeed;
import insa.project.personalassistanceapp.model.Role;
import insa.project.personalassistanceapp.model.User;
import insa.project.personalassistanceapp.model.dto.PersonInNeedDto;
import insa.project.personalassistanceapp.model.dto.PersonInNeedForm;
import insa.project.personalassistanceapp.repository.*;
import insa.project.personalassistanceapp.service.implementation.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserService2Test {

    @Mock
    private UserMapper userMapper;
    @Mock
    private PersonInNeedMapper personInNeedMapper;
    @Mock
    private VolunteerMapper volunteerMapper;
    @Mock
    private ProfessionalInChargeMapper professionalInChargeMapper;
    @Mock
    private UserRepository userRepository;
    @Mock
    private PersonInNeedRepository personInNeedRepository;
    @Mock
    private VolunteerRepository volunteerRepository;
    @Mock
    private ProfessionalInChargeRepository professionalInChargeRepository;
    @Mock
    private RoleRepository roleRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void testPersonInNeedRegistration() {
        // Arrange
        PersonInNeedForm personInNeedForm = new PersonInNeedForm();
        PersonInNeed personInNeed = new PersonInNeed();
        personInNeed.setUser(new User());
        PersonInNeedDto expected = new PersonInNeedDto();

        when(personInNeedMapper.mapFormToObject(personInNeedForm)).thenReturn(personInNeed);
        when(roleRepository.getReferenceById(1L)).thenReturn(new Role());
        when(userRepository.save(any(User.class))).thenReturn(new User());
        when(personInNeedRepository.save(any(PersonInNeed.class))).thenReturn(personInNeed);
        when(personInNeedMapper.mapObjectToDto(personInNeed)).thenReturn(expected);

        // Act
        PersonInNeedDto actual = userService.personInNeedRegistration(personInNeedForm);

        // Assert
        assertEquals(expected, actual);
    }

}

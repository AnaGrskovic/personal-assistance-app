import insa.project.personalassistanceapp.mapper.VolunteerMapper;
import insa.project.personalassistanceapp.mapper.PersonInNeedMapper;
import insa.project.personalassistanceapp.mapper.ProfessionalInChargeMapper;
import insa.project.personalassistanceapp.mapper.UserMapper;
import insa.project.personalassistanceapp.model.PersonInNeed;
import insa.project.personalassistanceapp.model.ProfessionalInCharge;
import insa.project.personalassistanceapp.model.Role;
import insa.project.personalassistanceapp.model.User;
import insa.project.personalassistanceapp.model.Volunteer;
import insa.project.personalassistanceapp.model.dto.*;
import insa.project.personalassistanceapp.repository.*;
import insa.project.personalassistanceapp.service.implementation.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

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

    @Test
    public void testVolunteerRegistration() {
        // Arrange
        VolunteerForm volunteerForm = new VolunteerForm();
        Volunteer volunteer = new Volunteer();
        volunteer.setUser(new User());
        VolunteerDto expected = new VolunteerDto();

        when(volunteerMapper.mapFormToObject(volunteerForm)).thenReturn(volunteer);
        when(roleRepository.getReferenceById(2L)).thenReturn(new Role());
        when(userRepository.save(any(User.class))).thenReturn(new User());
        when(volunteerRepository.save(any(Volunteer.class))).thenReturn(volunteer);
        when(volunteerMapper.mapObjectToDto(volunteer)).thenReturn(expected);

        // Act
        VolunteerDto actual = userService.volunteerRegistration(volunteerForm);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testProfessionalInChargeRegistration() {
        // Arrange
        ProfessionalInChargeForm professionalInChargeForm = new ProfessionalInChargeForm();
        ProfessionalInCharge professionalInCharge = new ProfessionalInCharge();
        professionalInCharge.setUser(new User());
        ProfessionalInChargeDto expected = new ProfessionalInChargeDto();

        when(professionalInChargeMapper.mapFormToObject(professionalInChargeForm)).thenReturn(professionalInCharge);
        when(roleRepository.getReferenceById(3L)).thenReturn(new Role());
        when(userRepository.save(any(User.class))).thenReturn(new User());
        when(professionalInChargeRepository.save(any(ProfessionalInCharge.class))).thenReturn(professionalInCharge);
        when(professionalInChargeMapper.mapObjectToDto(professionalInCharge)).thenReturn(expected);

        // Act
        ProfessionalInChargeDto actual = userService.professionalInChargeRegistration(professionalInChargeForm);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testUserLogin(){
        UserForm userForm = new UserForm();
        User user = new User();
        UserDto expected = new UserDto();

        when(userRepository.findByUsernameAndPassword(userForm.getUsername(), userForm.getPassword())).thenReturn(Optional.of(user));
        when(userMapper.mapObjectToDto(user)).thenReturn(expected);

        UserDto actual = userService.userLogin(userForm);
        assertEquals(expected, actual);
    }

    //TODO: Test with two user with the same name
    //TODO: Mock the new function ()

}
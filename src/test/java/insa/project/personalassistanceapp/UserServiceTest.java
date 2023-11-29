package insa.project.personalassistanceapp;
package insa.project.personalassistanceapp;
import insa.project.personalassistanceapp.controller.UserController;
import insa.project.personalassistanceapp.mapper.*;
import insa.project.personalassistanceapp.model.PersonInNeed;
import insa.project.personalassistanceapp.model.Role;
import insa.project.personalassistanceapp.model.dto.PersonInNeedDto;
import insa.project.personalassistanceapp.repository.*;
import insa.project.personalassistanceapp.model.User;
import insa.project.personalassistanceapp.service.UserService;
import insa.project.personalassistanceapp.service.implementation.UserServiceImpl;
import insa.project.personalassistanceapp.model.dto.*;
import insa.project.personalassistanceapp.model.dto.PersonInNeedForm;

import java.util.Date;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = UserServiceImpl.class)
@AutoConfigureMockMvc
//@WebMvcTest(UserController.class)
public class UserServiceTest {


    @MockBean
    private final UserMapper userMapper;
    @MockBean
    private final PersonInNeedMapper personInNeedMapper;
    @MockBean
    private final VolunteerMapper volunteerMapper;
    @MockBean
    private final ProfessionalInChargeMapper professionalInChargeMapper;
    @MockBean
    private final UserRepository userRepository;
    @MockBean
    private final PersonInNeedRepository personInNeedRepository;
    @MockBean
    private final VolunteerRepository volunteerRepository;
    @MockBean
    private final ProfessionalInChargeRepository professionalInChargeRepository;
    @MockBean
    private final RoleRepository roleRepository;

    @MockBean
    private final MissionMapper missionMapper;

    /*
    @TestConfiguration
    static class UserServiceImplTestContextConfiguration {
        @Bean
        public UserService employeeService(userMapper,personInNeedMapper,) {
            return new UserServiceImpl();
        }
    }
*/
    @Autowired
    private UserService userService;

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        try {
            Date date = formatter.parse("2002-11-22");
        }catch (ParseException e){}

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        Date date;

        User user = new User();
        user.setUserId((long) 0);
        Role role = new Role();
            role.setRoleId((long) 1);
            role.setRoleName("PersonInNeed");
        user.setRole(role);
        user.setUsername("NeedyJacky");
        user.setPassword("NeedyJackyPassword");
        //(long) 0, "PersonInNeed","NeedyJacky", "NeedyJackyPassword")

        UserForm userForm = new UserForm("User", "UserPassword");
        PersonInNeedForm personInNeedForm = new PersonInNeedForm(new UserForm("NeedyJacky","NeedyJackyPassword"), "Jacky", "Needy", date, "NeedyStreet", "NeedyTown", "0000", "NeedyLand");

        //PersonInNeedForm personInNeedForm2 = new PersonInNeedForm(new UserForm("DeplhHelps","DelphHelpsPassword"), "Delph", "Helps", date, "HelpingStreet", "HelpingTown", "9999", "HelpingLand");

        VolunteerForm volunteerForm = new VolunteerForm(new UserForm("Volunteer", "VolunteerPassword"));
        ProfessionalInChargeForm professionalInChargeForm = new ProfessionalInChargeForm(new UserForm("Professional", "ProfessionalPassword"));

        PersonInNeedDto personInNeedDto = new PersonInNeedDto(new UserDto((long) 0, "PersonInNeed","NeedyJacky", "NeedyJackyPassword"), (long) 1, "Jacky", "Needy", date , "NeedyStreet", "NeedyTown", "0000", "NeedyLand");
        VolunteerDto volunteerDto = new VolunteerDto();
        ProfessionalInChargeDto professionalInChargeDto = new ProfessionalInChargeDto();

        PersonInNeed personInNeed = new PersonInNeed();
        personInNeed.setPersonInNeedId((long) 0);
        personInNeed.setUser(user);
        personInNeed.setFirstName("Jacky");
        personInNeed.setLastName("Needy");
        personInNeed.setDateOfBirth(date);
        personInNeed.setAddress("NeedyStreet");
        personInNeed.setCity("NeedyTown");
        personInNeed.setPostalCode("0000");
        personInNeed.setCountry("NeedyLand");

        //(long) 0, new User(), "Jacky", "Needy", date , "NeedyStreet", "NeedyTown", "0000", "NeedyLand");

        Mockito.when(personInNeedMapper.mapFormToObject(personInNeedForm))
                .thenReturn(personInNeed);
        Mockito.when(personInNeedMapper.mapFormToObject(personInNeedForm))
                .thenReturn(personInNeed);

    }

    //TODO: Initiallize the manipulated objects

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    private Date date;

    private User user;
    private UserForm userForm = new UserForm("User", "UserPassword");
    private PersonInNeedForm ApersonInNeedForm = new PersonInNeedForm(new UserForm("NeedyJacky","NeedyJackyPassword"), "Jacky", "Needy", date, "NeedyStreet", "NeedyTown", "0000", "NeedyLand");
    private PersonInNeedForm personInNeedForm2 = new PersonInNeedForm(new UserForm("DeplhHelps","DelphHelpsPassword"), "Delph", "Helps", date, "HelpingStreet", "HelpingTown", "9999", "HelpingLand");
    private VolunteerForm volunteerForm = new VolunteerForm(new UserForm("Volunteer", "VolunteerPassword"));
    private ProfessionalInChargeForm professionalInChargeForm = new ProfessionalInChargeForm(new UserForm("Professional", "ProfessionalPassword"));

    @BeforeEach
    public void setup(){
        try {
            Date date = formatter.parse("2002-11-22");
        }catch (ParseException e){}
        //MockitoAnnotations.initMocks(this);
        //this.mockMvc = MockMvcBuilders.standaloneSetup().build();

        //userRepository = Mockito.mock(UserRepository.class);
        //userService = new UserServiceImpl() //a bunch of stuff
    }

    //Create a form for each type of user
    //Create a user corresponding to that, for comparison



    @DisplayName("JUnit test for processPersonInNeedRegistrationForm method")
    @Test
    public void givenPersonInNeedFrom_whenPersonInNeedRegistration_thenReturnPersonInNeedDto(PersonInNeedForm personInNeedForm){
        PersonInNeedDto personInNeedDto = new PersonInNeedDto(new UserDto((long) 0, "PersonInNeed","NeedyJacky", "NeedyJackyPassword"), (long) 1, "Jacky", "Needy", date , "NeedyStreet", "NeedyTown", "0000", "NeedyLand");
        assertEquals(userService.personInNeedRegistration(personInNeedForm), personInNeedDto);
    }

    /*
    @DisplayName("JUnit test for processVolunteerRegistrationForm method")
    @Test
    public void givenVolunteerFrom_whenVolunteerRegistration_thenReturnVolunteerDto(){

    }

    @DisplayName("JUnit test for processProfessionalInChargeRegistrationForm method")
    @Test
    public void givenProfessionalInChargeFrom_whenProfessionalInChargeRegistration_thenReturnProfessionalInChargeDto(){

    }

    @DisplayName("JUnit test for processLoginForm method")
    @Test
    public void givenUserForm_whenUserLogin_thenReturnUserDto(){

    }
    */
}

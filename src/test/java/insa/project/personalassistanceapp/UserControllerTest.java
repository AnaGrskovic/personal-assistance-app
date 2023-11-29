//package insa.project.personalassistanceapp;
//import insa.project.personalassistanceapp.controller.UserController;
//import insa.project.personalassistanceapp.model.dto.PersonInNeedDto;
//import insa.project.personalassistanceapp.repository.UserRepository;
//import insa.project.personalassistanceapp.model.User;
//import insa.project.personalassistanceapp.service.UserService;
//import insa.project.personalassistanceapp.service.implementation.UserServiceImpl;
//import insa.project.personalassistanceapp.mapper.PersonInNeedMapper;
//import insa.project.personalassistanceapp.model.dto.*;
//import insa.project.personalassistanceapp.model.dto.PersonInNeedForm;
//
//import java.util.Date;
//import static org.assertj.core.api.Assertions.assertThat;
//
//import org.junit.Before;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.runner.RunWith;
//
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.BDDMockito.given;
//import static org.mockito.BDDMockito.willDoNothing;
//import static org.mockito.Mockito.*;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.web.bind.annotation.ModelAttribute;
//
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//
//
////@RunWith(MockitoJUnitRunner.class)
////@AutoConfigureMockMvc
//@WebMvcTest(UserController.class)
//public final class UserControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private UserService userService;
//
//    //TODO: Initiallize the objects
//
//
//
//    @BeforeEach
//    public void setup(){
//        try {
//            Date date = formatter.parse("2002-11-22");
//        }catch (ParseException e){}
//
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//        private Date date;
//        private User user;
//        private UserForm userForm = new UserForm("User", "UserPassword");
//        private PersonInNeedForm ApersonInNeedForm = new PersonInNeedForm(new UserForm("NeedyJacky","NeedyJackyPassword"), "Jacky", "Needy", date, "NeedyStreet", "NeedyTown", "0000", "NeedyLand");
//        private PersonInNeedForm personInNeedForm2 = new PersonInNeedForm(new UserForm("DeplhHelps","DelphHelpsPassword"), "Delph", "Helps", date, "HelpingStreet", "HelpingTown", "9999", "HelpingLand");
//        private VolunteerForm volunteerForm = new VolunteerForm(new UserForm("Volunteer", "VolunteerPassword"));
//        private ProfessionalInChargeForm professionalInChargeForm = new ProfessionalInChargeForm(new UserForm("Professional", "ProfessionalPassword"));
//
//        //MockitoAnnotations.initMocks(this);
//        //this.mockMvc = MockMvcBuilders.standaloneSetup().build();
//
//        //userRepository = Mockito.mock(UserRepository.class);
//        //userService = new UserServiceImpl() //a bunch of stuff
//
//            Mockito.when(userService.personInNeedRegistration(alex.getName()))
//                    .thenReturn(alex);
//        }
//    }
//
//    //Create a form for each type of user
//    //Create a user corresponding to that, for comparison
//
//
//
//    @DisplayName("JUnit test for processPersonInNeedRegistrationForm method")
//    @Test
//    public void givenPersonInNeedFrom_whenPersonInNeedRegistration_thenReturnPersonInNeedDto(PersonInNeedForm personInNeedForm){
//        PersonInNeedDto personInNeedDto = new PersonInNeedDto(new UserDto((long) 0, "PersonInNeed","NeedyJacky", "NeedyJackyPassword"), (long) 1, "Jacky", "Needy", date , "NeedyStreet", "NeedyTown", "0000", "NeedyLand");
//        assertEquals(userService.personInNeedRegistration(personInNeedForm), personInNeedDto);
//    }
//
//    /*
//    @DisplayName("JUnit test for processVolunteerRegistrationForm method")
//    @Test
//    public void givenVolunteerFrom_whenVolunteerRegistration_thenReturnVolunteerDto(){
//
//    }
//
//    @DisplayName("JUnit test for processProfessionalInChargeRegistrationForm method")
//    @Test
//    public void givenProfessionalInChargeFrom_whenProfessionalInChargeRegistration_thenReturnProfessionalInChargeDto(){
//
//    }
//
//    @DisplayName("JUnit test for processLoginForm method")
//    @Test
//    public void givenUserForm_whenUserLogin_thenReturnUserDto(){
//
//    }
//    */
//}

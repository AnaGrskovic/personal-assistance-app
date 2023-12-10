package insa.project.personalassistanceapp;

import insa.project.personalassistanceapp.mapper.*;

import insa.project.personalassistanceapp.model.*;
import insa.project.personalassistanceapp.model.dto.*;

import insa.project.personalassistanceapp.repository.*;
import insa.project.personalassistanceapp.service.implementation.MissionServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DuplicateKeyException;

import java.io.InvalidObjectException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MissionServiceTest {

    @Mock
    private MissionMapper missionMapper;
    @Mock
    private MissionRepository missionRepository;
    @Mock
    private PersonInNeedRepository personInNeedRepository;
    @Mock
    private VolunteerRepository volunteerRepository;
    @Mock
    private MissionStatusRepository missionStatusRepository;

    @InjectMocks
    private MissionServiceImpl missionService;

    @Test
    public void testcreateMissionValidPersonInNeed() throws InvalidObjectException {
        // Arrange
        MissionForm missionForm = new MissionForm();
        missionForm.setPersonInNeedUsername("NeedyJacky");

        PersonInNeed personInNeed = new PersonInNeed();

        Mission mission = new Mission();
        mission.setPersonInNeed(personInNeed);

        MissionDto missionDto = new MissionDto();
        missionDto.setPersonInNeedDto(new PersonInNeedDto());

        MissionDto expected = new MissionDto();
        expected.setPersonInNeedDto(new PersonInNeedDto());

        when(missionMapper.mapFormToObject(missionForm)).thenReturn(mission);
        when(personInNeedRepository.findByUsername(missionForm.getPersonInNeedUsername())).thenReturn(Optional.of(personInNeed));
        when(missionStatusRepository.getReferenceById(2L)).thenReturn(new MissionStatus());

        when(missionRepository.save(mission)).thenReturn(mission);
        when(missionMapper.mapObjectToDto(mission)).thenReturn(missionDto);

        // Act
        MissionDto actual = missionService.createMission(missionForm);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testcreateMissionValidVolunteer() throws InvalidObjectException {
        // Arrange
        MissionForm missionForm = new MissionForm();
        missionForm.setVolunteerUsername("NiceBrice");

        Volunteer volunteer = new Volunteer();

        Mission mission = new Mission();
        mission.setVolunteer(volunteer);

        MissionDto missionDto = new MissionDto();
        missionDto.setVolunteerDto(new VolunteerDto());

        MissionDto expected = new MissionDto();
        expected.setVolunteerDto(new VolunteerDto());

        when(missionMapper.mapFormToObject(missionForm)).thenReturn(mission);
        when(volunteerRepository.findByUsername(missionForm.getVolunteerUsername())).thenReturn(Optional.of(volunteer));
        when(missionStatusRepository.getReferenceById(1L)).thenReturn(new MissionStatus());

        when(missionRepository.save(mission)).thenReturn(mission);
        when(missionMapper.mapObjectToDto(mission)).thenReturn(missionDto);

        // Act
        MissionDto actual = missionService.createMission(missionForm);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testcreateMissionInvalid() throws InvalidObjectException {
        // Arrange
        MissionForm missionForm = new MissionForm();
        missionForm.setPersonInNeedUsername("NeedyJacky");
        missionForm.setVolunteerUsername("NiceBrice");

        PersonInNeed personInNeed = new PersonInNeed();
        Volunteer volunteer = new Volunteer();

        Mission mission = new Mission();
        mission.setPersonInNeed(personInNeed);
        mission.setVolunteer(volunteer);

        MissionDto missionDto = new MissionDto();
        missionDto.setPersonInNeedDto(new PersonInNeedDto());

        MissionDto expected = new MissionDto();
        expected.setPersonInNeedDto(new PersonInNeedDto());
        expected.setVolunteerDto(new VolunteerDto());

        // Assert
        assertThrows(InvalidObjectException.class, () -> missionService.createMission(missionForm));
    }

    @Test
    public void testGetAllMissions() {

        MissionDto missionDto1 = new MissionDto();
        Mission mission = new Mission();

        List<Mission> missionList = new ArrayList<Mission>();
        missionList.add(mission);

        List<MissionDto> expected = new ArrayList<MissionDto>();
        expected.add(missionDto1);

        when(missionRepository.findAll()).thenReturn(missionList);
        when(missionMapper.mapObjectToDto(mission)).thenReturn(missionDto1);

        List<MissionDto> actual = missionService.getAllMissions();
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testGetAllMissionsByMissionStatusName() {

        MissionRequestDto missionRequestDto = new MissionRequestDto();
        missionRequestDto.setMissionStatusName("REQUESTED WAITING FOR APPROVAL");

        MissionDto missionDto1 = new MissionDto();
        Mission mission = new Mission();

        List<Mission> missionList = new ArrayList<Mission>();
        missionList.add(mission);

        List<MissionDto> expected = new ArrayList<MissionDto>();
        expected.add(missionDto1);

        when(missionRepository.findAllByMissionStatusName(missionRequestDto.getMissionStatusName())).thenReturn((missionList));
        when(missionMapper.mapObjectToDto(mission)).thenReturn(missionDto1);

        List<MissionDto> actual = missionService.getAllMissionsByMissionStatusName(missionRequestDto);

        // Assert
        assertEquals(expected, actual);
    }
}
package insa.project.personalassistanceapp.service.implementation;

import insa.project.personalassistanceapp.mapper.MissionMapper;
import insa.project.personalassistanceapp.model.Mission;
import insa.project.personalassistanceapp.model.PersonInNeed;
import insa.project.personalassistanceapp.model.User;
import insa.project.personalassistanceapp.model.Volunteer;
import insa.project.personalassistanceapp.model.dto.MissionDto;
import insa.project.personalassistanceapp.model.dto.MissionForm;
import insa.project.personalassistanceapp.model.dto.MissionRequestDto;
import insa.project.personalassistanceapp.repository.MissionRepository;
import insa.project.personalassistanceapp.repository.MissionStatusRepository;
import insa.project.personalassistanceapp.repository.PersonInNeedRepository;
import insa.project.personalassistanceapp.repository.VolunteerRepository;
import insa.project.personalassistanceapp.service.MissionService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import java.io.InvalidObjectException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MissionServiceImpl implements MissionService {

    private final MissionRepository missionRepository;
    private final PersonInNeedRepository personInNeedRepository;
    private final VolunteerRepository volunteerRepository;
    private final MissionStatusRepository missionStatusRepository;

    private final MissionMapper missionMapper;

    @Override
    public MissionDto createMission(MissionForm missionForm) throws InvalidObjectException {

        List<Mission> missions = missionRepository.findAll();
        List<String> missionNames = missions.stream().map(Mission::getMissionName).toList();
        if (missionNames.contains(missionForm.getMissionName())) {
            throw new DuplicateKeyException("Mission with that name already exists.");
        }

        if ((missionForm.getPersonInNeedUsername() == null || missionForm.getPersonInNeedUsername().isEmpty()) && (missionForm.getVolunteerUsername() == null || missionForm.getVolunteerUsername().isEmpty()) ||
                ((missionForm.getPersonInNeedUsername() != null && !missionForm.getPersonInNeedUsername().isEmpty()) && (missionForm.getVolunteerUsername() != null && !missionForm.getVolunteerUsername().isEmpty()))){
            throw new InvalidObjectException("Form for mission creation is filled out incorrectly.");
        }

        Mission mission = missionMapper.mapFormToObject(missionForm);

        if (missionForm.getPersonInNeedUsername() != null && !missionForm.getPersonInNeedUsername().isEmpty()){
            PersonInNeed personInNeed = personInNeedRepository.findByUsername(missionForm.getPersonInNeedUsername()).orElseThrow(() ->
                    new EntityNotFoundException("Person in need with username: " + missionForm.getPersonInNeedUsername() + " not found."));
            mission.setPersonInNeed(personInNeed);
            mission.setMissionStatus(missionStatusRepository.getReferenceById(2L));
        }

        if (missionForm.getVolunteerUsername() != null && !missionForm.getVolunteerUsername().isEmpty()){
            Volunteer volunteer = volunteerRepository.findByUsername(missionForm.getVolunteerUsername()).orElseThrow(() ->
                    new EntityNotFoundException("Volunteer with username: " + missionForm.getVolunteerUsername() + " not found."));
            mission.setVolunteer(volunteer);
            mission.setMissionStatus(missionStatusRepository.getReferenceById(1L));
        }

        mission = missionRepository.save(mission);
        return missionMapper.mapObjectToDto(mission);
    }

    @Override
    public List<MissionDto> getAllMissions() {
        return missionRepository.findAll().stream().map(missionMapper::mapObjectToDto).toList();
    }

    @Override
    public List<MissionDto> getAllMissionsByMissionStatusName(MissionRequestDto missionRequestDto) {
        return missionRepository.findAllByMissionStatusName(missionRequestDto.getMissionStatusName())
                .stream().map(missionMapper::mapObjectToDto).toList();
    }
}

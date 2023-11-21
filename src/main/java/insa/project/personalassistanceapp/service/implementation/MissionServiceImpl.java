package insa.project.personalassistanceapp.service.implementation;

import insa.project.personalassistanceapp.mapper.MissionMapper;
import insa.project.personalassistanceapp.model.Mission;
import insa.project.personalassistanceapp.model.PersonInNeed;
import insa.project.personalassistanceapp.model.Volunteer;
import insa.project.personalassistanceapp.model.dto.MissionDto;
import insa.project.personalassistanceapp.model.dto.MissionForm;
import insa.project.personalassistanceapp.repository.MissionRepository;
import insa.project.personalassistanceapp.repository.MissionStatusRepository;
import insa.project.personalassistanceapp.repository.PersonInNeedRepository;
import insa.project.personalassistanceapp.repository.VolunteerRepository;
import insa.project.personalassistanceapp.service.MissionService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.InvalidObjectException;

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
        Mission mission = missionMapper.mapFormToObject(missionForm);

        if(missionForm.getPersonInNeedUsername() != null){
            PersonInNeed personInNeed = personInNeedRepository.findByUsername(missionForm.getPersonInNeedUsername()).orElseThrow(() ->
                    new EntityNotFoundException("Person in need with username: " + missionForm.getPersonInNeedUsername() + " not found."));
            mission.setPersonInNeed(personInNeed);
            mission.setMissionStatus(missionStatusRepository.getReferenceById(2L));
        }

        if(missionForm.getVolunteerUsername() != null){
            Volunteer volunteer = volunteerRepository.findByUsername(missionForm.getVolunteerUsername()).orElseThrow(() ->
                    new EntityNotFoundException("Volunteer with username: " + missionForm.getVolunteerUsername() + " not found."));
            mission.setVolunteer(volunteer);
            mission.setMissionStatus(missionStatusRepository.getReferenceById(1L));
        }

        if(mission.getPersonInNeed() == null && mission.getVolunteer() == null){
            throw new InvalidObjectException("Form for mission creation is filled out incorrectly.");
        }

        mission = missionRepository.save(mission);
        return missionMapper.mapObjectToDto(mission);
    }
}

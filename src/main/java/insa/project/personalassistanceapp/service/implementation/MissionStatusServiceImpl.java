package insa.project.personalassistanceapp.service.implementation;

import insa.project.personalassistanceapp.mapper.MissionStatusMapper;
import insa.project.personalassistanceapp.model.dto.MissionStatusDto;
import insa.project.personalassistanceapp.repository.MissionStatusRepository;
import insa.project.personalassistanceapp.service.MissionStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MissionStatusServiceImpl  implements MissionStatusService {

    private final MissionStatusRepository missionStatusRepository;

    private final MissionStatusMapper missionStatusMapper;

    @Override
    public List<MissionStatusDto> getAllMissionStatusNames() {
        return missionStatusRepository.findAll().stream().map(missionStatusMapper::mapObjectToDto).toList();
    }

}

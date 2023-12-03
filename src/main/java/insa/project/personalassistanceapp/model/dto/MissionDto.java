package insa.project.personalassistanceapp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MissionDto {
    private Long missionId;
    private PersonInNeedDto personInNeedDto;
    private VolunteerDto volunteerDto;
    private MissionStatusDto missionStatusDto;
    private String missionName;
    private String missionDescription;

}
